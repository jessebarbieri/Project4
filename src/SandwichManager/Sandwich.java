package SandwichManager;

import java.util.ArrayList;

public abstract class Sandwich implements Customizable {
    static final int MAX_EXTRAS = 6;
    static final double PER_EXTRA = 1.99;
    protected ArrayList<Extras> extras;
    public abstract double price();

    public String toString() {
        // place holder
        return null;
    }
}
