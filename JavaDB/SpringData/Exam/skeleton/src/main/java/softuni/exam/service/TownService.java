package softuni.exam.service;

import softuni.exam.models.entity.Town;

import java.io.IOException;
import java.util.Optional;

public interface TownService {

    boolean areImported();

    String readTownsFileContent() throws IOException;
	
	String importTowns() throws IOException;

   Optional<Town> findByTownName(String name);
}
