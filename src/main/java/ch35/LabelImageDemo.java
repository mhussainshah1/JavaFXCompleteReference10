package ch35;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class LabelImageDemo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Child Node
        var hourGlass = new ImageView("images/hourglass.png");
        var lblHourGlass = new Label("Hourglass", hourGlass);
        lblHourGlass.setContentDisplay(ContentDisplay.TOP);

        //Parent
        var rootNode = new FlowPane();
        rootNode.setAlignment(Pos.CENTER);
        rootNode.getChildren().addAll(lblHourGlass);

        //Scene
        var scene = new Scene(rootNode, 300, 200);

        //Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Use an image in a Label");
        primaryStage.show();
    }
}
