package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;
import spaceStation.repositories.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private final Repository<Astronaut> astronautsRepo;
    private final Repository<Planet> planetsRepo;
    private int countPlanet;

    public ControllerImpl() {
        this.astronautsRepo = new AstronautRepository();
        this.planetsRepo = new PlanetRepository();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }
        astronautsRepo.add(astronaut);
        return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        planet.getItems().addAll(Arrays.asList(items));
        planetsRepo.add(planet);
        return String.format(ConstantMessages.PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = astronautsRepo.findByName(astronautName);
        if (astronaut == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
        } else {
            astronautsRepo.remove(astronaut);
        }
        return String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        List<Astronaut> astronautList = astronautsRepo.getModels().stream()
                .filter(a -> a.getOxygen() > 60).collect(Collectors.toList());
        if (astronautList.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        Mission mission = new MissionImpl();
        Planet planet = planetsRepo.findByName(planetName);
        mission.explore(planet, astronautList);
        countPlanet++;

        List<Astronaut> diedAstronauts = astronautList.stream()
                .filter(a -> a.getOxygen() == 0).collect(Collectors.toList());

        return String.format(ConstantMessages.PLANET_EXPLORED, planetName, diedAstronauts.size());
    }

    @Override
    public String report() {
        StringBuilder report = new StringBuilder();

        report
                .append(String.format(ConstantMessages.REPORT_PLANET_EXPLORED, countPlanet))
                .append(System.lineSeparator())
                .append(ConstantMessages.REPORT_ASTRONAUT_INFO)
                .append(System.lineSeparator());

        for (Astronaut astronaut : astronautsRepo.getModels()) {

            report
                    .append(String.format(ConstantMessages.REPORT_ASTRONAUT_NAME, astronaut.getName()))
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages.REPORT_ASTRONAUT_OXYGEN, astronaut.getOxygen()))
                    .append(System.lineSeparator());

            if (astronaut.getBag().getItems().isEmpty()) {

                report
                        .append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, "none"))
                        .append(System.lineSeparator());
            } else {
                String items = String.join(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, astronaut.getBag().getItems());

                report
                        .append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, items))
                        .append(System.lineSeparator());
            }
        }
        return report.toString();
    }
}
