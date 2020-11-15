package SandwichManager;

/**
 * Creates OrderLine with sandwich class(es) (Add to Order)
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
        this.lineNumber = lineNumber;
        //this.lineNumber = ++Order.lineNumber;
        this.sandwich = sandwich;
        this.price = price;

        //this.price = sandwich.price();
    }

    @Override
    public String toString(){
        String sandwichString = "";
        if (sandwich instanceof Chicken){
            sandwichString = "Chicken";
        }
        else if (sandwich instanceof Fish){
            sandwichString = "Fish";
        }
        else if (sandwich instanceof  Beef){
            sandwichString = "Beef";
        }
        return lineNumber + " Sandwich Type: " + sandwichString + " Price: " + price;
    }



}
