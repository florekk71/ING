package com.example.myapp;

import com.example.myapp.Account;
import com.example.myapp.BankTransaction;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class BankTransactionService {

    public List<Account> processTransactions(BankTransaction bankTransaction) {
        Map<String, Account> accounts = new HashMap<>();

        for (BankTransaction.Transaction transaction : bankTransaction.getTransactions()) {
            String debitAccountNumber = transaction.getDebitAccount();
            String creditAccountNumber = transaction.getCreditAccount();
            double amount = transaction.getAmount();

            Account debitAccount = accounts.getOrDefault(debitAccountNumber, new Account(debitAccountNumber, 0, 0, 0));
            debitAccount.setBalance(debitAccount.getBalance() - amount);
            debitAccount.setDebitCount(debitAccount.getDebitCount() + 1);
            accounts.put(debitAccountNumber, debitAccount);

            Account creditAccount = accounts.getOrDefault(creditAccountNumber, new Account(creditAccountNumber, 0, 0, 0));
            creditAccount.setBalance(creditAccount.getBalance() + amount);
            creditAccount.setCreditCount(creditAccount.getCreditCount() + 1);
            accounts.put(creditAccountNumber, creditAccount);
        }

        List<Account> report = new ArrayList<>(accounts.values());
        report.sort(Comparator.comparing(Account::getAccount));

        return report;
    }
}
