package ch35;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonImageDemo extends Application {
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Child Nodes
        response = new Label("Push a Button");

        var btnHourGlass = new Button("Hourglass", new ImageView("images/hourglass.png"));
        btnHourGlass.setContentDisplay(ContentDisplay.TOP);
        btnHourGlass.setOnAction(e -> response.setText("Hourglass Pressed"));

        var btnAnalogGlass = new Button(null, new ImageView("images/analog.png"));
        btnAnalogGlass.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        btnAnalogGlass.setOnAction(e -> response.setText("Analog Clock Pressed"));

        //Parent
        var rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        rootNode.getChildren().addAll(btnHourGlass, btnAnalogGlass, response);

        //Scene
        var scene = new Scene(rootNode, 250, 450);

        //Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Use Images with Buttons");
        primaryStage.show();
    }
}