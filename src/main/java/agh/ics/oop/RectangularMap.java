package agh.ics.oop;

import java.util.Objects;

public class RectangularMap extends AbstractWorldMap implements IPositionChangeObserver{
    Vector2d[] map = new Vector2d[2];
    public RectangularMap(Integer width, Integer height){
        this.map[0]=new Vector2d(0,0);
        this.map[1]=new Vector2d(width,height);
    }

    @Override
    public Vector2d ll() {
        return map[0];
    }
    public Vector2d ur(){
        return map[1];
    }

    public boolean canMoveTo(Vector2d position) {
        if (Objects.equals(map[1], map[1].upperRight(position))
                && Objects.equals(map[0], map[0].lowerLeft(position))){
            return objects.get(position) == null;
        }else return false;
    }
}
