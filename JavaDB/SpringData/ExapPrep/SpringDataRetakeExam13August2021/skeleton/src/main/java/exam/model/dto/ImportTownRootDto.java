package exam.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "towns")
public class ImportTownRootDto {

    @XmlElement(name = "town")
    List<ImportTownDto> towns;

    public List<ImportTownDto> getTowns() {
        return towns;
    }

    public void setTowns(List<ImportTownDto> towns) {
        this.towns = towns;
    }
}
