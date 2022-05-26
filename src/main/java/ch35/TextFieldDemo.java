package ch35;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class TextFieldDemo extends Application {
    TextField tf;
    PasswordField pf;
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Child Node
        response = new Label("Search String: ");

        tf = new TextField();
        tf.setPromptText("Enter Search String");
        tf.setPrefColumnCount(15);
        tf.setOnAction(event -> response.setText("Search String: " + tf.getText()));

        pf = new PasswordField();
        pf.setPromptText("Enter Password");
        pf.setPrefColumnCount(15);
        pf.setOnAction(event -> response.setText("Search String: " + tf.getText()));

        var btnGetText = new Button("Get Search String");
        btnGetText.setOnAction(event -> response.setText("Search String: " + tf.getText()));

        var separator = new Separator();
        separator.setPrefWidth(180);

        //Parent
        var rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        rootNode.getChildren().addAll(tf, pf, btnGetText, separator, response);

        //Scene
        var scene = new Scene(rootNode, 230, 150);

        //Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Demonstrate a Textfield");
        primaryStage.show();
    }
}