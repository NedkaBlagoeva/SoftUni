package com.example.football.service.impl;

import com.example.football.models.dto.ImportTownDto;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final Gson gson;

    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
        this.gson = new GsonBuilder().create();
        this.validator = new Ver
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
        return null;
    }
}
