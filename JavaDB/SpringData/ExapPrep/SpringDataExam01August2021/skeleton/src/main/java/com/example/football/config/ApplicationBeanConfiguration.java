package com.example.football.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {

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
