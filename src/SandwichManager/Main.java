/**
 * @author Arya Kulkarni and Jesse Barbieri
 */
package SandwichManager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

import static javafx.application.Application.launch;

/**
 * main sets stage for order creation
 */
public class Main extends Application{

    public static void main(String[] args) {
	    launch(args);
    }

    /**
     * Sets up the stage for the GUI with title Transaction Manager
     *
     * @param primaryStage Stage for the GUI
     * @throws Exception in case this doesn't work
     */

    public static Stage mainStage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = primaryStage;
        Parent root = FXMLLoader.load((getClass().getResource("/SandwichManager/createOrder.fxml")));
        primaryStage.setTitle("Sandwich Manager");
        primaryStage.setScene(new Scene(root, 600, 480));
        primaryStage.show();
    }

}
