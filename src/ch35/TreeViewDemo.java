package ch35;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class TreeViewDemo extends Application {
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //Child Node
        response = new Label("No Selection");
        var tiRoot = new TreeItem<>("Food");
        var tiFruit = new TreeItem<>("Fruits");
        var tiApples = new TreeItem<>("Apples");

        tiApples.getChildren().addAll(new TreeItem<>("Fuji"),
                new TreeItem<>("Winesap"),
                new TreeItem<>("Jonathan"));

        tiFruit.getChildren().addAll(tiApples,
                new TreeItem<>("Pears"),
                new TreeItem<>("Oranges"));
        tiRoot.getChildren().addAll(tiFruit);

        var tiVegetables = new TreeItem<>("Vegetables");
        tiVegetables.getChildren().addAll(new TreeItem<>("Corn"),
                new TreeItem<>("Peas"),
                new TreeItem<>("Broccoli"),
                new TreeItem<>("Beans"));
        tiRoot.getChildren().add(tiVegetables);

        var tiNuts = new TreeItem<String>("Nuts");
        tiNuts.getChildren().addAll(new TreeItem<>("Walnuts"),
                new TreeItem<>("Peanuts"),
                new TreeItem<>("Pecans"));
        tiRoot.getChildren().add(tiNuts);

        var tvFood = new TreeView<>(tiRoot);
        MultipleSelectionModel<TreeItem<String>> tvSelModel = tvFood.getSelectionModel();
        tvSelModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                String path = newValue.getValue();
                TreeItem<String> tmp = newValue.getParent();
                while (tmp != null) {
                    path = tmp.getValue() + " -> " + path;
                    tmp = tmp.getParent();
                }
                response.setText("Selection is " + newValue.getValue() + "\nComplete path is " + path);
            }
        });

        //Parent
        var rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        rootNode.getChildren().addAll(tvFood, response);

        //Scene
        var scene = new Scene(rootNode, 310, 460);

        //Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Demonstrate a TreeView");
        primaryStage.show();
    }
}