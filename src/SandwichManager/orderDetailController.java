package SandwichManager;

import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class orderDetailController {
    @FXML
    private ListView display;
    private createOrderController controller;

    @FXML
    Button backButton;

    public void createOrderController(createOrderController controller){
        controller = this.controller;
    }

    public void setDisplay(ObservableList list){
        display.setItems(list);
    }

    public void initialize(URL url, ResourceBundle resourceBundle){

    }

    public void setBackButton(){
        System.out.println("Send to Order Creation page");
        // close this page and open the first one
    }


}
