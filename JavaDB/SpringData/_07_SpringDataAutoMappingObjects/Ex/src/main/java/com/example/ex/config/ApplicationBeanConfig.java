package com.example.ex.config;

import com.example.ex.model.dto.GameAddDto;
import com.example.ex.model.entities.Game;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Configuration
public class ApplicationBeanConfig {

    @Bean
    public ModelMapper modelMapper() {
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

        return new ModelMapper();
    }
}
