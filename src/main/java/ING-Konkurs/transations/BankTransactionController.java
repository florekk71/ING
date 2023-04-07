package com.example.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class BankTransactionController {

    private final BankTransactionService bankTransactionService;

    @Autowired
    public BankTransactionController(BankTransactionService bankTransactionService) {
        this.bankTransactionService = bankTransactionService;
    }

    @PostMapping("/report")
    public ResponseEntity<List<Account>> report(@RequestBody List<BankTransaction.Transaction> transactions) {
        BankTransaction bankTransaction = new BankTransaction(transactions);
        List<Account> report = bankTransactionService.processTransactions(bankTransaction);
        return new ResponseEntity<>(report, HttpStatus.OK);
    }
}
