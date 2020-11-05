package SandwichManager;

/**
 * Creates OrderLine with sandwich class(es)
 */
public class OrderLine {
    private int lineNumber;
    private Sandwich sandwich;
    private double price;

    /**
     * Default Constructor for OrderLine Class
     * @param lineNumber order line number
     * @param sandwich type of sandwich
     * @param price price of specific sandwich
     */
    public OrderLine(int lineNumber, Sandwich sandwich, double price){
        this.lineNumber = Order.lineNumber;
        this.sandwich = sandwich;
        this.price = sandwich.price();
    }

    @Override
    public String toString(){
        return lineNumber + " Sandwich Type: " + sandwich + " Price" + price;
    }

}
