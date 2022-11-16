package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap {
    protected List<IMapElement> objects = new ArrayList<>();
    public boolean place(IMapElement object) {
        if(canMoveTo(object.getPosition())) {
            objects.add(object);
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
        Object w = null;
        for (IMapElement object:objects){
            if(object.getPosition().equals(position)&&!object.toString().equals("*")){
                return object;
            }
            if(object.getPosition().equals(position)){
                w = object;
            }
        }
        return w;
    }
    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        Vector2d ll = objects.get(0).getPosition();
        Vector2d ur = objects.get(0).getPosition();

        for(IMapElement object:objects){
            ll = ll.lowerLeft(object.getPosition());
            ur = ur.upperRight(object.getPosition());
        }
        return visualizer.draw(ll,ur);
    }
}