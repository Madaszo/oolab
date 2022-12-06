package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

abstract class AbstractWorldMap implements IWorldMap{
    public Map<Vector2d,IMapElement> objects = new HashMap<>();
    public MapBoundary boundary = new MapBoundary();
    public boolean place(IMapElement object) {
        if(canMoveTo(object.getPosition())) {
            objects.put(object.getPosition(),object);
            boundary.addElement(object);
            return true;
        }
        else throw new IllegalArgumentException(object.getPosition() + " is already taken");
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

    public boolean canMoveTo(Vector2d position) {
        return (objects.get(position) == null) || (Objects.equals(objects.get(position).getClass(),Grass.class));
    }
}