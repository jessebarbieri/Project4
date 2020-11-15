package SandwichManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * gets the Order details page ready
 */
public class orderDetailController {
    Order currOrder1;
    @FXML
    private ListView display;
    private createOrderController controller;

    ArrayList<Extra> extraList1;



    @FXML
    Button export;

    @FXML

    Button back;

    @FXML
    Button removeButton;

    @FXML
    Button addButton;

    @FXML
    TextField price;

    ObservableList<String> removeList = FXCollections.observableArrayList();

    public void addOrder(){
        try {
            String addString = display.getSelectionModel().getSelectedItem().toString();
            //System.out.println("addString: " + addString);
            // split up into parts
            String[] parseRemove = addString.split("\\s");
            int linenumber = Integer.parseInt(parseRemove[0]);

            currOrder1.addSame(linenumber-1);


            int size = display.getItems().size()+1;
            display.getItems().clear();

            for(int i = 0; i < size; i ++) {
                //addedList.add(currOrder.getLine(currOrder.getLineNumber()-1));
                display.getItems().add(currOrder1.getLine(i));
            }

            // get price
            DecimalFormat df = new DecimalFormat("#,##0.00");
            setPrice(Double.parseDouble(df.format(currOrder1.getPrice())));

        }  catch(NullPointerException e){
            //System.out.println("Select an item to add");
            displayAddError();
        }
    }

    public void setPrice(Double val){
        String setP = String.valueOf(val);
        //System.out.println("Setting Price");
        //System.out.println("Setting Price");
        price.setText(setP);
    }


    public void createOrderController(createOrderController controller){
        controller = this.controller;
    }

    public void setDisplay(ObservableList list, Order currOrder, ArrayList<Extra> extraList){
        //System.out.println(currOrder.getLine(0));
        display.setItems(list);
        currOrder1 = currOrder;
        extraList1 = extraList;

        // get price
        DecimalFormat df = new DecimalFormat("#,##0.00");
        setPrice(Double.parseDouble(df.format(currOrder1.getPrice())));

    }

    public void setBack(){
        Main.mainStage.show();
        createOrderController.secondStage.close();
    }


    public void removeOrder(){
        try {
            String removeString = display.getSelectionModel().getSelectedItem().toString();

            // split up into parts
            String[] parseRemove = removeString.split("\\s");
            int linenumber = Integer.parseInt(parseRemove[0]);
            String type = parseRemove[3];
            double price = Double.parseDouble(parseRemove[5]);


            boolean res = currOrder1.remove(linenumber);
            display.getItems().remove(removeString);


            int size = display.getItems().size();
            display.getItems().clear();

            for(int i = 0; i < size; i ++) {
                //addedList.add(currOrder.getLine(currOrder.getLineNumber()-1));
                display.getItems().add(currOrder1.getLine(i));
            }

            //display.setItems(removeList);
            //list = removeList;


            // get price
            DecimalFormat df = new DecimalFormat("#,##0.00");
            setPrice(Double.parseDouble(df.format(currOrder1.getPrice())));


        }  catch(NullPointerException e){
            //System.out.println("Select an item to remove");
            displayRemoveError();

        }
    }

    public void initialize(URL url, ResourceBundle resourceBundle){

    }

    public void setBackButton(){
        //System.out.println("Send to Order Creation page");
        // close this page and open the first one
    }


    public void setExport(){
        try {
            File myObj = new File("orderOutput.txt");
            // write to file
            PrintWriter writer = new PrintWriter("orderOutput.txt", StandardCharsets.UTF_8);
            writer.println("--Printing Order --");
            String[] resArr = currOrder1.getOrders();
            for (String s : resArr) {
                writer.println(s);
            }
            writer.println("Price: " + price.getText());
            writer.println("--end of printing--");
            writer.close();
            displayCorrectFile();
            //System.out.println("File created to output accounts by Date Opened\n");
        } catch (IOException e) {
            e.printStackTrace();
            displayFileError();
        }
    }

    /**
     * Alerts
     */
    public static void displayAddError(){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("Order status");
        errorAlert.setContentText("Please select an item to add!");
        errorAlert.showAndWait();
    }

    public static void displayRemoveError(){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("Order status");
        errorAlert.setContentText("Please select an extra to remove!");
        errorAlert.showAndWait();
    }

    public static void displayFileError() {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("File could not be exported");
        errorAlert.setContentText("Something went wrong with your file import!");
        errorAlert.showAndWait();
    }

    public static void displayCorrectFile(){
        Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
        errorAlert.setHeaderText("Success!");
        errorAlert.setContentText("Order information has been exported!");
        errorAlert.showAndWait();
    }

}
