package softuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.DaysOfWeek;
import softuni.exam.models.entity.Forecast;

import java.util.List;
import java.util.Optional;

public interface ForecastRepository extends JpaRepository<Forecast, Long> {

    Optional<Forecast> findByCityAndAndDaysOfWeek(City city, DaysOfWeek daysOfWeek);

    @Query("select f from forecasts f where f.daysOfWeek = :daysOfWeek and f.city.population < 150000 order by f.maxTemperature desc, f.id")
    List<Forecast> export(DaysOfWeek daysOfWeek);

    //•	Filter only forecasts from sunday and from cities with less than 150000 citizens,
    // order them by max temperature in descending order, then by the forecast id in ascending order.
}
