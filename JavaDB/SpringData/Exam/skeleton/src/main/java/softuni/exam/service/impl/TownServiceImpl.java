package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportTownDto;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class TownServiceImpl implements TownService {

    public static final String TOWNS_FILE_PATH = "src/main/resources/files/json/towns.json";

    private final TownRepository townRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public TownServiceImpl(TownRepository townRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWNS_FILE_PATH));
    }

    @Override
    public String importTowns() throws IOException {
        String json = readTownsFileContent();
        ImportTownDto[] importTownDtos = gson.fromJson(json, ImportTownDto[].class);
        StringBuilder sb = new StringBuilder();
        for (ImportTownDto importTownDto : importTownDtos) {
            if (validationUtil.isValid(importTownDto)) {
                Town town = modelMapper.map(importTownDto, Town.class);
                townRepository.save(town);
                sb.append(String.format("Successfully imported town %s - %d", town.getTownName(), town.getPopulation()));
            } else {
                sb.append("Invalid town");
            }
            sb.append(System.lineSeparator());
        }


        return sb.toString().trim();
    }

    @Override
    public Optional<Town> findByTownName(String name) {
        return townRepository.findByTownName(name);
    }
}
