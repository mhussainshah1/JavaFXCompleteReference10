package ch34;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DirectDrawDemo extends Application {
    GraphicsContext gc;
    Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.BLACK};
    int colorIdx = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //child nodes
        var canvas = new Canvas(400, 400);
        gc = canvas.getGraphicsContext2D();


        var btnChangeColor = new Button("Change Color");
        btnChangeColor.setOnAction(event -> {
            gc.setStroke(colors[colorIdx]);
            gc.setFill(colors[colorIdx]);

            gc.strokeLine(0, 0, 200, 200);
            gc.fillRect(100, 320, 300, 40);
            gc.fillText("This is drawn on the canvas.", 60, 50);
            gc.strokeText("This is Stroke Text", 100, 90);
            colorIdx++;
            if (colorIdx == colors.length)
                colorIdx = 0;
        });
        gc.strokeLine(0, 0, 200, 200);
        gc.strokeOval(100, 100, 200, 200);
        gc.strokeRect(0, 200, 50, 200);
        gc.fillOval(0, 0, 20, 20);
        gc.fillRect(100, 320, 300, 40);

        gc.setFont(new Font(20));
        gc.fillText("This is drawn on the canvas.", 60, 50);

        //Parent Node
        var rootNode = new FlowPane();
        rootNode.setAlignment(Pos.CENTER);

        //Scene
        var scene = new Scene(rootNode, 450, 450);

        //Stage
        primaryStage.setTitle("Draw Directly to a Canvas");
        primaryStage.setScene(scene);
        rootNode.getChildren().addAll(canvas, btnChangeColor);
        primaryStage.show();
    }
}