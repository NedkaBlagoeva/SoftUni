package com.example.football.service.impl;

import com.example.football.models.dto.ImportTownDto;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
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
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final Gson gson;
    private final Validator validator;
    private final ModelMapper modelMapper;

    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
        this.gson = new GsonBuilder().create();
        this.modelMapper = new ModelMapper();

    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {


        return String.join("\n", Files.readAllLines(Path.of("src/main/resources/files/json/towns.json")));
    }

    @Override
    public String importTowns() throws IOException {

        String json = this.readTownsFileContent();
        ImportTownDto[] importTownDtos = this.gson.fromJson(json, ImportTownDto[].class);
        List<String> result = new ArrayList<>();
        for (ImportTownDto importTownDto : importTownDtos) {
            Set<ConstraintViolation<ImportTownDto>> violations = this.validator.validate(importTownDto);

            if (violations.isEmpty()) {
                if (this.townRepository.findByName(importTownDto.getName()).isEmpty()){
                    Town town = this.modelMapper.map(importTownDto, Town.class);
                    this.townRepository.save(town);
                    result.add(String.format("Successfully imported Town %s - %d%n", town.getName(), town.getPopulation()));
                } else {
                    result.add("Invalid Town");
                }
            } else {
                result.add("Invalid Town");
            }
        }

        return String.join("\n", result);
    }
}

