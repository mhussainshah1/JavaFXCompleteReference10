package ch35;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class TextAreaDemo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        var textArea = new TextArea();

        var rootNode = new FlowPane(10, 10);
        rootNode.getChildren().addAll(textArea);

        var scene = new Scene(rootNode,200,200);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Demonstration of TextArea");
        primaryStage.show();
    }
}