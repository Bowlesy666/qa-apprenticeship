package lab08;

public class Account {
    private int id;
    private String owner;
    private double balance;

    public Account(int id, String owner, double balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void Deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposit complete: £" + amount + " deposited\nTotal Balance: £" + this.balance + "\n");
        } else {
            System.out.println("\nPlease deposit a positive amount!");
            throw new IllegalArgumentException("Invalid deposit amount");
        }
    }

    public void Withdraw(double amount) {
        if (amount < this.balance) {
            this.balance -= amount;
            System.out.println("Withdawal complete: £" + amount + " withdrawn\nTotal Balance: £" + this.balance + "\n");
        } else {
            System.out.println("\nYou dont have enough funds, please choose a lower amount!");
            throw new IllegalArgumentException("Invalid withdrawal amount");
        }
    }

    public void addInterest() {
        double interest = 0.025;

        this.balance += this.balance * interest;
    }

    void getDetails() {
        String formattedText = "Account owner: " + this.owner + " - funds available: £" + this.balance + "\n";
            System.out.println(formattedText);
    }
}
