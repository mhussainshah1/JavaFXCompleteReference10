package ch34;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BorderPaneDemo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        var center = new Text("Center");
        center.setStyle("-fx-background-color: red");
        var north = new Text("Top");
        var east = new Text("Right");
        var south = new Text("Bottom");
        var west = new Text("Left");

        BorderPane.setAlignment(north, Pos.TOP_CENTER);
        BorderPane.setAlignment(south,Pos.BOTTOM_CENTER);
        BorderPane.setAlignment(west,Pos.CENTER_LEFT);
        BorderPane.setAlignment(east,Pos.CENTER_RIGHT);

        BorderPane root = new BorderPane(center, north, east, south, west);
        root.setPrefSize(400, 400);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        var scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("A simple BorderPane Example");
        stage.show();
    }
}