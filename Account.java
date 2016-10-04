// assignment 3 11.8

import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

class Transaction {
  private Date date;
  public Date getDate() { return date; }

  private char type;
  public char getType() { return type; }

  private double amount;
  public double getAmount() { return amount; }

  private double balance;
  public double getBalance() { return balance; }

  private String description;
  public String getDescription() { return description; }

  Transaction(char type, double amount, double balance, String description) {
    this.type = type;
    this.amount = amount;
    this.balance = balance;
    this.description = description;
    this.date = new Date();
  }
}

public class Account {
  private int id = 0;

  private String name;

  private double balance = 0.0;

  private double annualInterestRate = 0.0;

  private Date dateCreated;

  private ArrayList<Transaction> transactions;

  Account() {
    this(0, 0.0, 0.0);
  }

  Account(int id, double balance, double annualInterestRate) {
    this.id = id;
    this.balance = balance;
    this.annualInterestRate = annualInterestRate;
    dateCreated = new Date();
    transactions = new ArrayList<>();
  }

  Account(int id, String name, double balance, double annualInterestRate) {
    this(id, balance, annualInterestRate);
    this.name = name;
  }

  public int getId() { return id; }

  public void setId(int id) { this.id = id; }

  public double getBalance() { return balance; }

  public void setBalance(double balance) { this.balance = balance; }

  public double getAnnualInterestRate() { return annualInterestRate; }

  public void setAnnualInterestRate(double annualInterestRate) { this.annualInterestRate = annualInterestRate; }

  public Date getDateCreated() { return dateCreated; }

  public double getMonthlyInterestRate() {
    return annualInterestRate / 12;  // ???
  }

  public Account withdraw(double amount) {
    balance -= amount;
    Transaction t = new Transaction('W', amount, balance,
        name + " withdrew " + amount + " at " + new Date());  // oh, double new Date() ...
    transactions.add(t);
    return this;
  }

  public Account deposit(double amount) {
    balance += amount;
    Transaction t = new Transaction('W', amount, balance,
        name + " deposited " + amount + " at " + new Date());  // oh, double new Date() ...
    transactions.add(t);
    return this;
  }

  public ArrayList<Transaction> getTransactions() { return transactions; }

  public static void main(String[] args) {
    Account a = new Account(1122, "George", 1000, 1.5);
    a.deposit(30)
        .deposit(40)
        .deposit(50)
        .withdraw(5)
        .withdraw(4)
        .withdraw(2);
    for (Transaction t : a.getTransactions()) {
      System.out.println(t.getDescription());
    }
  }
}
