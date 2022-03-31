package com.example.football.service.impl;

import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class StatServiceImpl implements StatService {

    private final StatRepository statRepository;

    public StatServiceImpl(StatRepository statRepository) {
        this.statRepository = statRepository;
    }

    @Override
    public boolean areImported() {
        return this.statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(Path.of("src/main/resources/files/xml/stats.xml"));
    }

    @Override
    public String importStats() {
        return null;
    }
}
