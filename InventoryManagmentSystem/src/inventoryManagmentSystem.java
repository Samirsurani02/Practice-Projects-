import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Item{
    private String name;
    private int quantity;

    public Item(String name,int quantity){
        this.name=name;
        this.quantity=quantity;
    }
    public String getName() {
        return name;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantiy) {
        this.quantity = quantity;
    }
    @Override
    public String toString(){
        return "Item:"+name+",Quantity:"+quantity;
    }
}
public class inventoryManagmentSystem {

    private static ArrayList<Item> inventory = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[]args){
        int choice;
        do{
                System.out.println("\nInventory Management System");
                System.out.println("1. Add Item");
                System.out.println("2. Remove Item");
                System.out.println("3. Update Item Quantity");
                System.out.println("4. Display Inventory");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer

                switch (choice){
                    case 1 -> addItem();
                    case 2 -> removeItem();
                    case 3 -> updateItemQuantity();
                    case 4 -> displayInventory();
                    case 5 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice. Please try again.");
                }
        }while (choice != 5);
    }

    private static void addItem(){
        System.out.println("Enter Item Name: ");
        String name =scanner.nextLine();
        System.out.println("Enter Quantity: ");
        int quantity = scanner.nextInt();

        for (Item item:inventory){
            if (item.getName().equalsIgnoreCase(name)){
                System.out.println("Item already exists.");
                item.setQuantity(item.getQuantity()+quantity);
                return;
            }
        }
        inventory.add(new Item(name,quantity));
        System.out.println("Item Added Successfully");
    }

    private static void removeItem(){
        System.out.println("Enter item name to remove: ");
        String name =scanner.nextLine();

        for (Item item : inventory){
            if (item.getName().equalsIgnoreCase(name)){
                inventory.remove(item);
                System.out.println("Item Removed Successfully.");
                return;
            }
        }
        System.out.println("Item Not Found");
    }
    private static void updateItemQuantity(){
        System.out.println("Enter item name to update: ");
        String name = scanner.nextLine();
        System.out.println("Enter new Quantity: ");
        int newQuantity = scanner.nextInt();

        for (Item item: inventory){
            if (item.getName().equalsIgnoreCase(name)){
                item.setQuantity(newQuantity);
                System.out.println("Quantity updated successfully.");
                return;
            }
        }
        System.out.println("Item Not Found");
    }
    private static void displayInventory(){
        if (inventory.isEmpty()){
            System.out.println("Inventory is empty.");
        }else {
            System.out.println("\nInventory:");
            for (Item item: inventory){
                System.out.println(item);
            }
        }
    }
}
