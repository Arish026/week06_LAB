import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.List;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Path Drawing - OOP Commands");

        BorderPane root = new BorderPane();
        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        TextField inputField = new TextField();
        inputField.setPromptText("Enter path command like F+F-F+F");

        Button drawButton = new Button("Draw");

        drawButton.setOnAction(e -> {
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

            String commandString = inputField.getText().toUpperCase().trim();
            List<Command> commands = CommandParser.parse(commandString);

            Pen pen = new Pen(400, 300, gc); // Start at center

            for (Command cmd : commands) {
                cmd.execute(pen);
            }
        });

        VBox controls = new VBox(10, inputField, drawButton);
        root.setTop(controls);
        root.setCenter(canvas);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}