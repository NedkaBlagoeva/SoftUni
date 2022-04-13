package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportApartmentRootDto;
import softuni.exam.models.entity.Apartment;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    public static final String APARTMENTS_FILE_PATH = "src/main/resources/files/xml/apartments.xml";

    private final ApartmentRepository apartmentRepository;
    private final TownService townService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    public ApartmentServiceImpl(ApartmentRepository apartmentRepository, TownService townService, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.apartmentRepository = apartmentRepository;
        this.townService = townService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(Path.of(APARTMENTS_FILE_PATH));
    }

    @Override
    public String importApartments() throws IOException, JAXBException {

        ImportApartmentRootDto importApartmentsRootDto = xmlParser.fromFile(APARTMENTS_FILE_PATH, ImportApartmentRootDto.class);
        StringBuilder sb = new StringBuilder();
        importApartmentsRootDto.getApartments().forEach(importApartmentDto -> {
            if (validationUtil.isValid(importApartmentDto)) {
                Apartment apartment = modelMapper.map(importApartmentDto, Apartment.class);
                apartment.setTown(townService.findByTownName(importApartmentDto.getTown()).orElse(null));
                //town name and area already exists in the DB return "Invalid apartment".
                if (this.apartmentRepository.findByTown_TownNameAndArea(apartment.getTown().getTownName(), apartment.getArea()) == null) {
                    apartmentRepository.save(apartment);
                    sb.append(String.format("Successfully imported apartment %s - %.2f",
                            apartment.getApartmentType(), apartment.getArea()));
                } else {
                    sb.append("Invalid apartment");
                }
            } else {
                sb.append("Invalid apartment");
            }
            sb.append(System.lineSeparator());
        });

        return sb.toString();
    }

}
