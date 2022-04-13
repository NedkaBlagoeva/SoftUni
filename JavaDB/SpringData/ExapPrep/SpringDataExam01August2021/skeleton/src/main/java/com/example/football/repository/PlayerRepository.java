package com.example.football.repository;

import com.example.football.models.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findByEmail(String email);

    @Query("select p from players p where p.birthDate between :startDate and :endDate order by p.stat.shooting desc , p.stat.passing desc , p.stat.endurance desc , p.lastName")
        //Shooting in Desc Order, Then by Passing in Desc Order, Then by Endurance Desc Order and Finally Then by Player Last Name.
    List<Player> bestPlayersExport(LocalDate startDate, LocalDate endDate);
}
