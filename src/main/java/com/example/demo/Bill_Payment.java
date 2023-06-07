package com.example.demo;

public class Bill_Payment {
    String type;
    double amount;
    Account account;


    Bill_Payment(String type,double amount, Account account){
        this.type = type;
        this.amount=amount;
        this.account=account;
    }

    boolean payBill(){
        double available= this.account.getBalance();
        if(available>amount){
            return true;
        }
        else{
            return false;
        }

    }

    public String getType(){
        return type;
    }
    public double getAmount(){
        return amount;
    }




}