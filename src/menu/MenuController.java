package menu;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.BorderPane;

public class MenuController {
    @FXML
    private BorderPane rootNode;

    @FXML
    private ContextMenu editMenu;
    @FXML
    private Label response;

    public void menuHandler(ActionEvent e) {
        var name = ((MenuItem) e.getTarget()).getText();
        if (name.equals("Exit"))
            Platform.exit();
        response.setText(name + " selected");
    }

    public void btnHandler(ActionEvent e) {
        response.setText(((Button)e.getTarget()).getText());
    }

    public void contextMenuHandler(ContextMenuEvent e) {
        editMenu.show(rootNode,e.getScreenX(),e.getScreenY());
    }
}
