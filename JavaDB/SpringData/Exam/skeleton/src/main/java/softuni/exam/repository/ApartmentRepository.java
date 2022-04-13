package softuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import softuni.exam.models.entity.Apartment;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

    Apartment findByTown_TownNameAndArea(String townName, Double area);
}
