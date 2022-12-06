package agh.ics.oop;

import java.util.ArrayList;

public class MapBoundary implements IPositionChangeObserver{

    ArrayList<IMapElement> X = new ArrayList<>();
    ArrayList<IMapElement> Y = new ArrayList<>();

    public void addElement(IMapElement object){
        putToX(object,object.getPosition());
        putToY(object,object.getPosition());
    }
    public void putToX(IMapElement object,Vector2d position){
        for(int i=0;i<X.size();i++){
            if(X.get(i).getPosition().x>position.x ||
                    (X.get(i).getPosition().x==position.x&&X.get(i).getPosition().y>=position.y)){
                X.add(i,object);
                return;
            }
        }
        X.add(object);
    }
    public void changeX(Vector2d oldPosition,Vector2d newPosition){
        IMapElement object = null;
        for(int i = 0; i < X.size();i++){
            if(X.get(i).getPosition().equals(oldPosition)){
                object = X.remove(i);
                break;
            }
        }
        putToX(object,newPosition);
    }
    public void putToY(IMapElement object,Vector2d position){
        for(int i=0;i<Y.size();i++){
            if(Y.get(i).getPosition().y>position.y ||
                    (Y.get(i).getPosition().y==position.y&&Y.get(i).getPosition().x>=position.x)){
                Y.add(i,object);
                return;
            }
        }
        Y.add(object);
    }
    public void changeY(Vector2d oldPosition,Vector2d newPosition){
        IMapElement object = null;
        for(int i = 0; i < Y.size();i++){
            if(Y.get(i).getPosition().equals(oldPosition)){
                object = Y.remove(i);
                break;
            }
        }
        putToY(object,newPosition);
    }
    public Vector2d ll() {
        return X.get(0).getPosition().lowerLeft(Y.get(0).getPosition());
    }

    public Vector2d ur() {
        return Y.get(Y.size()-1).getPosition().upperRight(X.get(X.size()-1).getPosition());
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        changeX(oldPosition,newPosition);
        changeY(oldPosition,newPosition);
    }
}
