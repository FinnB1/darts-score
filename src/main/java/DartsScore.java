import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class DartsScore extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("control.fxml"));

        primaryStage.setTitle("dartsScore");
        primaryStage.setScene(new Scene(root, 640, 400));
        primaryStage.getIcons().add(new Image("dartboard.png"));
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.setMinWidth(primaryStage.getWidth());
        primaryStage.setMinHeight(primaryStage.getHeight());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
