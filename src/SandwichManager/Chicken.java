package SandwichManager;

import java.util.ArrayList;
import java.util.Arrays;

public class Chicken extends Sandwich{

    public Chicken(ArrayList<Extra> extras){
        for(Extra e : extras){
            this.extras.add(e);
        }
        //this.extras = new ArrayList<>(6);
        //this.extras = extras;
    }

    @Override
    public double price() {
        double returnPrice = 8.99;
        returnPrice = returnPrice + (extras.size()*(PER_EXTRA));
        return returnPrice;
    }

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
