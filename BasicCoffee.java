public class BasicCoffee implements Coffee {
    /**
     * addTopping has no topping that needs to be added hence method is empty. In other topping classes this method would add topping to the object
     * @param coffee coffee object
     */
    @Override
    public void addTopping(Coffee coffee) {

    }

    /**
     * printCoffee prints a no toppings added coffee, a "black coffee"
     * @return string that is emblematic of coffee order
     */
    @Override
    public String printCoffee() {
        return "Black coffee";
    }

    /**
     * cost provides cost of black coffee
     * @return cost of a black coffee
     */
    @Override
    public Double cost() {
        return 0.85;
    }
}
