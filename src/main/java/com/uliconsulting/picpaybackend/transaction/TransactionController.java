package com.uliconsulting.picpaybackend.transaction;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;       
    }


    @PostMapping("/create")
    public Transaction createTransaction (@RequestBody Transaction transaction){
        return transactionService.create(transaction);
    }

    @GetMapping("/list")
    public List<Transaction> getTransaction (){
        return transactionService.getTransaction();
    }
}
