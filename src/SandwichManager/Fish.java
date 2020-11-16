/**
 * @author Arya Kulkarni and Jesse Barbieri
 */
package SandwichManager;

import java.util.ArrayList;

/**
 * A subclass of sandwich, this creates a fish object, with the ability to add extra ingredients to it
 */
public class Fish extends Sandwich {

    /**
     * Constructor
     * @param extras arraylist of extras
     */
    public Fish(ArrayList<Extra> extras){
        for(Extra e : extras){
            this.extras.add(e);
        }
    }

    /**
     * Override price method returns the price for the Fish sandwich, including extra ingredients
     * @return returnPrice, the price after incorporating extra ingredients
     */
    @Override
    public double price() {
        double returnPrice = 12.99;
        returnPrice = returnPrice + (extras.size()*(PER_EXTRA));
        return returnPrice;
    }

    /**
     * Method that allows the addition of extra ingredients
     * @param obj, which is the ingredients
     * @return true or false, depending on if successful
     */
    @Override
    public boolean add(Object obj) {
        if(extras.size() > MAX_EXTRAS){
            return false;
        }
        return true;
    }

    /**
     * This method allows us to be able to remove extra ingredients
     * @param obj, which is the ingredients
     * @return boolean
     */
    @Override
    public boolean remove(Object obj) {
        return false;
    }

    /**
     * This method returns a string of the object
     * @return The string of extras ingredients and basic ingredients for the sandwich object
     */
    @Override
    public String toString() {
        return extras.toString().replace("[", "").replace("]", "")+ " Basic: Grilled Snapper, Cilantro, Lime";
    }

}
