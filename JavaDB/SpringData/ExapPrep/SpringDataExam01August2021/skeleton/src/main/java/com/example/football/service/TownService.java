package com.example.football.service;


import com.example.football.models.entity.Town;

import java.io.IOException;
import java.util.Optional;

//ToDo - Implement all methods
public interface TownService {

    boolean areImported();

    String readTownsFileContent() throws IOException;
	
	String importTowns() throws IOException;

    Optional<Town> findByName(String name);

}
