package SandwichManager;

import javafx.fxml.FXML;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class orderDetailController {
    @FXML
    private ListView display;

    public void addtoList(String s){
        display.getItems().add(s);
    }

    public void initialize(URL url, ResourceBundle resourceBundle){

    }


}
