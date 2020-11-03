package SandwichManager;

public class Chicken extends Sandwich{
    @Override
    public double price() {
        return 8.99;
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
