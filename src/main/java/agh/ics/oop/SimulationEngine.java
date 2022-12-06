package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{
    MoveDirection[] directions;
    AbstractWorldMap map;
    List<Animal> animals = new ArrayList<>();

    public SimulationEngine(MoveDirection[] directions, AbstractWorldMap map, Vector2d[] positions, IPositionChangeObserver observer){
        this.directions = directions;
        this.map = map;
        for (Vector2d position: positions) {
            Animal animal = new Animal(this.map,position);
            animals.add(animal);
            animal.addObserver(observer);
            animal.addObserver(this.map.boundary);
        }
    }
    
    public void run() {
        int i = 0;
        int mod = animals.size();
        for(MoveDirection direction: this.directions) {
            System.out.println(map);
            animals.get(i).move(direction);
            System.out.println(animals.get(i).getPosition());
            i++;
            i = i % mod;
        }
    }
}
