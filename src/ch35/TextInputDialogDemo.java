package ch35;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class TextInputDialogDemo extends Application {
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        response = new Label("No Text Input");

        var tid = new TextInputDialog("Amir");
        tid.setTitle("Login");
        tid.setHeaderText("Enter Your Name");
        tid.setContentText("Name:");

        var btn = new Button("Click");
        btn.setOnAction(e-> {
//            tid.show();
            tid.showAndWait();
            response.setText(tid.getEditor().getText());
        });

        var rootNode = new FlowPane(10,10);
        rootNode.getChildren().addAll(btn,response);

        var scene = new Scene(rootNode , 500 , 300);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Demonstration of TextInputDialog");
        primaryStage.show();
    }
}
