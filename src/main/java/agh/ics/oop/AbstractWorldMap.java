package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap{
    protected Map<Vector2d,IMapElement> objects = new HashMap<>();
    public boolean place(IMapElement object) {
        if(canMoveTo(object.getPosition())) {
            objects.put(object.getPosition(),object);
            return true;
        }
        else return false;
    }
    public boolean isOccupied(Vector2d position) {
        return objects.get(position) != null;
    }
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        IMapElement object = objects.get(oldPosition);
        objects.remove(oldPosition);
        objects.put(newPosition,object);
    }


    public boolean eat(Vector2d position) {
        return false;
    }
    public void grassify(){
    }

    public Object objectAt(Vector2d position) {
        return  objects.get(position);
    }
    public abstract Vector2d ll();
    public abstract Vector2d ur();


    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        Vector2d ll = ll();
        Vector2d ur = ur();
        return visualizer.draw(ll,ur);
    }
}