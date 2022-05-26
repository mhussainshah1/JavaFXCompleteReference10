package ch35;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class HTMLEditorDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        var htmlEditor = new HTMLEditor();
        var htmlText = "<b>Bold text</b>";
        htmlEditor.setHtmlText(htmlText);

        var rootNode = new VBox();
        rootNode.getChildren().addAll(htmlEditor);

        var scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX App");
        primaryStage.show();
    }
}