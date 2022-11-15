package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap {
    protected List<Animal> animals = new ArrayList<>();
    protected List<Grass> grasses = new ArrayList<>();
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())) {
            animals.add(animal);
            return true;
        }
        else return false;
    }
    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        Vector2d ll;
        Vector2d ur;
        if(animals.isEmpty()){
            ll = grasses.get(0).getPosition();
            ur = grasses.get(0).getPosition();
        }
        else{
            ll = animals.get(0).getPosition();
            ur = animals.get(0).getPosition();
        }
        for(Animal animal:animals){
            ll = ll.lowerLeft(animal.getPosition());
            ur = ur.upperRight(animal.getPosition());
        }
        for (Grass grass:grasses){
            ll = ll.lowerLeft(grass.getPosition());
            ur = ur.upperRight(grass.getPosition());
        }
        return visualizer.draw(ll,ur);
    }
}