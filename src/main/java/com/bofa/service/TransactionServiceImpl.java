package com.bofa.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.bofa.model.Transaction;

@Service  
public class TransactionServiceImpl implements TransactionService {

    private List<Transaction> transactions = new ArrayList<>();

    @Override
    public Transaction createTransaction(Transaction transaction) {
        transactions.add(transaction);
        return transaction;
    }

    @Override
    public Transaction getTransactionById(int id) {
        return transactions.stream()
                .filter(t -> t.getTransactionId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactions;
    }

    @Override
    public Transaction updateTransaction(int id, Transaction transaction) {
        for (Transaction t : transactions) {
            if (t.getTransactionId() == id) {
                t.setTransactionType(transaction.getTransactionType());
                t.setAmount(transaction.getAmount());
                t.setBranchCode(transaction.getBranchCode());
                t.setBalance(transaction.getBalance());
                return t;
            }
        }
        return null;
    }

    @Override
    public void deleteTransaction(int id) {
        transactions.removeIf(t -> t.getTransactionId() == id);
    }
}
