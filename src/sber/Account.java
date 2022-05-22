package sber;
import java.util.*;

public class Account {
    private int id;
    private double balance;
    private static double annualInterestRate;
    private Date dateCreated;
    private String name;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Account() {
        this(0,0D);
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        dateCreated = new Date();
    }

    public Account(int id, double balance, String name) {
        this.name = name;
        this.id = id;
        this.balance = balance;
        dateCreated = new Date();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static double getAnnualInterestRate(double rate) {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterest() {
        return balance * (annualInterestRate / 1200D);
    }

    public void withdraw(double num) {
        this.balance -= num;
        transactions.add(new Transaction('-', num, this.balance, "Операция снятия денежных средств"));
    }

    public void deposit(double num) {
        this.balance += num;
        transactions.add(new Transaction('+', num, this.balance, "Операция внесеения денежных средств"));
    }

    @Override
    public String toString() {
        return "Имя владельца счета: " + name + "\nПроцентная ставка счета: " + annualInterestRate;
    }
}
