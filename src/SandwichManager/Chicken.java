package SandwichManager;

import java.util.Arrays;

public class Chicken extends Sandwich{

    public Chicken(double p){
        super(p);
        p = this.price();
    }

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
