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

    Button back;

    @FXML
    Button removeButton;

    public void createOrderController(createOrderController controller){
        controller = this.controller;
    }

    public void setDisplay(ObservableList list){
        display.setItems(list);
    }

    public void setBack(){
        Main.mainStage.show();
        createOrderController.secondStage.close();
    }

    /*
    public Order sendOrder(Order order, ObservableList list){
        System.out.println(list);
        return order;
    }
     */

    // purely visual, does not actually remove the order from the orderline
    public void removeOrder(){
        int linenumber;
        double price;
        int line = display.getSelectionModel().getSelectedIndex();
        String removeString = display.getSelectionModel().getSelectedItem().toString();
        String[] parseRemove = removeString.split("\\s");
        linenumber = Integer.parseInt(parseRemove[0]);
        String type = parseRemove[3];
        price = Double.parseDouble(parseRemove[5]);
        if(type.equals("Fish")){
            Sandwich f = new Fish();
            OrderLine oLine = new OrderLine(linenumber, f, price);

        }
        else if(type.equals("Chicken")){
            Sandwich c = new Fish();
            OrderLine oLine = new OrderLine(linenumber, c, price);
        }
        else if(type.equals("Beef")){
            Sandwich b = new Beef();
            OrderLine oLine = new OrderLine(linenumber, b, price);
        }

        System.out.println(linenumber + " " + type + " " + price);

        display.getItems().remove(line);
        display.refresh();
    }

    public void initialize(URL url, ResourceBundle resourceBundle){

    }

    public void setBackButton(){
        System.out.println("Send to Order Creation page");
        // close this page and open the first one
    }


}
