package SandwichManager;

import java.util.ArrayList;

public class Fish extends Sandwich {

    /**
     * Constructor
     * @param extras arraylist of extras
     */
    public Fish(ArrayList<Extra> extras){
        for(Extra e : extras){
            this.extras.add(e);
        }
        //this.extras = new ArrayList<>(6);
        //this.extras = extras;
    }

    /**
     *
     * @return
     */
    @Override
    public double price() {
        double returnPrice = 12.99;
        returnPrice = returnPrice + (extras.size()*(PER_EXTRA));
        return returnPrice;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean add(Object obj) {
        if(extras.size() > MAX_EXTRAS){
            return false;
        }
        return true;
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }
}
