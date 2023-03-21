package com.cava.example.transactions.services;

import java.util.Optional;

import com.cava.example.transactions.entities.Transaction;

public interface TransactionService {

	Iterable<Transaction> listadoTrasactions();
	Optional<Transaction> findById(Long id);
	Transaction saveTransaction(Transaction transaction);
	void deleteTransaction(Long id );
}
