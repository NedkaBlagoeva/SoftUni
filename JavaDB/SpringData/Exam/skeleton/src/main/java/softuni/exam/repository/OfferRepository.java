package softuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import softuni.exam.models.entity.ApartmentType;
import softuni.exam.models.entity.Offer;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {

    @Query("SELECT o FROM offers o where o.apartment.apartmentType = :type order by o.apartment.area desc ,o.price")
    List<Offer> exportBestOffers(ApartmentType type);
}
