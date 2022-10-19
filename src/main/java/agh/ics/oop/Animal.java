package agh.ics.oop;

import java.util.Objects;

public class Animal {
    private final Vector2d[] map = new Vector2d[2];
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    public Animal(){
        this.map[0] = new Vector2d(0,0);
        this.map[1] = new Vector2d(4,4);
    }

    public String toString() {
        return "("+this.position + "," + this.direction + ")";
    }
    public boolean isAt(Vector2d position){
        return Objects.equals(this.position, position);
    }
    public void move(MoveDirection direction){
        switch (direction) {
            case LEFT -> this.direction = this.direction.previous();
            case RIGHT -> this.direction = this.direction.next();
            case FORWARD -> {
                Vector2d tmp = this.direction.toUnitVector().add(this.position);
                if((Objects.equals(this.map[0], this.map[0].lowerLeft(tmp)))
                    && (Objects.equals(this.map[1], this.map[1].upperRight(tmp)))) {
                        this.position = this.position.add(this.direction.toUnitVector());
                    }
            }
            case BACKWARD -> {
                Vector2d tmp = this.direction.toUnitVector().opposite().add(this.position);
                if((Objects.equals(this.map[0], this.map[0].lowerLeft(tmp)))
                    && (Objects.equals(this.map[1], this.map[1].upperRight(tmp)))) {
                        this.position = this.position.add(this.direction.toUnitVector().opposite());
                }
            }
            case IGNORE -> {
            }
        }
    }
}
