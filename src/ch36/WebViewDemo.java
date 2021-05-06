package ch36;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewDemo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load("http://google.com");

        String content = "Hello World!";
//        webEngine.loadContent(content, "text/html");

        webEngine.reload();
        webView.setZoom(1.25);  //zoom in 25%.
        webView.setFontScale(1.25);
        webEngine.setUserAgent("MyApp Web Browser 1.0 - AppleWebKit/555.99 JavaFX 8.0");

        VBox vBox = new VBox(webView);

        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX WebView Example");
        primaryStage.show();
    }
}