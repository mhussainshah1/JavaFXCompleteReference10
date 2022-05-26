package ch35;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class CheckboxDemo extends Application {
    CheckBox cbWeb, cbDesktop, cbMobile;
    Label response, allTargets;
    String targets = "";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Child Node
        var heading = new Label("Select Deployment Options");

        var separator = new Separator();
        separator.setPrefWidth(200);

        cbWeb = new CheckBox("Web");
        cbWeb.setAllowIndeterminate(true);
        cbWeb.setTooltip(new Tooltip("Deploy to Web"));
        cbWeb.setOnAction(event -> {
            if(cbWeb.isIndeterminate())
                response.setText("Web deployment indeterminate");
            else if (cbWeb.isSelected())
                response.setText("Web deployment selected");
            else
                response.setText("Web deployment cleared");
            showAll();
        });


        cbDesktop = new CheckBox("Desktop");
        cbDesktop.setAllowIndeterminate(true);
        cbDesktop.setTooltip(new Tooltip("Deploy to Desktop"));
        cbDesktop.setOnAction(event -> {
            if(cbDesktop.isIndeterminate())
                response.setText("Desktop deployment indeterminate");
            else if (cbDesktop.isSelected())
                response.setText("Desktop deployment selected");
            else
                response.setText("Desktop deployment cleared");
            showAll();
        });

        cbMobile = new CheckBox("Mobile");
        cbMobile.setAllowIndeterminate(true);
        cbMobile.setTooltip(new Tooltip("Deploy to Mobile"));
        cbMobile.setOnAction(event -> {
            if(cbMobile.isIndeterminate())
                response.setText("Mobile deployment indeterminate");
            else if (cbMobile.isSelected())
                response.setText("Mobile deployment selected");
            else
                response.setText("Mobile deployment cleared");
            showAll();
        });

        response = new Label("No Deployment Selected");
        allTargets = new Label("Target List: <none>");

        //Parent
        var rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        rootNode.getChildren().addAll(heading, separator, cbWeb, cbDesktop, cbMobile, response, allTargets);

        //Scene
        var scene = new Scene(rootNode, 230, 140);

        //Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Demonstrate Checkboxes");
        primaryStage.show();
    }

    private void showAll() {
        targets = "";
        if(cbWeb.isSelected())
            targets ="Web ";
        if(cbDesktop.isSelected())
            targets += "Desktop ";
        if(cbMobile.isSelected())
            targets += "Mobile ";
        if (targets.equals(""))
            targets="<none>";
        allTargets.setText("Target List: " + targets);
    }
}
