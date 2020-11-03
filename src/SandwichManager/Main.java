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
 *
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
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load((getClass().getResource("/SandwichManager/createOrder.fxml")));
        primaryStage.setTitle("Sandwich Manager");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();
    }

    /**Not sure if this is how two stages are created
    public void Stage2(Stage secondaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("stage2.fxml"));
        secondaryStage.setTitle("Order Details");
        secondaryStage.setScene(new Scene(root, 700, 400));
        secondaryStage.show();
    }**/

}
