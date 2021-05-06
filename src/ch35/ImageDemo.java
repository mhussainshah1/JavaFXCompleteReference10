package ch35;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ImageDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Node
        var hourglass = new Image("images/hourglass.png");
        var hourglassIV = new ImageView(hourglass);

        //Parent
        var rootNode = new FlowPane();
        rootNode.setAlignment(Pos.CENTER);
        rootNode.getChildren().addAll(hourglassIV);

        //Scene
        var scene = new Scene(rootNode, 300, 200);

        //Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Image Demo");
        primaryStage.show();
    }
}