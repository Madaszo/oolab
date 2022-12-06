package agh.ics.oop.gui;
import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;


import java.util.List;
import java.util.Map;

public class App extends Application {
    Scene scene ;
    public void init(){
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("GridPane Experiment");

        Label label = new Label("Y\\X");
        GridPane.setHalignment(label, HPos.CENTER);
        List<String> list = getParameters().getRaw();
        String[] args = new String[list.size()];
        list.toArray(args);
        MoveDirection[] directions = OptionsParser.parse(args);
        GrassField map1 = new GrassField(10);
        System.out.println(map1);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine1 = new SimulationEngine(directions, map1, positions, map1);
        System.out.println(map1);
        System.out.println(map1.ll());
        System.out.println(map1.ur());

        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        gridPane.add(label,0,0,1,1);
        Vector2d ll = map1.ll();
        Vector2d ur = map1.ur();
        for(int i = 0; i <= ur.x-ll.x;i++){
            Label label1 =new Label(Integer.toString(i+ll.x));
            GridPane.setHalignment(label1, HPos.CENTER);
            gridPane.add(label1,i+1,0,1,1);
        }
        for(int i = ll.y; i <= ur.y;i++){
            Label label1 = new Label(Integer.toString(i));
            GridPane.setHalignment(label1, HPos.CENTER);
            gridPane.add(label1,0,ur.y-i+1,1,1);
        }
        for(Map.Entry<Vector2d,IMapElement> entry: map1.objects.entrySet()){
            Vector2d position = entry.getKey();
            IMapElement object = entry.getValue();
            Label label1 = new Label(object.toString());
            GridPane.setHalignment(label1, HPos.CENTER);
            gridPane.add(label1,position.x-ll.x+1,ur.y-position.y+1,1,1);
            gridPane.getColumnConstraints().add(new ColumnConstraints(50));
            gridPane.getRowConstraints().add(new RowConstraints(50));
        }
        gridPane.getColumnConstraints().add(new ColumnConstraints(50));
        gridPane.getRowConstraints().add(new RowConstraints(50));
        scene= new Scene(gridPane,50*(ur.x-ll.x+2),50*(ur.y- ll.y+2));

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
