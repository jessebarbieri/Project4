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
        lineNumber = 1;
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
            OrderLine line = new OrderLine(lineNumber++, f, f.price());
            orderlines.add(line);
        }else if(obj instanceof Chicken){
            //System.out.println("Adding Chicken Sandwich\n" + obj.toString());
            Chicken c = new Chicken();
            c.extras = ((Chicken) obj).extras;
            OrderLine line = new OrderLine(lineNumber++, c, c.price());
            orderlines.add(line);
        }else if(obj instanceof Beef){
            //System.out.println("Adding Beef Sandwich\n" + obj.toString());
            Beef b = new Beef();
            b.extras = ((Beef) obj).extras;
            OrderLine line = new OrderLine(lineNumber++, b, b.price());
            orderlines.add(line);
        }
        System.out.println("Things in orderlines: " + orderlines.size());
        return true;
    }

    public String getLine(int lineNumber){
        System.out.println(lineNumber);
        String line = orderlines.get(lineNumber).toString();

        return line;
    }

    @Override
    public boolean remove(Object obj) {
        boolean res = true;

        int num = (int)obj;
        System.out.println("Object sent: " + getLine(num-1) + "------------------------------");
        String[] objS = orderlines.get(num-1).toString().split("\\s");
        String lineNum = objS[0];
        String type = objS[3];
        String price = objS[5];

        if(type.equals("Chicken")){
            Sandwich c = new Chicken();
            OrderLine n = new OrderLine(Integer.parseInt(lineNum), c, Double.parseDouble(price));
            System.out.println(n.toString());
            if(n.toString().equals(getLine(num-1))){
                OrderLine n1 = new OrderLine(Integer.parseInt(lineNum), null, 0);
                orderlines.set(num-1, n1);
            }else{
                res = false;
            }
        }else if(type.equals("Fish")){
            Sandwich f = new Fish();
            OrderLine n = new OrderLine(Integer.parseInt(lineNum), f, Double.parseDouble(price));
            if(n.toString().equals(getLine(num-1))){
                OrderLine n1 = new OrderLine(Integer.parseInt(lineNum), null, 0);
                orderlines.set(num-1, n1);
            }else{
                res = false;
            }
        }if(type.equals("Beef")){
            Sandwich b = new Beef();
            OrderLine n = new OrderLine(Integer.parseInt(lineNum), b, Double.parseDouble(price));
            if(n.toString().equals(getLine(num-1))){
                OrderLine n1 = new OrderLine(Integer.parseInt(lineNum), null, 0);
                orderlines.set(num-1, n1);
            }else{
                res = false;
            }
        }
        reorder();
        System.out.println("------------------------------");
        return res;
    }

    /**
     * Reorders the orderlines arraylist to account for removing orders
     */
    public void reorder(){
        for(int i = 0; i < orderlines.size(); i++){
            if(orderlines.equals(new OrderLine(i, null, 0))){
                orderlines.remove(new OrderLine(i, null, 0));
            }
        }
    }

}