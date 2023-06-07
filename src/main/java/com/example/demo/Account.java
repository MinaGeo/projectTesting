package com.example.demo;

import java.util.ArrayList;

public class Account
{
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private  String userId;
   private String Name;
    private String SecurityNumber;
    private double balance;
    private String accountType;

    static ArrayList<Bill_Payment> bills = new ArrayList<>();

    static ArrayList<Account> accountsList = new ArrayList<>();

    public Account(String Name)
    {
        this.Name = Name;
    }
    public Account(String Name, String SecurityNumber)
    {
        this.Name = Name;
        this.SecurityNumber = SecurityNumber;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account(String Name, String SecurityNumber, double amount, String userId, String accountType)
    {
        this(Name, SecurityNumber);
        this.balance = amount;
        this.userId = userId;
        this.accountType=accountType;
        System.out.println("Account successfully created");
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSecurityNumber() {
        return SecurityNumber;
    }

    public void setSecurityNumber(String securityNumber) {
        SecurityNumber = securityNumber;
    }

 public static Account validation(String securityNumber,String x)
 {

     for (Account account : accountsList) {
         if(x.equals("transfer")) {
             if (account.SecurityNumber.equals( securityNumber)) {
                 return account;
             }
         }
         else {

             if (account.SecurityNumber.equals(securityNumber) && account.getUserId().equals(GlobalData.getUserID())) {
                 return account;
             }
         }
     }

     return null;
 }


    public void addBill(String type,double amount){
        if(findBill(type)==-1) {
            bills.add(new Bill_Payment(type, amount, this));
        }
    }


    public String payBill(String type){
        int index=findBill(type);
        if(index!=-1){
            boolean status=bills.get(index).payBill();
            if(status) {
                balance -= bills.get(index).getAmount();
                bills.remove(index);
                return "Successful transaction";
            }
            else{
                return "Not Enough Balance";
            }
        }
        else{
            return "Bill not found";
        }

    }

    int findBill(String type){


            for (int i = 0; i < bills.size(); i++) {
                if (bills.get(i).getType().equals(type)) {
                    return i;
                }
            }
            return -1;

    }
    String getBillsId(){
        String out="";
        for(int i=0;i<bills.size();i++){
            out+=bills.get(i).getType();
            out+="\n";
        }
        return out;
    }

    String getBillsAmount(){
        String out="";
        for(int i=0;i<bills.size();i++){
            out+=Double.toString(bills.get(i).getAmount());
            out+="\n";
        }
        return out;
    }

}