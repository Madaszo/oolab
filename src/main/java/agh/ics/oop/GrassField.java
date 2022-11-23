package agh.ics.oop;

import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.lang.Math;

public class GrassField extends AbstractWorldMap implements IPositionChangeObserver{

    private final int grasses;
    public GrassField(int grasses){
        Random rand = new Random();
        this.grasses = grasses;
        for (int i = 0; i < grasses; i++) {
            while (!place(new Grass(new Vector2d(rand.nextInt((int) Math.sqrt(10*grasses)),
                    rand.nextInt((int) Math.sqrt(10*grasses)))))){
                System.out.println("lol");
            }
        }
    }

    public boolean eat(Vector2d position){
        Object object = this.objectAt(position);
        if (object != null){
            objects.remove(position);
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

    @Override
    public Vector2d ll() {
        Vector2d ll = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (Map.Entry<Vector2d, IMapElement> entry : objects.entrySet()) {
            IMapElement value = entry.getValue();
            ll = ll.lowerLeft(value.getPosition());
        }
        return ll;
    }
    @Override
    public Vector2d ur() {
        Vector2d ur = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for (Map.Entry<Vector2d, IMapElement> entry : objects.entrySet()) {
            IMapElement value = entry.getValue();
            ur = ur.upperRight(value.getPosition());
        }
        return ur;
    }
    public boolean canMoveTo(Vector2d position) {
        return (objects.get(position) == null) || (Objects.equals(objects.get(position).toString(), "*"));
    }






}
