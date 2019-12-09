package chapter8;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class JoshUserInterface extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private String getTime() {
        return LocalDateTime.now().toString();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane root = new GridPane();

        TextField tf = new TextField(getTime());
        Button b = new Button("Update Time");

        b.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                tf.setText(getTime());

            }
        });

        root.add(tf, 0, 0);
        root.add(b, 1, 0);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}