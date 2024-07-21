package com.example.b2c_integration.service;

import com.example.b2c_integration.dto.B2CRequestDTO;
import com.example.b2c_integration.dto.B2CResponseDTO;
import com.example.b2c_integration.model.B2CTransaction;
import com.example.b2c_integration.repository.B2CTransactionRepository;
import com.example.b2c_integration.util.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class B2CService {

    @Autowired
    private B2CTransactionRepository transactionRepository;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private DarajaService darajaService;

    public B2CResponseDTO processTransaction(B2CRequestDTO requestDTO) {
        // Encrypt sensitive data
        String encryptedCustomerId = EncryptionUtil.encrypt(requestDTO.getCustomerId());

        B2CTransaction transaction = new B2CTransaction();
        transaction.setTransactionId(requestDTO.getTransactionId());
        transaction.setAmount(requestDTO.getAmount());
        transaction.setCustomerId(encryptedCustomerId);
        transaction.setStatus("PENDING");

        // Save transaction to MongoDB
        transactionRepository.save(transaction);

        // Publish transaction to Kafka
        kafkaTemplate.send("b2c_transactions", transaction);

        // Initiate B2C payment via Daraja API
        String darajaResponse = darajaService.initiateB2CPayment(requestDTO);

        // Create response
        B2CResponseDTO responseDTO = new B2CResponseDTO();
        responseDTO.setTransactionId(transaction.getTransactionId());
        responseDTO.setStatus("PROCESSING");
        responseDTO.setMessage("Transaction is being processed by Daraja");

        return responseDTO;
    }
}
