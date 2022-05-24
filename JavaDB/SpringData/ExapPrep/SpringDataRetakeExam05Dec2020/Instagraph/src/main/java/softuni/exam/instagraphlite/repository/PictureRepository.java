package softuni.exam.instagraphlite.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import softuni.exam.instagraphlite.models.entity.Picture;

import java.util.Optional;

public interface PictureRepository extends JpaRepository<Picture, Integer> {

    Optional<Picture> findByPath(String path);
}
