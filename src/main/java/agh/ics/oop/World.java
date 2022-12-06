package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World {
    public static void main(String[] args){
        try {
            Application.launch(App.class,args);
            MoveDirection[] directions = OptionsParser.parse(args);
            RectangularMap map = new RectangularMap(10, 5);
            System.out.println(map);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions, map);
            engine.run();
            System.out.println(map);

            GrassField map1 = new GrassField(10);
            System.out.println(map1);
            IEngine engine1 = new SimulationEngine(directions, map1, positions, map1);
            engine1.run();
            System.out.println(map1);
        }catch (IllegalArgumentException exception){
            System.out.println(exception);
        }finally {
            for(String s: args){
                System.out.println(s);
            }
        }
    }
}
