package agh.ics.oop.gui;
import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;


import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class App extends Application implements IPositionChangeObserver {
    Scene scene ;
    GridPane gridPane = new GridPane();
    AbstractWorldMap map;
    SimulationEngine engine;
    Stage stage;
    Thread thread;
    public void init(){
        GrassField map1 = new GrassField(10);
        System.out.println(map1);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        engine = new SimulationEngine(map1, positions, map1);
        engine.addObservers(this);
        map = engine.map;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) throws FileNotFoundException {
        Platform.runLater(()->{
            gridPane.getChildren().clear();
            Label label = new Label("Y\\X");
            GridPane.setHalignment(label, HPos.CENTER);
            gridPane.add(label,0,0,1,1);
            Vector2d ll = map.ll();
            Vector2d ur = map.ur();
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
            for(Map.Entry<Vector2d,IMapElement> entry: map.objects.entrySet()){
                Vector2d position = entry.getKey();
                IMapElement object = entry.getValue();
                GuiElementBox gub = null;
                try {
                    gub = new GuiElementBox(object);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                gridPane.add(gub.getvBox(),position.x-ll.x+1,ur.y-position.y+1,1,1);
                gridPane.getColumnConstraints().add(new ColumnConstraints(50));
                gridPane.getRowConstraints().add(new RowConstraints(50));
            }
            gridPane.getColumnConstraints().add(new ColumnConstraints(50));
            gridPane.getRowConstraints().add(new RowConstraints(50));
            gridPane.setGridLinesVisible(true);
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("GridPane Experiment");


        init();

        Label label = new Label("Y\\X");
        GridPane.setHalignment(label, HPos.CENTER);
        gridPane.setGridLinesVisible(true);
        gridPane.add(label,0,0,1,1);
        Vector2d ll = map.ll();
        Vector2d ur = map.ur();
        for(int i = 0; i <= ur.x-ll.x;i++){
            Label label1 =new Label(Integer.toString(i+ll.x));
            GridPane.setHalignment(label1, HPos.CENTER);
            gridPane.add(label1,i+1,0,1,1);
            gridPane.getColumnConstraints().add(new ColumnConstraints(50));
            gridPane.getRowConstraints().add(new RowConstraints(50));
        }

        gridPane.getColumnConstraints().add(new ColumnConstraints(50));
        gridPane.getRowConstraints().add(new RowConstraints(50));
        for(int i = ll.y; i <= ur.y;i++){
            Label label1 = new Label(Integer.toString(i));
            GridPane.setHalignment(label1, HPos.CENTER);
            gridPane.add(label1,0,ur.y-i+1,1,1);
        }
        for(Map.Entry<Vector2d,IMapElement> entry: map.objects.entrySet()){
            Vector2d position = entry.getKey();
            IMapElement object = entry.getValue();
            GuiElementBox gub = new GuiElementBox(object);
            gridPane.add(gub.getvBox(),position.x-ll.x+1,ur.y-position.y+1,1,1);
        }
        Button button = new Button("Start");


        TextField textField = new TextField("Args");
        HBox hBox = new HBox(button,textField);
        VBox vBox = new VBox(gridPane,hBox);
        scene= new Scene(vBox,50*(ur.x-ll.x+2),50*(ur.y- ll.y+3));
        stage = primaryStage;
        stage.setScene(scene);
        button.setOnAction((value)-> {
            String string = textField.getText();
            String[] splited = string.split("\\s+");
            MoveDirection[] directions = OptionsParser.parse(splited);
            engine.setDirections(directions);
            thread = new Thread(engine);
            thread.start();
        });
        stage.show();

    }
}
