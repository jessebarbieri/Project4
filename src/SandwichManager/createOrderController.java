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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.security.spec.ECField;
import java.util.ResourceBundle;

public class createOrderController implements Initializable {

    @FXML
    ComboBox<String> sandwichType;

    // Sandwich[] sandwichArr = {Fish, Chicken, Beef};
    // This is just to display the options on the GUI
    String[] sandwichSelect = {"Fish", "Chicken", "Beef"};

    @FXML
    Button showOrder;

    // Declaring the images
    Image chickenPic= new Image(getClass().getResourceAsStream("chicken-sandwich.png"));
    Image beefPic= new Image(getClass().getResourceAsStream("beef-sandwich.png"));
    Image fishPic= new Image(getClass().getResourceAsStream("fish-sandwich.png"));


    ToggleGroup tg = new ToggleGroup();
    public ImageView imageSelect;

    /**
     * This void method sets the image that correlates to the proper selected sandwich
     */
    public void setImageSelect() {
        if(sandwichType.getSelectionModel().getSelectedIndex() == 0){
            imageSelect.fitWidthProperty();
            imageSelect.fitHeightProperty();
            imageSelect.setImage(fishPic);
        }
        else if (sandwichType.getSelectionModel().getSelectedIndex() == 1){
            imageSelect.fitWidthProperty();
            imageSelect.fitHeightProperty();
            imageSelect.setImage(chickenPic);
        }
        else if (sandwichType.getSelectionModel().getSelectedIndex() == 2){
            imageSelect.fitWidthProperty();
            imageSelect.fitHeightProperty();
            imageSelect.setImage(beefPic);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Program is starting\n");
        sandwichType.setItems(FXCollections.observableArrayList(sandwichSelect));
        sandwichType.getSelectionModel().select(1);
    }

    /**
     * A void method that sets radio buttons into a group for a single selection
     */


    public void getSandwichType(){

        sandwichType.itemsProperty();
        setImageSelect();
    }

}
