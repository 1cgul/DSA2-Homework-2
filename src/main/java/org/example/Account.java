package org.example;
public class Account {

    private String name;
    private double balance;

    /**
     * Sets account variables name and balance to filler values
     * name = "no name"
     * balance = 0.0
     */
    public Account(){
        name = "no name";
        balance = 0.0;
    }

    /**
     * Constructor with basic parameters
     *
     * @param name
     * @param balance
     */
    public Account(String name, double balance){
        this.name = name;
        this.balance = balance;
    }

    /**
     * Constructor takes in Account
     * @param other
     */
    public Account(Account other){
        name = other.name;
        balance = other.balance;
    }

    /**
     * getter for name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * setter for name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for balance
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * setter for balance
     * @param balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * creates a copy of the account
     * @return returns a new account
     */
    public Account deepCopy(){
        return new Account(name, balance);
    }

    /**
     * equals override
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        Account other = (Account)obj;
        return name.equals(other.name);
    }
    //toString Override
    @Override
    public String toString(){
        return "Name: " + name + "  Balance: " + balance;
    }
}
