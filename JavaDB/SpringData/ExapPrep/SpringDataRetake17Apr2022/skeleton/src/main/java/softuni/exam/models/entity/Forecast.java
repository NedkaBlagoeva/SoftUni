package softuni.exam.models.entity;

import javax.persistence.*;
import java.sql.Time;

@Entity(name = "forecasts")
public class Forecast extends BaseEntity{

    @Enumerated(value = EnumType.STRING)
    private DaysOfWeek daysOfWeek;

    @Column(name = "max_temperature", nullable = false)
    private Double maxTemperature;

    @Column(name = "min_temperature", nullable = false)
    private Double minTemperature;

    @Column(nullable = false)
    private Time sunrise;

    @Column(nullable = false)
    private Time sunset;

    @ManyToOne
    private City city;

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

    public Time getSunrise() {
        return sunrise;
    }

    public void setSunrise(Time sunrise) {
        this.sunrise = sunrise;
    }

    public Time getSunset() {
        return sunset;
    }

    public void setSunset(Time sunset) {
        this.sunset = sunset;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return String.format("City: %s:\n" +
                "   \t\t-min temperature: %.2f\n" +
                "   \t\t--max temperature: %.2f\n" +
                "   \t\t---sunrise: %s\n" +
                "   \t\t----sunset: %s\n",
                city.getCityName(), minTemperature, maxTemperature, sunrise, sunset);
    }
}
