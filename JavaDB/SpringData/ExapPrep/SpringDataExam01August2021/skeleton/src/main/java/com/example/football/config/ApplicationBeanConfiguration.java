package com.example.football.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
//        modelMapper()
//                .typeMap(GameAddDto.class, Game.class)
//                .addMappings(mapper -> mapper.map(GameAddDto::getImageThumbnail, Game::setImageThumbnail));

//        Converter<String, LocalDate> dateConverter = new Converter<String, LocalDate>() {
//            @Override
//            public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
//                return LocalDate.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//            }
//        };
//        modelMapper().addConverter(dateConverter);
        modelMapper.addConverter(new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
                return LocalDate.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }
        });

        return modelMapper;
    }
}
