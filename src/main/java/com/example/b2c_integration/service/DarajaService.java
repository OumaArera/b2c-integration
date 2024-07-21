package com.example.b2c_integration.service;

import com.example.b2c_integration.config.DarajaConfig;
import com.example.b2c_integration.dto.B2CRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class DarajaService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DarajaConfig darajaConfig;

    private String getAccessToken() {
        String credentials = darajaConfig.getConsumerKey() + ":" + darajaConfig.getConsumerSecret();
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Basic " + encodedCredentials);

        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<Map> response = restTemplate.exchange(
                darajaConfig.getBaseUrl() + "/oauth/v1/generate?grant_type=client_credentials",
                HttpMethod.GET,
                request,
                Map.class
        );

        return (String) response.getBody().get("access_token");
    }

    public String initiateB2CPayment(B2CRequestDTO requestDTO) {
        String accessToken = getAccessToken();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = new HashMap<>();
        body.put("InitiatorName", System.getenv("DARAJA_INITIATOR_NAME"));
        body.put("SecurityCredential", System.getenv("DARAJA_SECURITY_CREDENTIAL"));
        body.put("CommandID", "BusinessPayment");
        body.put("Amount", requestDTO.getAmount());
        body.put("PartyA", System.getenv("DARAJA_SHORTCODE"));
        body.put("PartyB", requestDTO.getCustomerId());
        body.put("Remarks", "Payment");
        body.put("QueueTimeOutURL", System.getenv("DARAJA_QUEUE_TIMEOUT_URL"));
        body.put("ResultURL", System.getenv("DARAJA_RESULT_URL"));
        body.put("Occasion", requestDTO.getTransactionId());

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                darajaConfig.getBaseUrl() + "/mpesa/b2c/v1/paymentrequest",
                HttpMethod.POST,
                request,
                String.class
        );

        return response.getBody();
    }
}
