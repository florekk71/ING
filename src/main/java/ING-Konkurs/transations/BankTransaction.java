package com.example.myapp;

import java.util.List;

public class BankTransaction {
    private List<Transaction> transactions;

    public BankTransaction() {
    }

    public BankTransaction(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public static class Transaction {
        private String debitAccount;
        private String creditAccount;
        private double amount;

        public Transaction() {
        }

        public Transaction(String debitAccount, String creditAccount, double amount) {
            this.debitAccount = debitAccount;
            this.creditAccount = creditAccount;
            this.amount = amount;
        }

        public String getDebitAccount() {
            return debitAccount;
        }

        public void setDebitAccount(String debitAccount) {
            this.debitAccount = debitAccount;
        }

        public String getCreditAccount() {
            return creditAccount;
        }

        public void setCreditAccount(String creditAccount) {
            this.creditAccount = creditAccount;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }
}
