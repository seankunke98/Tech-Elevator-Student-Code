package com.techelevator;

public class BankAccount implements Accountable {

    private String accountHolderName;
    private String accountNumber;
    private int balance;

    public BankAccount(String accountHolder, String accountNumber) {
        this.accountHolderName = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public BankAccount(String accountHolder, String accountNumber, int balance) {
        this.accountHolderName = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amountToDeposit) {
        balance = balance + amountToDeposit;
    }

    public void withdraw(int amountToWithdraw) {
        balance = balance - amountToWithdraw;
    }
    public int transferTo(BankAccount destinationAccount, int transferAmount) {
        int newBalance = this.getBalance() - transferAmount;
        if (newBalance < 0) {
            return this.getBalance();
        } else {
            this.withdraw(transferAmount);
            destinationAccount.deposit(transferAmount); //this makes sure the money that was withdrawn gets deposited into destinationAccount
        }

        return this.balance;
    }
}
