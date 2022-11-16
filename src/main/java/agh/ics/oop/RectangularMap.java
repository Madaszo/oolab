package agh.ics.oop;

import java.util.Objects;

public class RectangularMap extends AbstractWorldMap{
    Vector2d[] map = new Vector2d[2];
    public RectangularMap(Integer width, Integer height){
        this.map[0]=new Vector2d(0,0);
        this.map[1]=new Vector2d(width,height);
    }

    public boolean canMoveTo(Vector2d position) {
        if (Objects.equals(map[1], map[1].upperRight(position))
                && Objects.equals(map[0], map[0].lowerLeft(position))){
            for (IMapElement object: objects){
                if(object.getPosition().equals(position)){
                    return false;
                }
            }
            return true;
        }else return false;
    }


    public boolean isOccupied(Vector2d position) {
        return !canMoveTo(position);
    }

}
