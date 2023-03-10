package com.techelevator;

public class CreditCardAccount implements Accountable {
    private String accountNumber;
    private String accountHolder;
    private int debt;

    public CreditCardAccount(String accountHolder, String accountNumber){
            this.accountHolder = accountHolder;
            this.accountNumber = accountNumber;
            debt = 0;
}


    public int pay(int amountToPay){
        debt = debt - amountToPay;
        return debt;
    }
    public int charge(int amountToCharge){
        debt = debt + amountToCharge;
        return debt;
    }

    public int getDebt(){
        return debt;
    }

    public String getAccountHolder(){
        return accountHolder;
    }
    public String getAccountNumber(){
        return accountNumber;
    }

    @Override
    public int getBalance() {
        return -debt;
    }
}

