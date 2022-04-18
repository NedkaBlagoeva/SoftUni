package softuni.exam.models.dto;

import softuni.exam.models.entity.DaysOfWeek;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "forecasts")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportForecastRootDto {

    @XmlElement(name = "forecast")
   private List<ImportForecastDto> forecasts;

    public List<ImportForecastDto> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<ImportForecastDto> forecasts) {
        this.forecasts = forecasts;
    }
}
