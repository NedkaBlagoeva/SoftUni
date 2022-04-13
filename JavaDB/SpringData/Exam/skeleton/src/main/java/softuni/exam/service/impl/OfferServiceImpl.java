package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AgentNameDto;
import softuni.exam.models.dto.ImportOfferRootDto;
import softuni.exam.models.entity.ApartmentType;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    public static final String OFFERS_FILE_PATH = "src/main/resources/files/xml/offers.xml";

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final AgentRepository agentRepository;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser, AgentRepository agentRepository) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.agentRepository = agentRepository;
    }

    @Override
    public boolean areImported() {
        return offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFERS_FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        ImportOfferRootDto importOfferRootDto = xmlParser.fromFile(OFFERS_FILE_PATH, ImportOfferRootDto.class);
        StringBuilder sb = new StringBuilder();
        importOfferRootDto.getOffers().forEach(importOfferDto -> {
            if (validationUtil.isValid(importOfferDto)) {
                Offer offer = modelMapper.map(importOfferDto, Offer.class);
                if (agentRepository.findByFirstName(importOfferDto.getAgent().getName()) != null) {
                    offer.setAgent(agentRepository.findByFirstName(importOfferDto.getAgent().getName()));
                    offerRepository.save(offer);
                    sb.append(String.format("Successfully imported offer %.2f", offer.getPrice()));
                } else {
                    sb.append("Invalid offer");
                }
            } else {
                sb.append("Invalid offer");
            }
            sb.append(System.lineSeparator());
        });

        return sb.toString();
    }

    @Override
    public String exportOffers() {
        StringBuilder sb = new StringBuilder();
        List<Offer> bestOffers = this.offerRepository.exportBestOffers(ApartmentType.three_rooms);
        for (Offer offer : bestOffers) {
            sb.append(offer.toString())
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}
