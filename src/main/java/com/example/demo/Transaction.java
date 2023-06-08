package com.example.demo;

import com.example.demo.Account;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
public class Transaction {

    private String sender;
    private String recipient;
    private String transactionID;
    private Date date;
    private double amount;
    private boolean isCancelled;
    private String transactionType;

    static ArrayList<Items> items = new ArrayList<>();

    static ArrayList<Transaction> transactionsList = new ArrayList<>();



    public static String getTransactionId(){
        String out="";
        for(int i=0;i<transactionsList.size();i++){
            out+=transactionsList.get(i).getTransactionDetails();
            out+="\n*-------------------------------------------------------------------------------------------------------------------------------*\n";
        }
        return out;
    }



    // Constructor
    public Transaction(String transactionID, Date date, double amount, String transactionType, String sender, String recipient) {
        this.transactionID = transactionID;
        this.date = date;
        this.amount = amount;
        this.isCancelled = false;
        this.transactionType = transactionType;
        this.sender= sender;
        this.recipient= recipient;
        transactionsList.add(this);

    }

    public Transaction() {

    }


    // Getters
    public String getTransactionID() {
        return transactionID;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    // Function to retrieve transaction details
    public String getTransactionDetails() {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTimestamp = currentTime.format(formatter);
        return "Transaction-ID: " + transactionID + ", Timestamp: " + formattedTimestamp + ", Amount: " + amount +
                ", Transaction: " + transactionType;

    }
//    public String getTransferDetails() {
//        LocalDateTime currentTime = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String formattedTimestamp = currentTime.format(formatter);
//
//        return "Sender: " + sender + "\nRecipient: " + recipient + "\nAmount: " + amount +
//                "\ncom.Banking.Transaction Type: " + transactionType + "\nTimestamp: " + formattedTimestamp;
//    }

    LocalDateTime currentTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formattedTimestamp = currentTime.format(formatter);
    public String deposit(double amount, Account account) {
        if (amount > 0) {
            double currentBalance = account.getBalance();
            double newBalance = currentBalance + amount;
            account.setBalance(newBalance);
            return("Transaction ID: " + transactionID + "\nTimestamp: " + formattedTimestamp + "\nAmount: " + amount +
                    "\nTransaction Type: deposit" );
        }
        else {
            return("invalid amount for Deposit");

        }
    }
    //TO DO : make functions return strings instead of printing
    public String withdraw(double amount, Account account) {
        double currentBalance = account.getBalance();
        if (amount <= 0) {
            return("invalid amount for Withdraw");
        }else if (amount <= currentBalance) {
            double newBalance = currentBalance - amount;
            account.setBalance(newBalance);
            return("Transaction ID: " + transactionID + "\nTimestamp: " + formattedTimestamp + "\nAmount: " + amount +
                    "\nTransaction Type: withdraw");
        }
        else
        {  return("insufficient balance");
        }
    }

    //Function to transfer money between accounts
    public String transfer(double amount, Account sender, Account recipient) {
        double SenderCurrentBalance = sender.getBalance();
        if (amount <=0){
            return("invalid amount for Transfer");
        }
        else if (amount <= SenderCurrentBalance) {
            double newBalance = SenderCurrentBalance - amount;
            sender.setBalance(newBalance);
            recipient.setBalance(recipient.getBalance() + amount);
            return("Transaction ID: " + transactionID + "\nTimestamp: " + formattedTimestamp + "\nAmount: " + amount +
                    "\nTransaction Type: transfer" + "\nSender: " + sender.getName() + "\nRecipient: " + recipient.getName());
        } else {
            return("insufficient balance for transfer");
        }
    }

    public static String getItemsName(){
        String out="";
        for(int i=0;i<items.size();i++){
            out+=items.get(i).getName();
            out+="\n";
        }
        return out;
    }


   public static String getItemsId(){
        String out="";
        for(int i=0;i<items.size();i++){
            out+=items.get(i).getId();
            out+="\n";
        }
        return out;
    }

    public static String getItemsPrice(){
        String out="";
        for(int i=0;i<items.size();i++){
            if(items.get(i).getCount()>0) {
                out += items.get(i).getPrice();
                out += "\n";
            }
            else{
                out+="Out Of Stock\n";
            }
        }
        return out;
    }

    int findItem(String id){
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public static double  returnItemPrice(String id){
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                return items.get(i).getPrice();
            }
        }
        return -1;
    }
    public String buyItem(String id, String sn) {
        int index = findItem(id);
        double itemPrice;
        if (index != -1) {
            itemPrice = items.get(index).getPrice();
        } else {
            System.out.println("item not found");
            return "item not found";
        }
        if (items.get(index).getCount() > 0) {
            Account account = Account.validation(sn,"test");
            if(account!=null) {
                if (account.getBalance() > itemPrice) {
                    account.setBalance(account.getBalance() - itemPrice);
                    System.out.println("item bought");
                    items.get(index).buy();
                    return "item bought";
                } else {
                    System.out.println("Item not bought, not enough balance");
                    return "Item not bought, not enough balance";
                }
            }
            else {
                return "Account doesn't exist";
            }
        } else {
            System.out.println("Item out of stock");
            return "Item out of stock";
        }

    }
}