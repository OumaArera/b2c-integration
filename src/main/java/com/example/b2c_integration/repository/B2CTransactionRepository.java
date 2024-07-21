package com.example.b2c_integration.repository;

import com.example.b2c_integration.model.B2CTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface B2CTransactionRepository extends MongoRepository<B2CTransaction, String> {
    B2CTransaction findByTransactionId(String transactionId);
}
