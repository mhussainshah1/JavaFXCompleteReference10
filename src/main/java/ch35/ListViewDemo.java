package ch35;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ListViewDemo extends Application {
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Child Node
        response = new Label("Select Transport Type");
        ObservableList<String> transportTypes = FXCollections.observableArrayList("Train", "Car", "Airplane", "Bicycle", "Walking");
        var lvTransport = new ListView<>(transportTypes);
        lvTransport.setPrefSize(80, 80);
        lvTransport.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        var lvSelModel = lvTransport.getSelectionModel();
        lvSelModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String selItems = "";
            ObservableList<String> selected = lvTransport.getSelectionModel().getSelectedItems();
            for (int i = 0; i < selected.size(); i++) {
                selItems += "\n      " + selected.get(i);
            }
            response.setText("All transport selected: " + selItems);
//            response.setText("Transport selected is " + newValue);
        });

        //Parent
        var rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        rootNode.getChildren().addAll(lvTransport, response);

        //Scene
        var scene = new Scene(rootNode, 200, 150);

        //Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("ListView Demo");
        primaryStage.show();
    }
}