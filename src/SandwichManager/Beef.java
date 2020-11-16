package SandwichManager;

import java.util.ArrayList;

public class Beef extends Sandwich {
    /**
     * Default constructor for the Beef sandwich
     * @param extras, extras added to the sandwich
     */
    public Beef(ArrayList<Extra> extras){

        for(Extra e : extras){
            this.extras.add(e);
        }
        //this.extras = new ArrayList<>(6);
        //this.extras = extras;
    }

    /**
     * Override price method returns the price for the Beef sandwich, including extra ingredients
     * @return
     */
    @Override
    public double price() {
        double returnPrice = 10.99;
        returnPrice = returnPrice + (extras.size()*(PER_EXTRA));
        return returnPrice;
    }

    /**
     * Method that allows the addition of extra ingredients
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

    @Override
    public String toString() {
        return extras.toString().replace("[", "").replace("]", "") + " Base Ingredients: Roast Beef, Provolone Cheese, Mustard";
    }

}
