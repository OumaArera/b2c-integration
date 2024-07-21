package com.example.b2c_integration.controller;

import com.example.b2c_integration.dto.B2CRequestDTO;
import com.example.b2c_integration.dto.B2CResponseDTO;
import com.example.b2c_integration.service.B2CService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/b2c")
public class B2CController {

    @Autowired
    private B2CService b2cService;

    @PostMapping("/transaction")
    public B2CResponseDTO processTransaction(@RequestBody B2CRequestDTO requestDTO) {
        return b2cService.processTransaction(requestDTO);
    }
}
