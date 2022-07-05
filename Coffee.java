/**
 * interface for topping classes
 */
public interface Coffee {
    /**
     * adds topping to coffee object
     * @param coffee coffee object
     */
    void addTopping(Coffee coffee);

    /**
     * prints out coffee order with addition of the topping
     * @return coffee order with topping included
     */
    String printCoffee();

    /**
     * adds cost of topping to total cost of coffee
     * @return cost of coffee
     */
    Double cost();
}
