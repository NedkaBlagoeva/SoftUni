package exam.service.impl;

import exam.model.dto.ImportTownRootDto;
import exam.model.entity.Town;
import exam.repository.TownRepository;
import exam.service.TownService;
import exam.util.ValidationUtil;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class TownServiceImpl implements TownService {

    public static final String TOWN_FILE_PATH = "src/main/resources/files/xml/towns.xml";

    private final TownRepository townRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public TownServiceImpl(TownRepository townRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWN_FILE_PATH));
    }

    @Override
    public String importTowns() throws JAXBException, FileNotFoundException {

        ImportTownRootDto importTownRootDto = xmlParser.fromFile(TOWN_FILE_PATH, ImportTownRootDto.class);
        StringBuilder sb = new StringBuilder();
        importTownRootDto.getTowns().forEach(importTownDto -> {
            if (validationUtil.isValid(importTownDto)){
                Town town = modelMapper.map(importTownDto, Town.class);
                townRepository.save(town);
                sb.append(String.format("Successfully imported Town %s", town.getName()));
            } else {
                sb.append("Invalid town");
            }
            sb.append(System.lineSeparator());
        });

        return sb.toString();
    }

    @Override
    public Optional<Town> findByName(String name) {
        return townRepository.findByName(name);
    }
}
