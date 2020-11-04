package SandwichManager;

import java.util.ArrayList;

public abstract class Sandwich implements Customizable {
    static final int MAX_EXTRAS = 6;
    static final double PER_EXTRA = 1.99;
    protected ArrayList<Extras> extras;

    // determines price with extra
    int size;

    {
        assert false;
        size = extras.size();
    }

    double priceTotalExtra = size * PER_EXTRA;

    public abstract double price();

    @Override
    public String toString() {
        return null;
    }
}