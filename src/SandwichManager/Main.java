/**
 * @author Arya Kulkarni and Jesse Barbieri
 */
package SandwichManager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

/**
 *
 */
public class Main extends Application{

    public static void main(String[] args) {
	    launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("createOrder.fxml"));
        primaryStage.setTitle("Create order");
        primaryStage.setScene(new Scene(root, 732, 464));
        primaryStage.show();
    }
}
