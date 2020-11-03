package SandwichManager;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class createOrderController implements Initializable {

    @FXML
    ComboBox<Sandwich> sandwichType;

    Sandwich[] sandwichArr = {Fish, Chicken, Beef};

    @FXML
    Button showOrder;

    ToggleGroup tg = new ToggleGroup();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Program is starting\n");
        sandwichType.setItems(FXCollections.observableArrayList(sandwichArr));
    }

    /**
     * A void method that sets radio buttons into a group for a single selection
     */


    public void getSandwichType(){
        sandwichType.itemsProperty();
    }

}
