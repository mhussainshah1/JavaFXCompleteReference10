package ch35;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class RadioButtonDemo2 extends Application {
    Label response;
    ToggleGroup tg;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Child Node
        var choose = new Label("    Select a Transport Type     ");

        tg = new ToggleGroup();
        var rbTrain = new RadioButton("Train");
        rbTrain.setToggleGroup(tg);
        rbTrain.setSelected(true);

        var rbCar = new RadioButton("Car");
        rbCar.setToggleGroup(tg);

        var rbPlane = new RadioButton("Airplane");
        rbPlane.setToggleGroup(tg);

        var separator = new Separator();
        separator.setPrefWidth(180);

        var btnConfirm = new Button("Confirm Transport Selection");
        btnConfirm.setOnAction(ae -> {
            var rb = (RadioButton) tg.getSelectedToggle();
            response.setText(rb.getText() + " is confirmed.");
        });

        response = new Label("No transport confirmed");

        //Primary Node
        var rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        rootNode.getChildren().addAll(choose, rbTrain, rbCar, rbPlane, separator, btnConfirm, response);

        //Scene
        var myScene = new Scene(rootNode, 200, 140);

        //Stage
        primaryStage.setScene(myScene);
        primaryStage.setTitle("Demonstrate Radio Buttons");
        primaryStage.show();
    }
}