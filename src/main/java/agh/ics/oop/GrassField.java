package agh.ics.oop;

import java.util.Random;
import java.lang.Math;

public class GrassField extends AbstractWorldMap{


    public GrassField(int grasses){
        Random rand = new Random();
        for (int i = 0; i < grasses; i++) {
            while (!placeGrass(new Grass(new Vector2d(rand.nextInt((int) Math.sqrt(10*grasses)),
                    rand.nextInt((int) Math.sqrt(10*grasses)))))){
            }
        }

    }
    public boolean placeGrass(Grass grass){
        if (!this.isOccupied(grass.getPosition())) {
            this.grasses.add(grass);
            return true;
        }
        return false;
    }
    public boolean canMoveTo(Vector2d position) {
        for (Animal animal: animals){
            if(animal.isAt(position)){
                return false;
            }
        }
        return true;
    }


    public boolean isOccupied(Vector2d position) {
        for (Animal animal: animals){
            if(animal.isAt(position)){
                return true;
            }
        }
        for (Grass grass: grasses){
            if(grass.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    public Object objectAt(Vector2d position) {
        for (Animal animal: animals){
            if(animal.isAt(position)){
                return animal;
            }
        }
        for (Grass grass: grasses){
            if (grass.getPosition().equals(position)){
                return grass;
            }
        }
        return null;
    }

}
