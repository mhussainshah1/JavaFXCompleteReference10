package ch34;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class JavaFXLabelDemo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        //Child Node
        var label = new Label("This is JavFX Label");

        //Parent Nodes
        var rootNode = new FlowPane();
        ObservableList<Node> children = rootNode.getChildren();
        children.add(label);

        //Scene
        var scene = new Scene(rootNode, 300, 200);

        //Stage
        stage.setScene(scene);
        stage.setTitle("Demonstrate a Java FX Label");
        stage.show();
    }
}
