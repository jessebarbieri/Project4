package SandwichManager;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class createOrderController implements Initializable {

    @FXML
    public TextField inputField;
    @FXML
    public Button actionBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //When button clicked, load window and pass data
        System.out.println("Program is starting...\n");
    }

    public void setOnAction(){
        actionBtn.setDisable(false);
        loadSceneAndSendMessage();
    }

    private void loadSceneAndSendMessage() {
        try {
            //Load second scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("orderDetail.fxml"));
            Parent root = loader.load();

            //Get controller of scene2
            orderDetailController scene2Controller = loader.getController();
            //Pass whatever data you want. You can have multiple method calls here
            scene2Controller.transferMessage(inputField.getText());

            //Show scene 2 in new window
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Second Window");
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
