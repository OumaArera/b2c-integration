package com.example.b2c_integration.controller;


import com.example.b2c_integration.dto.B2CRequestDTO;
import com.example.b2c_integration.dto.B2CResponseDTO;
import com.example.b2c_integration.service.B2CService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/b2c")
public class B2CController {

    private final B2CService b2CService;

    public B2CController(B2CService b2CService) {
        this.b2CService = b2CService;
    }

    @PostMapping("/transaction")
    public ResponseEntity<B2CResponseDTO> createTransaction(@RequestBody B2CRequestDTO requestDTO) {
        B2CResponseDTO responseDTO = b2CService.processTransaction(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }
}
