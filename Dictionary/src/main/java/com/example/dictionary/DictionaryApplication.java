package com.example.dictionary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.Objects;

public class DictionaryApplication extends Application {

    public static void main(String[] args) throws SQLException {
        MyJDBC.readSQL();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            primaryStage.setTitle("DEBAI Dictionary");
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("application.css")).toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();

            primaryStage.setOnCloseRequest(windowEvent -> {
                windowEvent.consume();
                exit(primaryStage);
            });
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void exit(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thoát khỏi ứng dụng");
        alert.setHeaderText("Bạn có thực sự muốn thoát ?");
        if(alert.showAndWait().get() == ButtonType.OK) {
            stage.close();
        }
    }

}
