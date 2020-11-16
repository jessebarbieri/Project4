/**
 * @author Arya Kulkarni and Jesse Barbieri
 */
package SandwichManager;

import javafx.beans.Observable;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

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
        this.orderlines = new ArrayList<>(10);
        lineNumber = 0;
    }

    /**
     * Assists with getting price
     * @return double price total
     */
    public double getPrice(){
        double res = 0;
        // string at 5 for price
        for(int i = 0; i < orderlines.size(); i++){
            String s = orderlines.get(i).toString();
            String[] splited = s.split("\\s");
            res = res + Double.parseDouble(splited[5]);
        }

        return res;
    }

    /**
     * Assists with exporting
     * @return string array with items
     */
    public String[] getOrders(){
        String[] res = new String[orderlines.size()];

        for(int i = 0; i < res.length; i++){
            res[i] = getLine(i);
        }
        return res;
    }


    /**
     * Adding sandwich to OrderLines
     * @param obj
     * @return
     */
    @Override
    public boolean add(Object obj) {
        // adding sandwich order to array
        if(obj instanceof Fish) {
            //System.out.println("Adding Fish Sandwich\n" + obj.toString());
            Fish f = new Fish(((Fish) obj).extras);
            f.extras = ((Fish) obj).extras;
            OrderLine line = new OrderLine(++lineNumber, f, f.price());
            orderlines.add(line);
        }else if(obj instanceof Chicken){
            //System.out.println("Adding Chicken Sandwich\n" + obj.toString());
            Chicken c = new Chicken(((Chicken) obj).extras);
            //c.extras = ((Chicken) obj).extras;
            OrderLine line = new OrderLine(++lineNumber, c, c.price());
            orderlines.add(line);
        }else if(obj instanceof Beef){
            //System.out.println("Adding Beef Sandwich\n" + obj.toString());
            Beef b = new Beef(((Beef) obj).extras);
            //b.extras = ((Beef) obj).extras;
            OrderLine line = new OrderLine(++lineNumber, b, b.price());
            orderlines.add(line);
        }
        //System.out.println("Things in orderlines: " + orderlines.size());

        return true;
    }

    public void clear(){
        orderlines.clear();
        //System.out.println("Orderlines size: " + orderlines.size());
        orderlines = new ArrayList<>(10);
        lineNumber = 0;
    }

    /**
     * Add same item again
     * @param ln where it is
     * @return boolean if true
     */
    public boolean addSame(int ln){
        //System.out.println("HERE " + orderlines.get(ln));
        OrderLine sandwichpo = new OrderLine(orderlines.get(ln));
        //System.out.println("Nerd: "+ sandwichpo);
        orderlines.add(sandwichpo);
        lineNumber++;
        reorder();

        return false;
    }

    /**
     * gets linenumber
     * @return int linenumber
     */
    public int getLineNumber(){
        //System.out.println("Linenumber - " + lineNumber);
        return lineNumber;
    }

    /**
     * Gets item as a string
     * @param lineNumber int where it is
     * @return String representation of item
     */
    public String getLine(int lineNumber){
        //System.out.println(lineNumber);
        String line = orderlines.get(lineNumber).toString();

        return line;
    }

    /**
     * Gets orderline object
     * @param lineNumber where the item is
     * @return orderline item needed
     */
    public OrderLine getOLine(int lineNumber){
        return orderlines.get(lineNumber);
    }

    /**
     * Removes item from order
     * @param obj Object to be removed
     * @return res if removed or not
     */
    @Override
    public boolean remove(Object obj) {
        boolean res = true;
        int num = (int)obj;
        orderlines.remove(num-1);
        lineNumber--;
        orderlines.trimToSize();
        //System.out.println("Remove Orderline: - " + orderlines.toString());

        reorder();
        return res;
    }



    /**
     * Reorders the orderlines arraylist to account for removing orders
     */
    public void reorder(){
        for(int i = 0; i < orderlines.size(); i++){
            OrderLine element = orderlines.get(i);
            element.setLineNumber(i+1);
            orderlines.set(i, element);
        }
        //System.out.println("Orderlines: " + orderlines.toString());
    }

}