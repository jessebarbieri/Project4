package SandwichManager;

import java.util.ArrayList;

/**
 * Creates an ArrayList of Orders with various OrderLines
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
     * Adds sandwiches to the order -- INCOMPLETE
     * @param obj any object of Sandwich
     * @return res if added or not
     */

    @Override
    public boolean add(Object obj) {
        System.out.println("Adding " + obj.toString());
        boolean res = false;
        if(obj instanceof Chicken){
            lineNumber++;
            OrderLine line = new OrderLine(lineNumber, (Sandwich) obj, ((Chicken) obj).price());
            orderlines.add(line);
            System.out.println(line);
            res = true;

        }
        else if(obj instanceof Fish){
            Sandwich f = new Fish();
            lineNumber++;
            OrderLine line = new OrderLine(lineNumber, f, f.price());
            orderlines.add(line);
            System.out.println(line);
            res = true;

        }
        else if(obj instanceof Beef) {
            lineNumber++;
            OrderLine line = new OrderLine(lineNumber, (Sandwich) obj, ((Beef) obj).price());
            orderlines.add(line);
            System.out.println(line);
            res = true;

        }
        return res;
    }

    @Override
    public boolean remove(Object obj) {
        System.out.println("Removing " + obj.toString());
        boolean res = false;
        if(obj instanceof Chicken){
            lineNumber--;
            OrderLine line = new OrderLine(lineNumber, (Sandwich) obj, ((Chicken) obj).price());
            orderlines.remove(line);
            System.out.println(line);
            res = true;
        }
        else if(obj instanceof Fish){
            lineNumber--;
            OrderLine line = new OrderLine(lineNumber, (Sandwich) obj, ((Fish) obj).price());
            orderlines.remove(line);
            System.out.println(line);
            res = true;
        }
        else if(obj instanceof Beef){
            lineNumber--;
            OrderLine line = new OrderLine(lineNumber, (Sandwich) obj, ((Beef) obj).price());
            orderlines.remove(line);
            System.out.println(line);
            res = true;
        }
        return res;
    }


}
