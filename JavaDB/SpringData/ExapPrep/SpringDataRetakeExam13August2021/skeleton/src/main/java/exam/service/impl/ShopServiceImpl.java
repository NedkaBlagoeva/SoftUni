package exam.service.impl;

import exam.model.dto.ImportShopRootDto;
import exam.model.entity.Shop;
import exam.repository.ShopRepository;
import exam.service.ShopService;
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
public class ShopServiceImpl implements ShopService {

    private static final String SHOP_FILE_PATH = "src/main/resources/files/xml/shops.xml";

    private final ShopRepository shopRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final TownService townService;

    public ShopServiceImpl(ShopRepository shopRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil, TownService townService) {
        this.shopRepository = shopRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files.readString(Path.of(SHOP_FILE_PATH));
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {
        ImportShopRootDto importShopRootDto = xmlParser.fromFile(SHOP_FILE_PATH, ImportShopRootDto.class);
        StringBuilder sb = new StringBuilder();
        importShopRootDto.getShops().forEach(importShopDto -> {
            if (validationUtil.isValid(importShopDto)){
                Shop shop = modelMapper.map(importShopDto, Shop.class);
                if (shopRepository.findByName(importShopDto.getName()).isEmpty()){
                    shop.setTown(townService.findByName(importShopDto.getTown().getName()).get());
                    shopRepository.save(shop);
                    sb.append(String.format("Successfully imported Shop %s - %.0f ", shop.getName(), shop.getIncome()));
                } else {
                    sb.append("Invalid shop");
                }
            } else {
                sb.append("Invalid shop");
            }
            sb.append(System.lineSeparator());
        });
        return sb.toString();
    }

    @Override
    public Optional<Shop> findByName(String name) {
        return shopRepository.findByName(name);
    }
}
