package ch36;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuDemoFinal extends Application {
    Label response;
    private EventHandler<ActionEvent> menuHandler;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //child
        response = new Label("Menu Demo");

        menuHandler = e -> {
            var name = ((MenuItem) e.getTarget()).getText();
            if (name.equals("Exit"))
                Platform.exit();
            response.setText(name + " selected");
        };

        //Menu  <- MenuItem and Menu
        //menu 1
        Menu fileMenu = getFileMenu();

        //menu 2
        Menu optionsMenu = getOptionMenu();

        //menu 3
        Menu helpMenu = getHelpMenu();

        //MenuBar <-Menu
        var mb = new MenuBar();
        mb.getMenus().addAll(fileMenu, optionsMenu, helpMenu);

        //Context Menu
        ContextMenu editMenu = getContextMenu();

        var textArea = new TextArea();
        textArea.setPrefColumnCount(20);
        textArea.setContextMenu(editMenu);

        //Toolbar
        ToolBar tbDebug = getToolBar();

        var node1 = new VBox();
        node1.getChildren().addAll(mb, tbDebug);

        //parent
        BorderPane rootNode = new BorderPane();
        rootNode.setTop(node1);
        rootNode.setCenter(textArea);
        rootNode.setBottom(response);
        rootNode.setOnContextMenuRequested(event -> editMenu.show(rootNode, event.getScreenX(), event.getScreenY()));

        //scene
        Scene scene = new Scene(rootNode, 300, 300);

        //stage
        primaryStage.setTitle("Demonstrate Menus");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private ContextMenu getContextMenu() {
        var cut = new MenuItem("Cut");
        cut.setOnAction(menuHandler);

        var copy = new MenuItem("Copy");
        copy.setOnAction(menuHandler);

        var paste = new MenuItem("Paste");
        paste.setOnAction(menuHandler);

        var editMenu = new ContextMenu(cut, copy, paste);
        return editMenu;
    }

    private ToolBar getToolBar() {
        EventHandler<ActionEvent> btnHandler = ae -> response.setText(((Button) ae.getSource()).getText());

        var btnSet = new Button("Set Breakpoint", new ImageView("images/setBP.gif"));
        btnSet.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        btnSet.setTooltip(new Tooltip("Set a breakpoint"));
        btnSet.setOnAction(btnHandler);

        var btnClear = new Button("Clear Breakpoint", new ImageView("images/clearBP.gif"));
        btnClear.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        btnClear.setTooltip(new Tooltip("Clear a breakpoint"));
        btnClear.setOnAction(btnHandler);

        var btnResume = new Button("Resume Execution", new ImageView("images/resume.gif"));
        btnResume.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        btnResume.setTooltip(new Tooltip("Resume execution"));
        btnResume.setOnAction(btnHandler);

        var tbDebug = new ToolBar(btnSet, btnClear, btnResume);
        return tbDebug;
    }

    private Menu getHelpMenu() {
        var helpMenu = new Menu("_Help");
        var about = new MenuItem("About", new ImageView("images/aboutIcon.gif"));
        about.setOnAction(menuHandler);
        helpMenu.getItems().addAll(about);
        return helpMenu;
    }

    private Menu getOptionMenu() {
        var optionsMenu = new Menu("_Options");
        //submenu 1
        var colorMenu = new Menu("Colors");
        var red = new CheckMenuItem("Red");
        red.setOnAction(menuHandler);

        var green = new CheckMenuItem("Green");
        green.setOnAction(menuHandler);

        var blue = new CheckMenuItem("Blue");
        blue.setOnAction(menuHandler);

        colorMenu.getItems().addAll(red, green, blue);
        //submenu 2
        var priorityMenu = new Menu("Priority");
        var high = new RadioMenuItem("High");
        high.setOnAction(menuHandler);

        var low = new RadioMenuItem("Low");
        low.setOnAction(menuHandler);

        ToggleGroup tg = new ToggleGroup();
        high.setToggleGroup(tg);
        low.setToggleGroup(tg);

        high.setSelected(true);

        priorityMenu.getItems().addAll(high, low);
        //menuitem
        var reset = new MenuItem("Reset");
        reset.setOnAction(menuHandler);

        optionsMenu.getItems().addAll(colorMenu, priorityMenu, new SeparatorMenuItem(), reset);
        return optionsMenu;
    }

    private Menu getFileMenu() {
        var fileMenu = new Menu("_File");
        //menuitem
        var open = new MenuItem("Open");
        open.setOnAction(menuHandler);
        open.setAccelerator(KeyCombination.keyCombination("shortcut+O"));

        var close = new MenuItem("Close");
        close.setOnAction(menuHandler);
        close.setAccelerator(KeyCombination.keyCombination("shortcut+C"));

        var save = new MenuItem("Save");
        save.setOnAction(menuHandler);
        save.setAccelerator(KeyCombination.keyCombination("shortcut+S"));

        var exit = new MenuItem("Exit");
        exit.setOnAction(menuHandler);
        exit.setAccelerator(KeyCombination.keyCombination("shortcut+E"));

        fileMenu.getItems().addAll(open, close, save, new SeparatorMenuItem(), exit);
        return fileMenu;
    }
}