package org.example;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args){
        final String file = "accounts.txt";
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        PQList accountHolder = new PQList();
        String name;

        try {
            while ((name = reader.readLine()) != null) { //reading accounts.txt and adding accounts to the pqlist
                double balance = Double.parseDouble(reader.readLine());
                Account newAccount = new Account(name, balance);
                accountHolder.add(newAccount);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < accountHolder.getLength(); i++){
            System.out.println(accountHolder.getMax());
        }
    }
}