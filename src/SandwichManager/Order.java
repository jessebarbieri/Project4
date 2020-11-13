package SandwichManager;

import javafx.beans.Observable;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Creates an ArrayList of Orders with various OrderLines (Show Order)
 */
public class Order implements Customizable {
    public static int lineNumber;
    private ArrayList<OrderLine> orderlines;

    /**
     * Default Constructor
     */
    public Order(){
        this.orderlines = new ArrayList<>(0);
        lineNumber = 0;
    }


    /**
     * Adding extras to the order
     * @param obj
     * @return
     */
    @Override
    public boolean add(Object obj) {
        // adding sandwich order to array
        if(obj instanceof Fish) {
            System.out.println("Adding Fish Sandwich\n" + obj.toString());
            Fish f = new Fish();
            f.extras = ((Fish) obj).extras;
        }else if(obj instanceof Chicken){
            System.out.println("Adding Chicken Sandwich\n" + obj.toString());
            Chicken c = new Chicken();
            c.extras = ((Chicken) obj).extras;
        }else if(obj instanceof Beef){
            System.out.println("Adding Beef Sandwich\n" + obj.toString());
            Beef b = new Beef();
            b.extras = ((Beef) obj).extras;
        }
        return true;
    }


    @Override
    public boolean remove(Object obj) {
        return false;
    }



}
