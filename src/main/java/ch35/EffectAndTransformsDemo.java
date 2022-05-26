package ch35;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class EffectAndTransformsDemo extends Application {
    double angle = 0.0, glowVal = 0.0, scaleFactor = 1.0;
    boolean shadow = false;

    //Effects
    Glow glow = new Glow(0.0);
    InnerShadow innerShadow = new InnerShadow(10.0, Color.RED);
    //Transform
    Rotate rotate = new Rotate();
    Scale scale = new Scale(scaleFactor, scaleFactor);

    Button btnShadow = new Button("Shadow off");
    Button btnScale = new Button("Scale");
    Button btnRotate = new Button("Rotate");
    Button btnGlow = new Button("Glow");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Child Node
        btnGlow.setEffect(glow);
        btnRotate.getTransforms().add(rotate);
        btnScale.getTransforms().add(scale);


        btnGlow.setOnAction(event -> {
            glowVal += 0.1;
            if (glowVal > 1.0) {
                glowVal = 0.0;
            }
            glow.setLevel(glowVal);
        });

        btnShadow.setOnAction(event -> {
            shadow = !shadow;
            if(shadow){
                btnShadow.setEffect(innerShadow);
                btnShadow.setText("Shadow on");
            } else {
                btnShadow.setEffect(null);
                btnShadow.setText("Shadow off");
            }
        });

        btnRotate.setOnAction(event -> {
            angle += 30.0;
            rotate.setAngle(angle);
            rotate.setPivotX(btnRotate.getWidth() / 2);
            rotate.setPivotY(btnRotate.getHeight() / 2);
        });

        btnScale.setOnAction(event -> {
            scaleFactor += 0.1;
            if (scaleFactor > 1.0)
                scaleFactor = 0.4;
            scale.setX(scaleFactor);
            scale.setY(scaleFactor);
        });
        //Parent
        var rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        rootNode.getChildren().addAll(btnGlow, btnShadow,btnRotate, btnScale);

        //Scene
        var scene = new Scene(rootNode, 300, 100);

        //Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Effects and Transforms Demo");
        primaryStage.show();
    }
}

