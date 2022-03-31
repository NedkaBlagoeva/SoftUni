package com.example.ex;

import com.example.ex.model.dto.GameAddDto;
import com.example.ex.model.dto.UserLoginDto;
import com.example.ex.model.dto.UserRegisterDto;
import com.example.ex.service.GameService;
import com.example.ex.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

   private final Scanner scan;
   private final UserService userService;
   private final GameService gameService;

    public CommandLineRunnerImpl(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
        this.scan = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {

        while (true){
            System.out.println("Enter command: ");
            String [] commands = scan.nextLine().split("\\|");

            switch (commands[0]){
                // RegisterUser|<email>|<password>|<confirmPassword>|<fullName>
                case "RegisterUser" -> userService.registerUser(new UserRegisterDto(
                        commands[1], commands[2], commands[3], commands[4]
                ));
                // LoginUser|<email>|<password>
                case "LoginUser" -> userService.loginUser(new UserLoginDto(
                        commands[1], commands[2]));
                case "Logout" -> userService.logoutUser();
                case "AddGame" -> gameService.addGame(new GameAddDto(
                        commands[1], new BigDecimal(commands[2]), Double.parseDouble(commands[3]),
                        commands[4], commands[5], commands[6],
                        LocalDate.parse(commands[7], DateTimeFormatter.ofPattern("dd-MM-yyyy")))
                );
                case "EditGame" -> gameService
                        .editGame(Long.parseLong(commands[1]), new BigDecimal(commands[2]), Double.parseDouble(commands[3]) );
                //todo change this case

                case "DeleteGame" -> gameService.deleteGame(Long.parseLong(commands[1]));
            }
        }
    }
}
