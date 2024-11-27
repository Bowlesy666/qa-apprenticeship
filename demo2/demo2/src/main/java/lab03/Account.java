package lab03;

public class Account {
    private int id;
    private double balance;
    private String owner;

    public Account(int id, double balance, String owner) {
        this.id = id;
        this.balance = balance;
        this.owner = owner;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void Deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("\tDeposit complete: £" + amount + " deposited\n\tTotal Balance: £" + this.balance + "\n");
        } else {
            System.out.println("\n\tPlease deposit a positive amount!");
            throw new IllegalArgumentException("\tInvalid deposit amount");
        }
    }

    public void Withdraw(double amount) {
        if (amount < this.balance) {
            this.balance -= amount;
            System.out.println("\tWithdawal complete: £" + amount + " withdrawn\n\tTotal Balance: £" + this.balance + "\n");
        } else {
            System.out.println("\n\tYou dont have enough funds, please choose a lower amount!");
            throw new IllegalArgumentException("\tInvalid withdrawal amount: You are poor!");
        }
    }

    public void close() {
        System.out.println("\n\tAccount: " + this.id + " is closed!\n");
    }

    public void getDetails() {
        System.out.println("\n\tOwner:\t\t" + this.owner + "\n\tId:\t\t\t" + this.id + "\n\tBalance\t\t" + this.balance + "\n");
    }
}
