package com.example.football.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "stats")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportStatRootDto {

    @XmlElement(name = "stat")
    private List<ImportStatDto> stats;

    public List<ImportStatDto> getStats() {
        return stats;
    }

    public void setStats(List<ImportStatDto> stats) {
        this.stats = stats;
    }
}
