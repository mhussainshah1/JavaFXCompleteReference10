module JavaFXCompleteReference10 {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens ch34 to javafx.fxml;
    exports ch34;
    opens ch35 to javafx.fxml;
    exports ch35;
    opens ch36 to javafx.fxml;
    exports ch36;
    opens chat to javafx.fxml;
    exports chat;
    opens menu to javafx.fxml;
    exports menu;
}