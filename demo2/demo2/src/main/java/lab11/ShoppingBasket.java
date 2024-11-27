package lab11;

public class ShoppingBasket {
    String productName;
    int quantity;
    double price;

    public ShoppingBasket(String productName, int quantity, double price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("\tProduct: " + this.productName + " | Quantity: " + this.quantity + " | Price: " + this.price);
    }
}
