package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.Collection;

public class MissionImpl implements Mission{
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {

        for (Astronaut astronaut : astronauts) {
            while (astronaut.canBreath() && !planet.getItems().isEmpty()){
                astronaut.breath();
                String nextItem = planet.getItems().iterator().next();
                astronaut.getBag().getItems().add(nextItem);
                planet.getItems().remove(nextItem);
            }
        }
    }
}
