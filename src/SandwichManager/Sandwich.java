package SandwichManager;

import java.util.ArrayList;

public abstract class Sandwich implements Customizable {
    static final int MAX_EXTRAS = 6;
    static final double PER_EXTRA = 1.99;
    protected ArrayList<Extra> extras;
    public abstract double price();


    public Sandwich(){
        extras = new ArrayList<>();
    }

    /**
     * To string method that returns sandwich info
     * @return a string with extra info
     */

    @Override
    public String toString() {
        return extras.toString();
    }

}