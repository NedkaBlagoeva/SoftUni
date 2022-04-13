package com.example.football.service.impl;

import com.example.football.models.dto.ImportPlayerRootDto;
import com.example.football.models.entity.Player;
import com.example.football.repository.PlayerRepository;
import com.example.football.service.PlayerService;
import com.example.football.service.StatService;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

@Service
public class PlayerServiceImpl implements PlayerService {

    public static final String PLAYERS_FILE_PATH = "src/main/resources/files/xml/players.xml";

    private final PlayerRepository playerRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final TownService TownService;
    private final TeamService TeamService;
    private final StatService StatService;

    public PlayerServiceImpl(PlayerRepository playerRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil, com.example.football.service.TownService townService, com.example.football.service.TeamService teamService, com.example.football.service.StatService statService) {
        this.playerRepository = playerRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        TownService = townService;
        TeamService = teamService;
        StatService = statService;
    }

    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of(PLAYERS_FILE_PATH));
    }

    @Override
    public String importPlayers() throws JAXBException, FileNotFoundException {
        ImportPlayerRootDto importPlayerRootDto = xmlParser.fromFile(PLAYERS_FILE_PATH, ImportPlayerRootDto.class);
        StringBuilder sb = new StringBuilder();
        importPlayerRootDto.getPlayers().forEach(importPlayerDto -> {
            if (validationUtil.isValid(importPlayerDto)) {
                Player player = modelMapper.map(importPlayerDto, Player.class);
                if (playerRepository.findByEmail(player.getEmail()).isEmpty()) {
                    player.setTown(TownService.findByName(importPlayerDto.getTown().getName()).orElse(null));
                    player.setTeam(TeamService.findByName(importPlayerDto.getTeam().getName()));
                    player.setStat(StatService.findById(importPlayerDto.getStat().getId()));
                    playerRepository.save(player);
                    sb.append(String.format("Successfully imported Player %s %s - %s",
                            player.getFirstName(), player.getLastName(), player.getPosition()));
                } else {
                    sb.append("Invalid player");
                }

            } else {
                sb.append("Invalid player");
            }
            sb.append(System.lineSeparator());
        });
        return sb.toString();
    }

    @Override
    public String exportBestPlayers() {
        StringBuilder sb = new StringBuilder();
        playerRepository
                .bestPlayersExport(LocalDate.of(1995, 01,01), LocalDate.of( 2003, 01, 01))
                .forEach(player -> sb.append(player).append(System.lineSeparator()));

        return sb.toString();
    }
}
