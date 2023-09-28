package org.example;
public class Account {
    private String name;
    private double balance;
    public Account(){
        name = "no name";
        balance = 0.0;
    }
    public Account(String name, double balance){
        this.name = name;
        this.balance = balance;
    }
    public Account(Account other){
        name = other.name;
        balance = other.balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public Account deepCopy(){
        return new Account(name, balance);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        Account other = (Account)obj;
        return name.equals(other.name);
    }
}
