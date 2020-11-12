package SandwichManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.security.spec.ECField;
import java.util.List;
import java.util.ResourceBundle;

public class createOrderController implements Initializable {

    Order currOrder = new Order();

    @FXML
    ComboBox<String> sandwichType;

    @FXML
    Button addOrder;

    @FXML
    ListView basicList;

    @FXML
    ListView ingredList;

    @FXML
    Label viewPrice;

    // This is just to display the options on the GUI
    String[] sandwichSelect = {"Fish", "Chicken", "Beef"};

    @FXML
    Button showOrder;

    // Declaring the images
    Image chickenPic = new Image(getClass().getResourceAsStream("chicken-sandwich.png"));
    Image beefPic = new Image(getClass().getResourceAsStream("beef-sandwich.png"));
    Image fishPic = new Image(getClass().getResourceAsStream("fish-sandwich.png"));


    ToggleGroup tg = new ToggleGroup();
    public ImageView imageSelect;

    // These observable ArrayLists serve the purpose of displaying basic ingredients.
    ObservableList<String> basicChicken = FXCollections.observableArrayList("Fried Chicken", "Spicy Sauce", "Pickles");
    ObservableList<String> basicFish = FXCollections.observableArrayList("Grilled Snapper", "Cilantro", "Lime");
    ObservableList<String> basicBeef = FXCollections.observableArrayList("Roast Beef", "Provolone Cheese", "Mustard");


    /**
     * This void method sets the image that correlates to the proper selected sandwich
     */
    public void setImageSelect() {
        if (sandwichType.getSelectionModel().getSelectedIndex() == 0) {
            imageSelect.fitWidthProperty();
            imageSelect.fitHeightProperty();
            imageSelect.setImage(fishPic);
            basicList.setItems(basicFish);
            viewPrice.setText("$12.99");
        } else if (sandwichType.getSelectionModel().getSelectedIndex() == 1) {
            imageSelect.fitWidthProperty();
            imageSelect.fitHeightProperty();
            imageSelect.setImage(chickenPic);
            basicList.setItems(basicChicken);
            viewPrice.setText("$8.99");
        } else if (sandwichType.getSelectionModel().getSelectedIndex() == 2) {
            imageSelect.fitWidthProperty();
            imageSelect.fitHeightProperty();
            imageSelect.setImage(beefPic);
            basicList.setItems(basicBeef);
            viewPrice.setText("$10.99");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Program is starting\n");
        sandwichType.setItems(FXCollections.observableArrayList(sandwichSelect));
        sandwichType.getSelectionModel().select(1);
        imageSelect.setImage(chickenPic);
        basicList.setItems(basicChicken);
        viewPrice.setText("$8.99");
        sandwichType.getSelectionModel().select("Chicken");
        basicList.setDisable(true);
    }

    /**
     * A void method that sets radio buttons into a group for a single selection
     */
    public void getSandwichType() {
        sandwichType.itemsProperty();
        setImageSelect();
    }

    /**
     * add order selected to the array
     *
     * @param sandwich string selected from GUI
     */
    public void addOrder (String sandwich) {
        switch (sandwich) {
            case "Fish":
                // create object
                Sandwich f = new Fish();
                currOrder.add(f);
                break;
            case "Chicken":
                // create object
                Sandwich c = new Chicken();
                currOrder.add(c);
                break;
            case "Beef":
                // create object
                Sandwich b = new Beef();
                currOrder.add(b);
                break;
        }
    }

    public void setAddOrder(){
        addOrder(sandwichType.getSelectionModel().getSelectedItem());
        // Add to order button works based on our selection
        //System.out.println("Sandwich Added: " + sandwichType.getSelectionModel().getSelectedItem());
    }

    public void setShowOrder(){
        try {
            Stage secondaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("orderDetails.fxml"));
            Parent root = loader.load();
            orderDetailController control2 = loader.getController();
            secondaryStage.setScene(new Scene(root, 600,480));
            secondaryStage.setTitle("Order Details");
            secondaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
