package agh.ics.oop;

import java.util.Random;
import java.lang.Math;

public class GrassField extends AbstractWorldMap{

    private final int grasses;
    public GrassField(int grasses){
        Random rand = new Random();
        this.grasses = grasses;
        for (int i = 0; i < grasses; i++) {
            while (!place(new Grass(new Vector2d(rand.nextInt((int) Math.sqrt(10*grasses)),
                    rand.nextInt((int) Math.sqrt(10*grasses)))))){
            }
        }

    }
    public boolean eat(Vector2d position){
        Object object = this.objectAt(position);
        if (object != null){
            objects.remove(object);
            return true;
        }
        return false;
    }

    public void grassify() {
        Random rand = new Random();
        while(!super.place(new Grass(new Vector2d(rand.nextInt((int) Math.sqrt(10*grasses)),
                rand.nextInt((int) Math.sqrt(10*grasses)))))){
        }
    }


    public boolean canMoveTo(Vector2d position) {
        for (IMapElement object: objects){
            if(object.getPosition().equals(position)&&!object.toString().equals("*")){
                return false;
            }
        }
        return true;
    }


    public boolean isOccupied(Vector2d position) {
        for (IMapElement object: objects){
            if(object.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }



}
