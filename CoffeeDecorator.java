/**
 * abstract class that implements coffee interface
 */
public abstract class CoffeeDecorator implements Coffee {

    protected Coffee coffee;

    /**
     * CoffeeDecorator setter for coffee object
     * @param coffee coffee object
     */
    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    /**
     * addTopping adds topping to coffee object
     * @param coffee coffee object
     */
    public void addTopping(Coffee coffee) {
        this.coffee.addTopping(coffee);
    }

    /**
     * printCoffee prints coffee object's information
     * @return toppings of coffee object
     */
    public String printCoffee() {
        return this.coffee.printCoffee();
    }

    /**
     * cost is a method for calculating cost of the coffee object
     * @return cost of coffee
     */
    public abstract Double cost();
}
