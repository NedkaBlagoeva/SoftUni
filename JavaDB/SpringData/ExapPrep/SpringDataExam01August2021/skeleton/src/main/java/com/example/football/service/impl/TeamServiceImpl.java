package com.example.football.service.impl;

import com.example.football.models.dto.ImportTeamDto;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.TeamService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final Validator validator;
    private final TownRepository townRepository;


    public TeamServiceImpl(TeamRepository teamRepository, TownRepository townRepository) {
        this.teamRepository = teamRepository;
        this.townRepository = townRepository;
        this.modelMapper = new ModelMapper();
        this.gson = new GsonBuilder().create();
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();

    }

    @Override
    public boolean areImported() {
        return this.teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(Path.of("src/main/resources/files/json/teams.json"));
    }

    @Override
    public String importTeams() throws IOException {
        String json = this.readTeamsFileContent();
        ImportTeamDto[] importTeamDtos = this.gson.fromJson(json, ImportTeamDto[].class);
        List<String> result = new ArrayList<>();
        for (ImportTeamDto importTeamDto : importTeamDtos) {
            Set<ConstraintViolation<ImportTeamDto>> violations = this.validator.validate(importTeamDto);
            if (violations.isEmpty()) {
                if (this.teamRepository.findByName(importTeamDto.getName()).isPresent()) {
                    result.add("Invalid Team");
                } else {
                    Team team = modelMapper.map(importTeamDto, Team.class);
                    Town town = this.townRepository.findByName(importTeamDto.getTownName()).get();
                    team.setTown(town);

                    this.teamRepository.save(team);
                    result.add(String.format("Successfully imported Team %s - %d%n", team.getName(), team.getFanBase()));
                }
            } else {
                result.add("Invalid Team");
            }
        }
        return String.join("\n", result);
    }

    @Override
    public Team findByName(String name) {
        return teamRepository.findByName(name).orElse(null);
    }
}
