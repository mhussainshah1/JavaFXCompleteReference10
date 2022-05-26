package ch35;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ComboBoxDemo extends Application {
    ComboBox<String> cbTransport;
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Child Node
        response = new Label();
        ObservableList<String> transportTypes = FXCollections.observableArrayList("Train", "Car", "Airplane");
        cbTransport = new ComboBox<>(transportTypes);
        cbTransport.setValue("Train");
        response.setText("Selected Transport is " + cbTransport.getValue());
        cbTransport.setEditable(true);
        cbTransport.setOnAction(event -> response.setText("Selected Transport is " + cbTransport.getValue()));

        //Parent
        var rootNode = new FlowPane(10,10);
        rootNode.setAlignment(Pos.CENTER);
        rootNode.getChildren().addAll(cbTransport, response);

        //Scene
        var scene = new Scene(rootNode, 280, 120);

        //Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Combobox Demo");
        primaryStage.show();
    }
}