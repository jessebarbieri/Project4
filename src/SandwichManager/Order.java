package SandwichManager;

import java.util.ArrayList;

<<<<<<< HEAD
public class Order implements Customizable {
    public static int lineNumber;
=======
public class Order implements Customizable { public static int lineNumber;
>>>>>>> d04c0472490b51eb7a857eb68cc6ab8142d3cd3b
    private ArrayList<OrderLine> orderlines;

    @Override
    public boolean add(Object obj) {
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }
}
