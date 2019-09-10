import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author : Vincent Gunaeri (1772001)
 * Program : Tampilan penggunaan TableView, BorderPane, VBox, HBox, GridPane, dan komponen lainnya
 *
 */
public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("com/vincent/view/MainForm.fxml"));
        primaryStage.setTitle("Praktikum minggu #2");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
