package ch35;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ScrollPaneDemo extends Application {
    ScrollPane scrollPane;
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Child Node
        response = new Label(
                "A ScrollPane streamlines the process of\n" +
                        "adding scroll bars to a window whose\n" +
                        "contents exceed the window's dimensions.\n" +
                        "It also enables a control to fit in a\n" +
                        "smaller space than it otherwise would.\n" +
                        "As such, it often provides a superior\n" +
                        "approach over using individual scrollbars.");
        scrollPane = new ScrollPane(response);
        scrollPane.setPrefViewportWidth(130);
        scrollPane.setPrefViewportHeight(80);
        scrollPane.setPannable(true);

        var btnReset = new Button("Reset Scroll Bar Position");
        btnReset.setOnAction(event -> {
            scrollPane.setVvalue(0);
            scrollPane.setHvalue(0);
        });

        //Parent
        var rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        rootNode.getChildren().addAll(scrollPane, btnReset);

        //Scene
        var scene = new Scene(rootNode, 200, 200);

        //Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Demonstrate a ScrollPane");
        primaryStage.show();
    }
}