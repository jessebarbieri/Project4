package SandwichManager;

import java.util.ArrayList;

public abstract class Sandwich implements Customizable {
    static final int MAX_EXTRAS = 6;
    static final double PER_EXTRA = 1.99;
<<<<<<< HEAD
    protected ArrayList<Extras> extras;
    public abstract double price();

    public String toString() {
        // place holder
=======
    protected ArrayList<Extra> extras;
    public abstract double price();

    @Override
    public String toString() {
>>>>>>> d04c0472490b51eb7a857eb68cc6ab8142d3cd3b
        return null;
    }
}
