package agh.ics.oop.gui;

import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {
    public Image image;
    public VBox vBox;
    public GuiElementBox(IMapElement element) throws FileNotFoundException {
        image = new Image(new FileInputStream(element.getPath()));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        vBox = new VBox();
        vBox.getChildren().add(imageView);
        Label label = new Label(element.getLabel());
        vBox.getChildren().add(label);
        vBox.setAlignment(Pos.CENTER);
    }
    public VBox getvBox(){
        return vBox;
    }
}
