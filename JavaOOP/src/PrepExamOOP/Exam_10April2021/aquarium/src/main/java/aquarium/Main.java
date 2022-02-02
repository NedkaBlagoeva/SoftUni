package main.java.aquarium;

//import aquarium.core.Engine;
//import aquarium.core.EngineImpl;
import main.java.aquarium.core.Engine;
import main.java.aquarium.core.EngineImpl;


public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
