package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.ImportLaptopDto;
import exam.model.entity.Laptop;
import exam.repository.LaptopRepository;
import exam.service.LaptopService;
import exam.service.ShopService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class LaptopServiceImpl implements LaptopService {

    public static final String LAPTOPS_FILE_PATH = "src/main/resources/files/json/laptops.json";

    private final LaptopRepository laptopRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final ShopService shopService;

    public LaptopServiceImpl(LaptopRepository laptopRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson, ShopService shopService) {
        this.laptopRepository = laptopRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.shopService = shopService;
    }

    @Override
    public boolean areImported() {
        return laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files.readString(Path.of(LAPTOPS_FILE_PATH));
    }

    @Override
    public String importLaptops() throws IOException {

        ImportLaptopDto[] importLaptopDtos = gson.fromJson(readLaptopsFileContent(), ImportLaptopDto[].class);
        StringBuilder sb = new StringBuilder();
        for (ImportLaptopDto importLaptopDto : importLaptopDtos) {
            if (validationUtil.isValid(importLaptopDto)) {
                Laptop laptop = modelMapper.map(importLaptopDto, Laptop.class);
                if (laptopRepository.findByMacAddress(laptop.getMacAddress()).isEmpty()) {
                    laptop.setShop(shopService.findByName(importLaptopDto.getShop().getName()).get());
                    laptopRepository.save(laptop);
                    sb.append(String.format("Successfully imported Laptop %s - %.2f - %d - %d",
                            laptop.getMacAddress(), laptop.getCpuSpeed(), laptop.getRam(), laptop.getStorage()));
                } else {
                    sb.append("Invalid laptop");
                }
            } else {
                sb.append("Invalid laptop");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public String exportBestLaptops() {
        StringBuilder sb = new StringBuilder();
        laptopRepository.bestLaptopsExport().forEach(laptop -> {
            sb.append(laptop).append(System.lineSeparator());
        });
        return sb.toString();
    }
}
