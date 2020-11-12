package SandwichManager;

public class Fish extends Sandwich {



    @Override
    public double price() {
        double returnPrice = 12.99;
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
