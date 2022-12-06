package agh.ics.oop;

import java.util.Random;
import java.lang.Math;

public class GrassField extends AbstractWorldMap implements IPositionChangeObserver{

    private final int grasses;
    public GrassField(int grasses){
        Random rand = new Random();
        this.grasses = grasses;
        for (int i = 0; i < grasses; i++) {
            boolean b;
            Grass g;
            do {
                g = new Grass(new Vector2d(rand.nextInt((int) Math.sqrt(10*grasses)),
                        rand.nextInt((int) Math.sqrt(10*grasses))));
                b = canMoveTo(g.getPosition());
            }while (!b);
            place(g);
        }
    }

    public boolean eat(Vector2d position){
        Object object = this.objectAt(position);
        if (object != null && object.getClass()==Grass.class){
            objects.remove(position);
            return true;
        }
        else if(object == null){
            return true;
        } else throw new IllegalArgumentException(position + " is already taken");
    }

    public void grassify() {
        Random rand = new Random();
        boolean b;
        Grass g;
        do {
            g = new Grass(new Vector2d(rand.nextInt((int) Math.sqrt(10*grasses)),
                    rand.nextInt((int) Math.sqrt(10*grasses))));
            b = canMoveTo(g.getPosition());
        }while (!b);
        place(g);
    }

    @Override
    public Vector2d ll() {
        return boundary.ll();
    }
    @Override
    public Vector2d ur() {
        return boundary.ur();
    }







}
