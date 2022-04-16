package softuni.exam.instagraphlite.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import softuni.exam.instagraphlite.models.Picture;

public interface PictureRepository extends JpaRepository<Picture, Integer> {
}
