package agh.ics.oop;

import javafx.application.Platform;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements Runnable{
    MoveDirection[] directions;
    public AbstractWorldMap map;
    List<Animal> animals = new ArrayList<>();
    int i=0;

    public SimulationEngine(MoveDirection[] directions, AbstractWorldMap map, Vector2d[] positions, IPositionChangeObserver observer){
        this.directions = directions;
    }
    public SimulationEngine(AbstractWorldMap map, Vector2d[] positions, IPositionChangeObserver observer){
        this.map = map;
        for (Vector2d position: positions) {
            Animal animal = new Animal(this.map,position);
            animals.add(animal);
            animal.addObserver(observer);
            animal.addObserver(this.map.boundary);
        }
    }

    public void setDirections(MoveDirection[] directions) {
        this.directions = directions;
    }

    public void addObservers(IPositionChangeObserver observer){
        for( Animal animal: animals){
            animal.addObserver(observer);
        }
    }

    public void run() {
        int i = 0;
        int mod = animals.size();
        for(MoveDirection direction: this.directions) {
            System.out.println(map);
            try {
                animals.get(i).move(direction);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(animals.get(i).getPosition());
            i++;
            i = i % mod;
        }
    }
}
