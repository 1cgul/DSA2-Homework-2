package org.example;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;


public class Main {
    public static void main(String[] args){
        final String file = "accounts.txt";
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        PQList accountHolder = new PQList();
        String name;

        try {
            //reading accounts.txt and adding accounts to the pqlist
            while ((name = reader.readLine()) != null) {
                double balance = Double.parseDouble(reader.readLine());
                Account newAccount = new Account(name, balance);
                accountHolder.add(newAccount);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        PQList copy = new PQList(accountHolder);
        PQList deepCopyTest = new PQList();
        deepCopyTest = accountHolder.deepCopy();

        //Checking empty list
        System.out.println("Original list is empty? " + accountHolder.isEmpty());
        System.out.println("Cloned list is empty? " + copy.isEmpty());
        //Checking length of list
        System.out.println("Length of original list " + accountHolder.getLength());
        System.out.println("Length of cloned list " + copy.getLength());

        //Outputs and removes the accounts in balance order

        while(!accountHolder.isEmpty()){
            System.out.println(accountHolder.getMax());
        }

        System.out.println("==================================================================================");

        //Copy constructor test
        while(!copy.isEmpty()){
            System.out.println(copy.getMax());
        }

        //Checking empty list
        System.out.println("Original list is empty? " + accountHolder.isEmpty());
        System.out.println("Cloned list is empty? " + copy.isEmpty());
        //Checking length of list
        System.out.println("Length of original list " + accountHolder.getLength());
        System.out.println("Length of cloned list " + copy.getLength());

        //Deep copy constructor test
        copy.add(new Account("Chris", 99999.85));
        System.out.println("Length of copied list " + copy.getLength());
        System.out.println("Is the list empty? " + copy.isEmpty());
        copy.clear();
        System.out.println("Now is the list empty? " + copy.isEmpty());


        System.out.println("==================================================================================");
        //Deep copy method t est
        System.out.println("deepCopyTest length is " + deepCopyTest.getLength());
        System.out.println("deepCopyTest is empty? " + deepCopyTest.isEmpty());
        while(!deepCopyTest.isEmpty()){
            System.out.println(deepCopyTest.getMax());
        }
        System.out.println("deepCopyTest length is " + deepCopyTest.getLength());
        System.out.println("deepCopyTest is empty? " + deepCopyTest.isEmpty());

    }
}