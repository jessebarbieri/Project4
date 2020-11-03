package SandwichManager;

public class Fish extends Sandwich {
    @Override
    public double price() {
        return 12.99;
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
