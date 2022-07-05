/**
 * Program performs variety of functions that relate to coffee shop setting. This includes but is not limited to saving the date/time of coffee orders, storing and updating coffee ingredient inventory, and providing the user the ability to read the inventory to see how much of each ingredient is remaining.
 *
 * @author JJ Rezaei
 * Class Project for SDSU CS160 Lab 2022 Summer Session
 *
 */

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;


public class Main {
    private static Milk milk;
    private static Sugar sugar;
    private static WhippedCream cream;
    private static HotWater water;

    public static void main(String[] args) throws FileNotFoundException {
        String quitInput;
        ArrayList<String> Item = new ArrayList<>();
        ArrayList<Double> price = new ArrayList<>();
        ArrayList<String> Temp2 = new ArrayList<>();

        Stack<String> stack = new Stack<>();
        stack.push(PrintOrder(Item,price));

        Scanner CafeApplication = new Scanner(System.in);
        System.out.println("Cafe Application Running...\nPress  1 : Read Inventory\nPress 2 : Create Coffee Order\nPress 3 : Update Inventory\nPress 4 : Update log file\nPress 5 : display toppings\nPress 6 : Exit the application");
        int input = 0;
        while(input != 1) {
            switch(CafeApplication.nextLine()) {
                case "1":
                    inventoryReader();
                    System.out.println("Cafe Application Running...\nPress  1 : Read Inventory\nPress 2 : Create Coffee Order\nPress 3 : Update Inventory\nPress 4 : Update log file\nPress 5 : display toppings\nPress 6 : Exit the application");
                    break;
                case "2":
                    System.out.println("Coffee order created. Select toppings for the first coffee:");
                    System.out.println("Enter the string to add toppings: milk, hot water, espresso, sugar, whipped cream, done to complete order");
                    CreateOrder();
                    Scanner userOrders = new Scanner(System.in);

                    do {
                        Temp2 = CreateOrder();
                        Item.add(Temp2.get(0));
                        price.add(Double.valueOf(Temp2.get(1)));


                        System.out.println("Do you want to add another coffee to this order? - yes or no");
                        quitInput = userOrders.nextLine();
                    } while (!(quitInput = userOrders.nextLine()).equals("no"));
                    System.out.println("Cafe Application Running...\nPress  1 : Read Inventory\nPress 2 : Create Coffee Order\nPress 3 : Update Inventory\nPress 4 : Update log file\nPress 5 : display toppings\nPress 6 : Exit the application");
                    break;
                case "3":
                    System.out.println("Updating inventory...");
                    inventoryWriter(topVals);
                    break;
                case "4":
                    logWriter(stack);
                    break;
                case "5":
                    displayPriceOrder();
                    break;
                case "6":
                    inventoryWriter(topVals);
                    logWriter(stack);
                    input = 1;
                    break;
                default:
                    System.out.println("Invalid selection. Please try again");
            }
        }

        /**
         * creates log file
         */
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(date);
        try {
            FileWriter writer = new FileWriter("CoffeeShopOutput.txt",true);
            writer.write(strDate + "\n" + stack.pop());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <p>displayPriceOrder prompts the user to choose between displaying the order of the cost of the toppings from least to greatest or greatest to least. Based on the user's decision the method will print out costs</p>
     */
    public static void displayPriceOrder() {
        System.out.println("would you like prices displayed (1)least to greatest OR (2)greatest to least?");
        Scanner scnr = new Scanner(System.in);
        ArrayList<Double> costToppings= new ArrayList<Double>(  );
        costToppings.add(Milk.milkCost);
        costToppings.add(Sugar.sugarCost);
        costToppings.add(WhippedCream.creamCost);
        costToppings.add(HotWater.waterCost);
        switch(scnr.nextInt()) {
            case 1 :
                Collections.sort(costToppings);
                System.out.println(costToppings.get(0) + " = hot water \n" + costToppings.get(1) + " = whipped cream\n" + costToppings.get(2) + " = sugar\n" + costToppings.get(3) + " = milk");
                break;
            case 2 :
                Collections.sort(costToppings , Collections.reverseOrder());
                System.out.println(costToppings.get(0) + " = milk\n" + costToppings.get(1) + " = sugar\n" + costToppings.get(2) + " = whipped cream\n" + costToppings.get(3) + " = hot water");
                break;
            default:
                System.out.println("Invalid input. Please try again.");
        }
    }

    /**
     * <p>
     *     inventoryWriter takes in topVals1 (or more generally, topVals) and utilizes the filewriter to put that information in a more descriptive and legible .txt document
     * </p>
     * @param topVals1 array that is emblematic of ingredients in inventory
     */
    public static void inventoryWriter(int[] topVals1){
        int va1 = topVals1[0];
        int va2 = topVals1[1];
        int va3 = topVals1[2];
        int va4 = topVals1[3];
        int va5 = topVals1[4];
        int va6 = topVals1[5];

        String v1a = "" + va1;
        String v2a = "" + va2;
        String v3a = "" + va3;
        String v4a = "" + va4;
        String v5a = "" + va5;
        String v6a = "" + va6;

        try {
            FileWriter fwInvent = new FileWriter("C:\\Users\\jasmi\\Dropbox\\PC\\Documents\\Inventory.txt");
            BufferedWriter bfWrite = new BufferedWriter(fwInvent);

            bfWrite.write("Black Coffee = " + v1a + "\nMilk = " + v2a + "\nHotWater = " + v3a + "\nEspresso " + v4a + "\nSugar = " + v5a + "\nWhippedCream = " + v6a);
            bfWrite.close();
            System.out.println("Successfully updated the inventory");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     *<p>
     *     logWriter takes the coffee orders and puts the information about them into a .txt log. This information includes the order as well as the time and date the order the created
     *</p>
     * @param stack1 the coffee orders that were pushed into a stack
     */
    public static void logWriter(Stack<String> stack1) {
        FileWriter myWriter = null;
        try {
            myWriter = new FileWriter("LogFile.txt", true);
            if(stack1.empty()) {
                System.out.println("Nothing to log. Stack is empty.");
            }
            while(!stack1.empty()) {
                stack1.pop();
            }
            System.out.println("successfully updated log file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss ;");
        Date date = new Date(System.currentTimeMillis());
        try {
            myWriter.write("\n\nWriting orders from stack " + formatter.format(date));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    StringBuilder str = new StringBuilder("RECEIPT \n \n");
    /**
     * <p>PrintOrder prints out the complete order of the customer. This includes the individual prices, coffee(s) they ordered, and the total price</p>
     *
     * @param Item the order itself
     * @param price the calculated price of the order
     * @return the receipt in string format
     */
    public static String PrintOrder(ArrayList<String> Item, ArrayList<Double> price) {


        double total = 0;
        String oneItem;
        Double onePrice;
        StringBuilder str = new StringBuilder("RECEIPT \n \n");


        for (int i = 0; i < Item.size(); i++) {
            oneItem = Item.get(i);
            onePrice = price.get(i);
            str.append("Item " + (i + 1) + ": " + oneItem + " | Cost: " + onePrice + "\n\n");
            total += onePrice;
        }
        str.append("TOTAL COST OF ORDER: " + total);
        return str.toString();
    }

    /**
     * <p>toString converts to String</p>
     * @return string version of the receipt
     */

    public String toString() {
        return str + "";
    }

    /**
     * <p>CreateOrder takes in the user input and constructs their coffee order(s)</p>
     * @return individual coffee order
     */
    public static ArrayList<String> CreateOrder() {
        Scanner userFeedback = new Scanner(System.in);
        ArrayList<String> coffeeOrder = new ArrayList<String>();
        inventoryReader();


        Coffee basicCoffee = new BasicCoffee();
        BlackCoffee blackCoffee = new BlackCoffee(basicCoffee);
        inventoryWriter(topVals);
        int in = 0;

        while (in != 1) {
            String userInput = userFeedback.nextLine();
            System.out.println("type out toppings to add");
            if(topVals[0] == 0) {
                System.out.println(topVals[0]);
                System.out.println("Out of coffee. Visit us later.");
            }
            else {
                switch (userInput) {
                    case "black coffee":
                        if (topVals[0] == 0) {
                            System.out.println("Order completed. No more coffees");
                            break;
                        }
                            else if(topVals[0] == 1) {
                                topVals[0] = 0;
                            }
                         else {
                            topVals[0] = topVals[0] - 1;
                            break;
                        }
                    case "hot water":
                        if (topVals[1] == 0) {
                            System.out.println("Out of hot water. Try a different topping");
                        } else {
                            HotWater hotWater = new HotWater(basicCoffee);
                            topVals[1] = topVals[1]-1;
                        }
                        break;
                    case "whipped cream":
                        if (topVals[2] == 0) {
                            System.out.println("Out of whipped cream. Try a different topping");
                        } else {
                            WhippedCream whippedCream = new WhippedCream(basicCoffee);
                            topVals[2] = topVals[2]-1;
                        }
                        break;
                    case "milk":
                        if (topVals[3] == 0) {
                            System.out.println("Out of milk. Try a different topping");
                        } else {
                            Milk milk = new Milk(basicCoffee);
                            topVals[3] = topVals[3]-1;
                        }
                        break;
                    case "sugar":
                        if (topVals[4] == 0) {
                            System.out.println("Out of sugar. Try a different topping");
                        } else {
                            Sugar sugar = new Sugar(basicCoffee);
                            topVals[4] = topVals[4]-1;
                        }
                        break;
                    case "espresso":
                        if (topVals[5] == 0) {
                            System.out.println("Out of espresso. Try a different topping");
                        } else {
                            Espresso espresso = new Espresso(basicCoffee);
                            topVals[5] = topVals[5]-1;
                        }
                        break;
                    case "done":
                        in = 1;
                        System.out.println("Order created");

                        break;
                }
            }
        }
        return coffeeOrder;
    }

    static int[] topVals = new int[6];
    /**
     * <p>inventoryReader reads the inventory that is listed in the Inventory.txt file</p>
     * @return array emblematic of the read inventory
     */
    public static int[] inventoryReader() {
        FileReader frInvent;
        String[] subStrResult;

        try {
            frInvent = new FileReader("C:\\Users\\jasmi\\Dropbox\\PC\\Documents\\Inventory.txt");
            BufferedReader brInvent = new BufferedReader(frInvent);

            String temp55;
            subStrResult = new String[6];
            int count = 0;
            while ((temp55 = brInvent.readLine()) != null) { //read through the file
                System.out.println(temp55);
                subStrResult[count] = temp55.substring(temp55.length() - 2, temp55.length()); //numbers add to array
                count += 1;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 6; i++) { //iterate through toppings
            char temp;
            char temp2;
            if(subStrResult[i].length() == 2) {
            temp = subStrResult[i].charAt(0);
            temp2 = subStrResult[i].charAt(1); //if single digit (1-9) THIS variable (temp2) is what you want bc stores as " 1" basically (in contrast to "1 ")
            topVals[i] = (temp2 - '0') + ((temp - '0')*10); } //char into int
            else {
                temp2 = subStrResult[i].charAt(0); //temp2 = char at that place in array
                topVals[i] = (temp2 - '0'); } //turns char into int

        }
        return topVals;
    }
}