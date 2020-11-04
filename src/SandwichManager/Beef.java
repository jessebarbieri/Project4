package SandwichManager;

public class Beef extends Sandwich{

    @Override
    public double price() {
        return 10.99;
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
