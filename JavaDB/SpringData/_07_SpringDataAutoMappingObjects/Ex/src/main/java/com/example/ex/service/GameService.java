package com.example.ex.service;

import com.example.ex.model.dto.GameAddDto;

import java.math.BigDecimal;

public interface GameService {
    void addGame(GameAddDto gameAddDto);

    void editGame(Long id,  BigDecimal price, Double size);

    void deleteGame(long id);
}
