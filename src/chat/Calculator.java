package chat;

// Java program to create a simple calculator with basic +, -, /, * using java swing elements

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application {
    // create a textfield
    static TextField l;

    // store operator and operands
    String s0, s1, s2;

    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        s0 = s1 = s2 = "";
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("calculator");

        // create a textfield
        l = new TextField();
        l.setEditable(false);

        // create number buttons
        var b0 = new Button("0");
        var b1 = new Button("1");
        var b2 = new Button("2");
        var b3 = new Button("3");
        var b4 = new Button("4");
        var b5 = new Button("5");
        var b6 = new Button("6");
        var b7 = new Button("7");
        var b8 = new Button("8");
        var b9 = new Button("9");

        // equals button
        var beq1 = new Button("=");

        // create operator buttons
        var ba = new Button("+");
        var bs = new Button("-");
        var bd = new Button("/");
        var bm = new Button("*");
        var beq = new Button("C");

        // create . button
        var be = new Button(".");

        // add action listeners
        bm.setOnAction(this::actionPerformed);
        bd.setOnAction(this::actionPerformed);
        bs.setOnAction(this::actionPerformed);
        ba.setOnAction(this::actionPerformed);
        b9.setOnAction(this::actionPerformed);
        b8.setOnAction(this::actionPerformed);
        b7.setOnAction(this::actionPerformed);
        b6.setOnAction(this::actionPerformed);
        b5.setOnAction(this::actionPerformed);
        b4.setOnAction(this::actionPerformed);
        b3.setOnAction(this::actionPerformed);
        b2.setOnAction(this::actionPerformed);
        b1.setOnAction(this::actionPerformed);
        b0.setOnAction(this::actionPerformed);
        be.setOnAction(this::actionPerformed);
        beq.setOnAction(this::actionPerformed);
        beq1.setOnAction(this::actionPerformed);

        var parent = new BorderPane();

        var node2 = new GridPane();
        node2.add(ba, 0, 0);
        node2.add(b1, 0, 1);
        node2.add(b2, 0, 2);
        node2.add(b3, 0, 3);

        node2.add(bs, 1, 0);
        node2.add(b4, 1, 1);
        node2.add(b5, 1, 2);
        node2.add(b6, 1, 3);

        node2.add(bm, 2, 0);
        node2.add(b7, 2, 1);
        node2.add(b8, 2, 2);
        node2.add(b9, 2, 3);

        node2.add(bd, 3, 0);
        node2.add(be, 3, 1);
        node2.add(b0, 3, 2);
        node2.add(beq, 3, 3);
        node2.setVgap(10);
        node2.setHgap(10);
        node2.setPadding(new Insets(10));

        parent.setTop(l);
        parent.setCenter(node2);
        parent.setBottom(beq1);

        // set Background of panel
//        rootNode.setBackground(Color.blue);

        var scene = new Scene(parent, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void actionPerformed(ActionEvent e) {
        Button button = (Button) e.getSource();
        String s = button.getText();

        // if the value is a number
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            // if operand is present then add to second no
            if (!s1.equals(""))
                s2 = s2 + s;
            else
                s0 = s0 + s;
            // set the value of text
            l.setText(s0 + s1 + s2);
        } else if (s.charAt(0) == 'C') {
            // clear the one letter
            s0 = s1 = s2 = "";

            // set the value of text
            l.setText(s0 + s1 + s2);
        } else if (s.charAt(0) == '=') {
            // store the value in 1st
            double te = total();

            // set the value of text
            l.setText(s0 + s1 + s2 + "=" + te);

            // convert it to string
            s0 = Double.toString(te);

            s1 = s2 = "";
        } else {
            // if there was no operand
            if (s1.equals("") || s2.equals(""))
                s1 = s;
                // else evaluate
            else {
                // store the value in 1st
                double te = total();
                // convert it to string
                s0 = Double.toString(te);

                // place the operator
                s1 = s;

                // make the operand blank
                s2 = "";
            }

            // set the value of text
            l.setText(s0 + s1 + s2);
        }
    }

    private double total() {
        return switch (s1) {
            case "+" -> (Double.parseDouble(s0) + Double.parseDouble(s2));
            case "-" -> (Double.parseDouble(s0) - Double.parseDouble(s2));
            case "/" -> (Double.parseDouble(s0) / Double.parseDouble(s2));
            default -> (Double.parseDouble(s0) * Double.parseDouble(s2));
        };
    }
}

