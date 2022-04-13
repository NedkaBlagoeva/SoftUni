package com.example.football.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "players")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportPlayerRootDto {

    @XmlElement(name = "player")
    List<ImportPlayerDto> players;

    public List<ImportPlayerDto> getPlayers() {
        return players;
    }

    public void setPlayers(List<ImportPlayerDto> players) {
        this.players = players;
    }
}
