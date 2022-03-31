package com.example.ex.service.impl;

import com.example.ex.model.dto.GameAddDto;
import com.example.ex.model.entities.Game;
import com.example.ex.repository.GameRepository;
import com.example.ex.service.GameService;
import com.example.ex.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final UserServiceImpl userService;

    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper, ValidationUtil validationUtil, UserServiceImpl userService) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.userService = userService;
    }

    @Override
    public void addGame(GameAddDto gameAddDto) {

        if (userCantEdit()) return;

        Set<ConstraintViolation<GameAddDto>> violations = validationUtil.violation(gameAddDto);

        if (!violations.isEmpty()) {
            violations.stream().map(ConstraintViolation::getMessage).forEach(System.out::println);
            return;
        }

        Game game = modelMapper.map(gameAddDto, Game.class);
        gameRepository.save(game);
        System.out.println("Game added");
    }

    private boolean userCantEdit() {
        if (userService.getLoggedUser() == null){
            System.out.println("No user is logged in.");
            return true;
        }
        if (!userService.getLoggedUser().getAdmin()){
            System.out.println("Logged in user is not admin");
            return true;
        }
        return false;
    }

    @Override
    public void editGame(Long id, BigDecimal price,Double size ) {

        if (userCantEdit()) return;

        Game game = gameRepository.findById(id).orElse(null);
        if (game == null){
            System.out.println("Wrong id");
            return;
        }
        game.setSize(size);
        game.setPrice(price);
        gameRepository.save(game);
        System.out.println("Edited " + game.getTitle());
    }

    @Override
    public void deleteGame(long id) {

        if (userCantEdit()) return;

        Game game = gameRepository.findById(id).orElse(null);
        if (game == null){
            System.out.println("Wrong id");
            return;
        }

        gameRepository.delete(game);
        System.out.println("Deleted " + game.getTitle());
    }
}
