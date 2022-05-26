package ch34;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Sample extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        //Child
        Label label1 = new Label("");

        //Parent
        var root = new VBox();
        root.getChildren().addAll(label1);

        //Scene
        var scene = new Scene(root, 400, 500);

        //Stage
        stage.setScene(scene);
        stage.setTitle("Episode - ");
        stage.show();
    }
}
