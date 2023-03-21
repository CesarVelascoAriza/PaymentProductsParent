package com.cava.example.transactions.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cava.example.transactions.entities.Transaction;

public interface TransacctionRepository extends JpaRepository<Transaction, Long> {

}
