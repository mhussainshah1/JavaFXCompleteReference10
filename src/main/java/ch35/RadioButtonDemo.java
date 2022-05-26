package ch35;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class RadioButtonDemo extends Application {
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Child Node
        response = new Label("");

        var tg = new ToggleGroup();

        var rbTrain = new RadioButton("Train");
        rbTrain.setToggleGroup(tg);
//        rbTrain.setOnAction(e -> response.setText("Transport Selected is train"));

        var rbCar = new RadioButton("Car");
        rbCar.setToggleGroup(tg);
//        rbCar.setOnAction(e -> response.setText("Transport Selected is car"));

        var rbPlane = new RadioButton("Airplane");
        rbPlane.setToggleGroup(tg);
//        rbPlane.setOnAction(e -> response.setText("Transport Selected is plane"));

//        rbTrain.fire();
//        rbTrain.setSelected(true);

        tg.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            RadioButton rb = (RadioButton) newValue;
            response.setText("Transport selected is " + rb.getText());
        });
        rbTrain.setSelected(true);

        //Parent
        var rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        rootNode.getChildren().addAll(rbTrain, rbCar, rbPlane, response);

        //Scene
        var scene = new Scene(rootNode, 220, 120);

        //Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Demonstrate Radio Button");
        primaryStage.show();
    }
}