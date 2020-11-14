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
            //System.out.println("Adding Fish Sandwich\n" + obj.toString());
            Fish f = new Fish();
            f.extras = ((Fish) obj).extras;
            OrderLine line = new OrderLine(lineNumber, f, f.price());
            orderlines.add(line);
        }else if(obj instanceof Chicken){
            //System.out.println("Adding Chicken Sandwich\n" + obj.toString());
            Chicken c = new Chicken();
            c.extras = ((Chicken) obj).extras;
            OrderLine line = new OrderLine(lineNumber, c, c.price());
            orderlines.add(line);
        }else if(obj instanceof Beef){
            //System.out.println("Adding Beef Sandwich\n" + obj.toString());
            Beef b = new Beef();
            b.extras = ((Beef) obj).extras;
            OrderLine line = new OrderLine(lineNumber, b, b.price());
            orderlines.add(line);
        }
        return true;
    }

    public String getLine(int lineNumber){
        System.out.println(lineNumber);
        String line = orderlines.get(lineNumber).toString();

        return line;
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }



}