package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap {
    protected Map<Vector2d,IMapElement> objects = new HashMap<>();
    public boolean place(IMapElement object) {
        if(canMoveTo(object.getPosition())) {
            objects.put(object.getPosition(),object);
            return true;
        }
        else return false;
    }

    public boolean eat(Vector2d position) {
        return false;
    }
    public void grassify(){
    }

    public Object objectAt(Vector2d position) {
        return  objects.get(position);
    }
    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        Vector2d ll = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
        Vector2d ur = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);
        for(Map.Entry<Vector2d, IMapElement> entry : objects.entrySet()) {
            Vector2d key = entry.getKey();
            IMapElement value = entry.getValue();
            ll=ll.lowerLeft(value.getPosition());
            ur=ur.upperRight(value.getPosition());

        return visualizer.draw(ll,ur);
    }
}