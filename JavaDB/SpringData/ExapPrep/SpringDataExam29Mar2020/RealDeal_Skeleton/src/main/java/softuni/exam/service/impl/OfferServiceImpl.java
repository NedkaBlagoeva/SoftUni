package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportOfferRootDto;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.OfferService;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class OfferServiceImpl implements OfferService {

    public static final String OFFER_FILE_PATH = "src/main/resources/files/xml/offers.xml";

    private final OfferRepository offerRepository;
    private final CarService carService;
    private final SellerService sellerService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    public OfferServiceImpl(OfferRepository offerRepository, CarService carService, SellerService sellerService, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.offerRepository = offerRepository;
        this.carService = carService;
        this.sellerService = sellerService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFER_FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        ImportOfferRootDto importOfferRootDto = xmlParser.fromFile(OFFER_FILE_PATH, ImportOfferRootDto.class);
        StringBuilder sb = new StringBuilder();
        importOfferRootDto.getOffers().forEach(importOfferDto -> {
            if (validationUtil.isValid(importOfferDto)){
                Offer offer = modelMapper.map(importOfferDto, Offer.class);
                offer.setCar(carService.findById(importOfferDto.getCar().getId()));
                offer.setSeller(sellerService.findById(importOfferDto.getSeller().getId()));
                offerRepository.save(offer);
                sb.append(String.format("Successfully import offer %s - %s", offer.getAddedOn(), offer.isHasGoldStatus()));

            } else {
                sb.append("Invalid offer");
            }
            sb.append(System.lineSeparator());
        });

        return sb.toString();
    }
}
