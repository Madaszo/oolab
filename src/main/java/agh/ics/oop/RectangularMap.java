package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RectangularMap implements IWorldMap{
    Vector2d[] map = new Vector2d[2];
    List<Animal> animals = new ArrayList<>();
    public RectangularMap(Integer width, Integer height){
        this.map[0]=new Vector2d(0,0);
        this.map[1]=new Vector2d(width,height);
    }

    public boolean canMoveTo(Vector2d position) {
        if (Objects.equals(map[1], map[1].upperRight(position))
                && Objects.equals(map[0], map[0].lowerLeft(position))){
            for (Animal animal: animals){
                if(animal.isAt(position)){
                    return false;
                }
            }
            return true;
        }else return false;
    }

    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())) {
            animals.add(animal);
            return true;
        }
        else return false;
    }

    public boolean isOccupied(Vector2d position) {
        return !canMoveTo(position);
    }

    public Object objectAt(Vector2d position) {
        for (Animal animal: animals){
            if(animal.isAt(position)){
                return animal;
            }
        }
        return null;
    }
    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(this.map[0],this.map[1]);
    }
}
