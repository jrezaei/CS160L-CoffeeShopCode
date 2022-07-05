/**
 * topping class for Sugar, this class performs all the functions that relate to this topping
 */
public class Sugar extends CoffeeDecorator {
    static Double sugarCost = .15;

    /**
     * Sugar brings in coffee object
     * @param coffee coffee object
     */
    public Sugar(Coffee coffee) {
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
     * <p> printCoffee prints coffee order with -sugar addition</p>
     * @return coffee order with -sugar
     */
    @Override
    public String printCoffee() {
        return this.coffee.printCoffee() + "-sugar";
    }
    /**
     * <p>cost adds cost of sugar addon to total coffee cost</p>
     * @return cost of coffee + sugar
     */
    @Override
    public Double cost() {
        return this.coffee.cost()+sugarCost;
    }
}
