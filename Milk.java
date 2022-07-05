/**
 * topping class for Milk, this class performs all the functions that relate to this topping
 */
public class Milk extends CoffeeDecorator {
    static Double milkCost = .15;
    /**
     * Milk brings in coffee object
     * @param coffee coffee object
     */
    public Milk(Coffee coffee) {
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
     * <p> printCoffee prints coffee order with -milk addition</p>
     * @return coffee order with -milk
     */
    @Override
    public String printCoffee() {
        return this.coffee.printCoffee() + "-milk";
    }

    /**
     * <p>cost adds cost of milk addon to total coffee cost</p>
     * @return cost of coffee + milk
     */
    @Override
    public Double cost() {
        return this.coffee.cost()+milkCost;
    }
}
