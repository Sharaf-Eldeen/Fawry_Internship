package Classes;

public class Customer {
    
    private String name;
    private double balance;

    public Customer(String customarName, double customarBalance) {
        this.name = customarName;
        this.balance = customarBalance;
    }

    public boolean canAfford(double amount) {
        return balance >= amount;
    }

    public void deductBalance(double amount) {
        this.balance = balance - amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

}
