package com.bofa.service;

import com.bofa.model.Transaction;
import java.util.List;

public interface TransactionService {
    Transaction createTransaction(Transaction transaction);
    Transaction getTransactionById(int id);
    List<Transaction> getAllTransactions();
    Transaction updateTransaction(int id, Transaction transaction);
    void deleteTransaction(int id);
}
