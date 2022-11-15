package agh.ics.oop;

import java.util.Objects;

public class Animal {
    private final IWorldMap map;
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position;
    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
        this.map.place(this);
    }

    public String toString() {
        switch (this.direction){
            case NORTH -> {
                return "^";
            }
            case SOUTH -> {
                return "v";
            }
            case WEST -> {
                return "<";
            }
            case EAST -> {
                return ">";
            }
            default -> throw new IllegalStateException("Unexpected value: " + this.direction);
        }

    }
    public Vector2d getPosition(){
        return this.position;
    }
    public MapDirection getDirection(){
        return this.direction;
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
                if(this.map.canMoveTo(tmp)){
                    this.position = this.position.add(this.direction.toUnitVector());
                }
            }
            case BACKWARD -> {
                Vector2d tmp = this.direction.toUnitVector().opposite().add(this.position);
                if(this.map.canMoveTo(tmp)) {
                    this.position = this.position.add(this.direction.toUnitVector().opposite());
                }
            }
            case IGNORE -> {
            }
        }
    }
    public void massMove(MoveDirection[] moveDirections){
        for(MoveDirection moveDirection: moveDirections){
            this.move(moveDirection);
        }
    }
}
