package SandwichManager;

import java.util.ArrayList;

public class Order implements Customizable {
    public static int lineNumber;

    @Override
    public boolean add(Object obj) {
        lineNumber++;
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        lineNumber--;
        return false;
    }
}
