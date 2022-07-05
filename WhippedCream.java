/**
 * topping class for whipped cream, this class performs all the functions that relate to this topping
 */
public class WhippedCream extends CoffeeDecorator {
    static Double creamCost = .10;

    /**
     * WhippedCream brings in coffee object
     * @param coffee coffee object
     */
    public WhippedCream(Coffee coffee) {
        super(coffee);
    }

    /**
     * addTopping adds this topping to coffee object
     * @param coffee coffee object
     */
    @Override
    public void addTopping(Coffee coffee) {
        coffee.addTopping(this.coffee);
        this.coffee = coffee;
    }
    /**
     * <p> printCoffee prints coffee order with -whipped cream addition</p>
     * @return coffee order with -whipped cream
     */
    @Override
    public String printCoffee() {
        if (this.coffee instanceof WhippedCream) {
            return "1";
        } else {
            return this.coffee.printCoffee() + "-whipped cream";
        }
    }
    /**
     * <p>cost adds cost of whipped cream addon to total coffee cost</p>
     * @return cost of coffee + whipped cream
     */
    @Override
    public Double cost() {
        if (this.coffee instanceof WhippedCream) {
            return 1.0;
        }
        else{
                return this.coffee.cost() + 0.10;
            }
        }
    }
