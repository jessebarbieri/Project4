package SandwichManager;

import javafx.fxml.FXML;
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

public class orderDetailController {
    @FXML
    private TextField display;

    //Receive message from scene 1
    public void transferMessage(String message) {
        //Display the message
        display.setText(message);
    }
}
