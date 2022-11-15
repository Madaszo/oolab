package agh.ics.oop;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public String toString() {
        return switch (this){
            case EAST -> "E";
            case WEST -> "W";
            case NORTH -> "N";
            case SOUTH -> "S";
        };
    }
    public MapDirection next() {
        return switch (this){
            case NORTH -> MapDirection.EAST;
            case WEST -> MapDirection.NORTH;
            case EAST -> MapDirection.SOUTH;
            case SOUTH -> MapDirection.WEST;
        };
    }
    public MapDirection previous() {
        return switch (this){
            case SOUTH -> MapDirection.EAST;
            case EAST -> MapDirection.NORTH;
            case WEST -> MapDirection.SOUTH;
            case NORTH -> MapDirection.WEST;
        };
    }
    public Vector2d toUnitVector(){
        return switch (this){
            case NORTH -> new Vector2d(0,1);
            case WEST -> new Vector2d(-1,0);
            case EAST -> new Vector2d(1,0);
            case SOUTH -> new Vector2d(0,-1);
        };
    }
}
