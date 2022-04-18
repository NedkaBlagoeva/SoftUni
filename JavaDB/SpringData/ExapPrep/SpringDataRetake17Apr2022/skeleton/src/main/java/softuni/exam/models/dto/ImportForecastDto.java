package softuni.exam.models.dto;

import softuni.exam.models.entity.DaysOfWeek;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ImportForecastDto {

    @XmlElement(name = "day_of_week")
    @NotNull
    private DaysOfWeek daysOfWeek;

    @XmlElement(name = "max_temperature")
    @Min(-20)
    @Max(60)
    @NotNull
    private Double maxTemperature;

    @XmlElement(name = "min_temperature")
    @Min(-50)
    @Max(40)
    @NotNull
    private Double minTemperature;

    @XmlElement
    @NotNull
    private String sunrise;

    @XmlElement
    @NotNull
    private String sunset;

    @XmlElement
    private Long city;

    public DaysOfWeek getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(DaysOfWeek daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }
}
