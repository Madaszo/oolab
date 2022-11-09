package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{
    MoveDirection[] directions;
    IWorldMap map;
    List<Animal> animals = new ArrayList<>();

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions){
        this.directions = directions;
        this.map = map;
        for (Vector2d position: positions) {
            animals.add(new Animal(map,position));
        }
        for(Animal animal: animals){
            map.place(animal);
        }
    }
    
    public void run() {
        int i = 0;
        int mod = animals.size();
        for(MoveDirection direction: this.directions) {
            animals.get(i).move(direction);
            i++;
            i = i % mod;
        }
    }
}
