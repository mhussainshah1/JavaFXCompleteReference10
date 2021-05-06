package ch34;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class JavaFXEventDemo extends Application {
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Child Node
        response = new Label("Push a Button");
        var btnAlpha = new Button("Alpha");
        btnAlpha.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                response.setText("Alpha was pressed");
            }
        });

        var btnBeta = new Button("Beta");
        btnBeta.setOnAction(e -> response.setText("Beta was pressed"));

        //Parent Node
        var rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        rootNode.getChildren().addAll(btnAlpha, btnBeta, response);

        //Scene
        var myScene = new Scene(rootNode, 300, 100);

        //Stage
        primaryStage.setTitle("Demonstrate JavaFX Buttons and Events.");
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
}
