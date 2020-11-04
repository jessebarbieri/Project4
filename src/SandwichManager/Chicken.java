package SandwichManager;

import java.util.Arrays;

public class Chicken extends Sandwich{

    String[] basic = new String[3];

    @Override
    public double price() {
        return 8.99;
    }

    @Override
    public boolean add(Object obj) {
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }
}
