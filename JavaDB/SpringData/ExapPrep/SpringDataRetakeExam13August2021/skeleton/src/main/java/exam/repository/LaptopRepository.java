package exam.repository;

import exam.model.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {
    Optional<Laptop> findByMacAddress(String macAddress);

    @Query("select l from laptops l order by l.cpuSpeed desc , l.ram desc ,l.storage desc , l.macAddress")
    List<Laptop> bestLaptopsExport();


    //•	Order Them by the cpu speed in descending order,
    // Then by the ram in descending order,
    // then by the storage in descending order and
    // finally by the MAC Address
}
