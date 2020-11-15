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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class orderDetailController {
    Order currOrder1;
    @FXML
    private ListView display;
    private createOrderController controller;

    @FXML

    Button back;

    @FXML
    Button removeButton;

    public void createOrderController(createOrderController controller){
        controller = this.controller;
    }

    public void setDisplay(ObservableList list, Order currOrder){
        display.setItems(list);
        currOrder1 = currOrder;
    }

    public void setBack(){
        Main.mainStage.show();
        createOrderController.secondStage.close();
    }


    // purely visual, does not actually remove the order from the orderline
    public void removeOrder(){
        try {
            String removeString = display.getSelectionModel().getSelectedItem().toString();
            System.out.println(removeString);

            // split up into parts
            String[] parseRemove = removeString.split("\\s");
            int linenumber = Integer.parseInt(parseRemove[0]);
            String type = parseRemove[3];
            double price = Double.parseDouble(parseRemove[5]);

            boolean res = currOrder1.remove(linenumber);
            display.getItems().remove(removeString);
            if (res) {
                System.out.println("Successfully Removed");
            } else {
                System.out.println("Item not removed");
            }
        }  catch(NullPointerException e){
            System.out.println("Select an item to remove");
        }
    }

    public void initialize(URL url, ResourceBundle resourceBundle){

    }

    public void setBackButton(){
        System.out.println("Send to Order Creation page");
        // close this page and open the first one
    }


}
