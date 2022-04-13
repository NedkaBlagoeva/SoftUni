package com.example.football.service.impl;

import com.example.football.models.dto.ImportStatRootDto;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class StatServiceImpl implements StatService {

    public static final String STATS_FILE_PATH = "src/main/resources/files/xml/stats.xml";

    private final StatRepository statRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public StatServiceImpl(StatRepository statRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.statRepository = statRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(Path.of(STATS_FILE_PATH));
    }

    @Override
    public String importStats() throws JAXBException, FileNotFoundException {
        ImportStatRootDto importStatRootDto = xmlParser.fromFile(STATS_FILE_PATH, ImportStatRootDto.class);
        StringBuilder sb = new StringBuilder();
        importStatRootDto.getStats().forEach(importStatDto -> {
            if (validationUtil.isValid(importStatDto)) {
                Stat stat = modelMapper.map(importStatDto, Stat.class);
                if (statRepository.findByEnduranceAndAndPassingAndShooting(
                        importStatDto.getEndurance(),
                        importStatDto.getPassing(),
                        importStatDto.getShooting()).isEmpty()) {

                    statRepository.save(stat);
                    sb.append(String.format("Successfully imported Stat %.2f - %.2f - %.2f",
                            stat.getShooting(),
                            stat.getPassing(),
                            stat.getEndurance()));
                } else {
                    sb.append("Invalid stat");
                }
            } else {
                sb.append("Invalid stat");
            }
            sb.append(System.lineSeparator());
        });
        return sb.toString();
    }

    @Override
    public Stat findById(Long id) {
        return statRepository.findById(id).orElse(null);
    }
}
