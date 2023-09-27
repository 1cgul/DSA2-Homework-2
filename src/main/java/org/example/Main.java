package org.example;

public class Main {
    public static void main(String[] args) {
        Account person = new Account("Chris", 100.5);
        System.out.println(person.equals(new Account("Chris", 200.0)));
    }
}