package com.example.b2c_integration.service;

import com.example.b2c_integration.dto.B2CRequestDTO;
import com.example.b2c_integration.dto.B2CResponseDTO;

public interface B2CService {
    B2CResponseDTO processTransaction(B2CRequestDTO requestDTO);
}
