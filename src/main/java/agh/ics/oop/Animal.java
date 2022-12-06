package agh.ics.oop;

import java.util.ArrayList;

public class Animal implements IMapElement{
    private final IWorldMap map;
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position;
    ArrayList<IPositionChangeObserver> observers = new ArrayList<>();
    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
        boolean b = this.map.eat(position);
        this.map.place(this);
        if(b){
            this.map.grassify();
        }
    }
    public Animal(IWorldMap map){
        this(map,new Vector2d(2,2));
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
        return this.position.equals(position);
    }
    public void move(MoveDirection direction){
        switch (direction) {
            case LEFT -> this.direction = this.direction.previous();
            case RIGHT -> this.direction = this.direction.next();
            case FORWARD -> {
                Vector2d tmp = this.direction.toUnitVector().add(this.position);
                if(this.map.canMoveTo(tmp)){
                    boolean b = this.map.eat(tmp);
                    positionChanged(this.position,tmp);
                    this.position = tmp;
                    if(b){
                        this.map.grassify();
                    }
                }
            }
            case BACKWARD -> {
                Vector2d tmp = this.direction.toUnitVector().opposite().add(this.position);
                if(this.map.canMoveTo(tmp)) {
                    boolean b = this.map.eat(tmp);
                    positionChanged(this.position,tmp);
                    this.position = tmp;
                    if(b){
                        this.map.grassify();
                    }
                }
            }
            case IGNORE -> {
            }
        }
    }
    void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(IPositionChangeObserver observer : observers){
            observer.positionChanged(oldPosition,newPosition);
        }
    }
    void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }
    void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }
    public void massMove(MoveDirection[] moveDirections){
        for(MoveDirection moveDirection: moveDirections){
            this.move(moveDirection);
        }
    }
}
