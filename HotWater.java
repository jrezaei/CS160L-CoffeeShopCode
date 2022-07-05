/**
 * topping class for hot water, this class performs all the functions that relate to this topping
 */
public class HotWater extends CoffeeDecorator {
    static Double waterCost = 0.0;

    /**
     * HotWater brings in coffee object
     * @param coffee coffee object
     */
    public HotWater(Coffee coffee) {
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
     * <p> printCoffee prints coffee order with -hot water addition</p>
     * @return coffee order with -hot water
     */
    @Override
    public String printCoffee() {
        return this.coffee.printCoffee() + "-Hot Water";
    }
    /**
     * <p>cost adds cost of hot water addon to total coffee cost</p>
     * @return cost of coffee + hot water
     */
    @Override
    public Double cost() {
        return 0.0;
    }
}
