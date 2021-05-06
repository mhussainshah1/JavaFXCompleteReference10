package ch34;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class JavaFXSkel extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        System.out.println("Inside the init() method");
    }

    @Override
    public void start(Stage stage) {
        System.out.println("Inside the start() method");
        //Parent Node
        var rootNode = new FlowPane();

        //Scene
        var myScene = new Scene(rootNode, 300, 200);

        //Stage
        stage.setScene(myScene);
        stage.setTitle("JavaFX Skeleton");
        stage.show();
    }

    @Override
    public void stop() {
        System.out.println("Inside the stop method");
    }
}