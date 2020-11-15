/**
 * @author Arya Kulkarni and Jesse Barbieri
 */
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
import java.util.*;
import java.util.List;

/**
 * Gets the createOrder Controller ready
 */
public class createOrderController implements Initializable {

    public Order currOrder = new Order();

    public createOrderController() {
        this.currOrder = currOrder;
    }

    @FXML
    ComboBox<String> sandwichType;

    @FXML
    Button addOrder;

    @FXML
    ListView basicList;

    @FXML
    ListView ingredList;

    @FXML
    ListView finalIngredList;

    @FXML
    Label viewPrice;

    // This is just to display the options on the GUI
    String[] sandwichSelect = {"Fish", "Chicken", "Beef"};
    ArrayList<Extra> extraList = new ArrayList<Extra>();

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
    ObservableList<String> ingredientList = FXCollections.observableArrayList
            (Extra.Olives.toString(), Extra.Pickles.toString(), Extra.American_Cheese.toString(),
                    Extra.Cucumbers.toString(), Extra.Lettuce.toString(), Extra.Mayo.toString(),
                    Extra.Mustard.toString(), Extra.Red_Onion.toString(), Extra.Swiss_Cheese.toString(),
                    Extra.Tomato.toString());
    ObservableList<String> addedList = FXCollections.observableArrayList();


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

    /**
     * Initialize the stage
     * @param url n/a
     * @param resourceBundle n/a
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //System.out.println("Program is starting\n");
        sandwichType.setItems(FXCollections.observableArrayList(sandwichSelect));
        sandwichType.getSelectionModel().select(1);
        imageSelect.setImage(chickenPic);
        basicList.setItems(basicChicken);
        viewPrice.setText("$8.99");
        sandwichType.getSelectionModel().select("Chicken");
        basicList.setDisable(true);
        ingredList.setItems(ingredientList);
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
        int size = addedList.size()+1;
        Sandwich s;
        switch (sandwich) {
            case "Fish":
                // create object
                s = new Fish(extraList);
                //f.extras = extraList;
                //System.out.println("Fish extras: " + f.extras);
                currOrder.add(s); // added to orderlines
                finalIngredList.getItems().clear(); // clearing 1st GUI

                // adding it to the list that will show up on the 2nd GUI
                addedList.add(currOrder.getLine(currOrder.getLineNumber()-1));
                // clearing extraList which is added to "addedList"
                extraList.clear();
                break;
            case "Chicken":
                // create object
                s = new Chicken(extraList);
                //s.extras = extraList;
                currOrder.add(s);
                finalIngredList.getItems().clear();
                addedList.add(currOrder.getLine(currOrder.getLineNumber()-1));

                extraList.clear();
                break;
            case "Beef":
                // create object
                s = new Beef(extraList);
                //s.extras = extraList;
                currOrder.add(s);
                finalIngredList.getItems().clear();
                addedList.add(currOrder.getLine(currOrder.getLineNumber()-1));

                extraList.clear();
                break;
        }

        //System.out.println("Add:" + currOrder.getLine(0));

    }

    public void setAddOrder(){
            addOrder(sandwichType.getSelectionModel().getSelectedItem());
    }

    public void setAddIngred() {
        String currentIngred = "";
        try {
            currentIngred = ingredList.getSelectionModel().getSelectedItem().toString();
        }catch (NullPointerException e){
            //System.out.println("Please pick an extra");
            displayExtra();
        }

        if (!finalIngredList.getItems().contains(currentIngred)) {
            if(extraList.size() < 6){
                // add
                if(currentIngred.equals(Extra.American_Cheese.toString())){
                    extraList.add(Extra.American_Cheese);
                    finalIngredList.getItems().add(currentIngred);
                }else if(currentIngred.equals(Extra.Cucumbers.toString())){
                    extraList.add(Extra.Cucumbers);
                    finalIngredList.getItems().add(currentIngred);
                }else if(currentIngred.equals(Extra.Lettuce.toString())){
                    extraList.add(Extra.Lettuce);
                    finalIngredList.getItems().add(currentIngred);
                }else if(currentIngred.equals(Extra.Mayo.toString())){
                    extraList.add(Extra.Mayo);
                    finalIngredList.getItems().add(currentIngred);
                }else if(currentIngred.equals(Extra.Mustard.toString())){
                    extraList.add(Extra.Mustard);
                    finalIngredList.getItems().add(currentIngred);
                }else if(currentIngred.equals(Extra.Olives.toString())){
                    extraList.add(Extra.Olives);
                    finalIngredList.getItems().add(currentIngred);
                }else if(currentIngred.equals(Extra.Pickles.toString())){
                    extraList.add(Extra.Pickles);
                    finalIngredList.getItems().add(currentIngred);
                }else if(currentIngred.equals(Extra.Red_Onion.toString())){
                    extraList.add(Extra.Red_Onion);
                    finalIngredList.getItems().add(currentIngred);
                }else if(currentIngred.equals(Extra.Swiss_Cheese.toString())){
                    extraList.add(Extra.Swiss_Cheese);
                    finalIngredList.getItems().add(currentIngred);
                }else if(currentIngred.equals(Extra.Tomato.toString())){
                    extraList.add(Extra.Tomato);
                    finalIngredList.getItems().add(currentIngred);
                }
            }else{
                // can't add
                //System.out.println("List is full! It has a size of..." + extraList.size());
                displayLimit();
            }

        }

    }


    public void setRemoveIngred(){
        String currentIngred = "";

        try {
            currentIngred = (finalIngredList.getSelectionModel().getSelectedItem()).toString();
        }catch (NullPointerException e){
            //System.out.println("Please select which item to remove");
            displayRemove();
        }
        finalIngredList.getItems().remove(currentIngred);
        // check which extra is there
        if(currentIngred.equals(Extra.American_Cheese.toString())){
            extraList.remove(Extra.American_Cheese);
        }else if(currentIngred.equals(Extra.Cucumbers.toString())){
            extraList.remove(Extra.Cucumbers);
        }else if(currentIngred.equals(Extra.Lettuce.toString())){
            extraList.remove(Extra.Lettuce);
        }else if(currentIngred.equals(Extra.Mayo.toString())){
            extraList.remove(Extra.Mayo);
        }else if(currentIngred.equals(Extra.Mustard.toString())){
            extraList.remove(Extra.Mustard);
        }else if(currentIngred.equals(Extra.Olives.toString())){
            extraList.remove(Extra.Olives);
        }else if(currentIngred.equals(Extra.Pickles.toString())){
            extraList.remove(Extra.Pickles);
        }else if(currentIngred.equals(Extra.Red_Onion.toString())){
            extraList.remove(Extra.Red_Onion);
        }else if(currentIngred.equals(Extra.Swiss_Cheese.toString())){
            extraList.remove(Extra.Swiss_Cheese);
        }else if(currentIngred.equals(Extra.Tomato.toString())){
            extraList.remove(Extra.Tomato);
        }
    }


    public static Stage secondStage = new Stage();

    public void setShowOrder(){
        try {
            Stage secondaryStage = new Stage();
            secondStage = secondaryStage;
            FXMLLoader loader =  new FXMLLoader(getClass().getResource("orderDetails.fxml"));
            Parent root = loader.load();
            orderDetailController control2 = loader.getController();
            secondaryStage.setScene(new Scene(root, 600,480));
            secondaryStage.setTitle("Order Details");
            secondaryStage.show();
            control2.createOrderController(this);
            //System.out.println("Current order before second pass: " + currOrder.getLine(0));
            control2.setDisplay(addedList, currOrder, extraList);
            //control2.sendOrder(currOrder, addedList);

            Main.mainStage.close();


        } catch (IOException e) {
            e.printStackTrace();
            displayShowError();
        }

    }


    /**
     * Alerts
     */
    public static void displayExtra(){
        Alert errorAlert = new Alert(Alert.AlertType.WARNING);
        errorAlert.setHeaderText("Order status");
        errorAlert.setContentText("Please select an extra(s)!");
        errorAlert.showAndWait();
    }

    public static void displayRemove(){
        Alert errorAlert = new Alert(Alert.AlertType.WARNING);
        errorAlert.setHeaderText("Order status");
        errorAlert.setContentText("Please select an extra to remove!");
        errorAlert.showAndWait();
    }

    public static void displayShowError(){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("Order status");
        errorAlert.setContentText("Something is wrong with the order!");
        errorAlert.showAndWait();
    }

    public static void displayLimit(){
        //List is full! It has a size of..." + extraList.size()
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("Order status");
        errorAlert.setContentText("You reached the limit for extras!");
        errorAlert.showAndWait();
    }
}
