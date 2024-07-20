package com.example.b2c_integration.dto;

public class B2CResponseDTO {

    private String conversationID;
    private String originatorConversationID;
    private String responseCode;
    private String responseDescription;
    public String getConversationID() {
        return conversationID;
    }
    public void setConversationID(String conversationID) {
        this.conversationID = conversationID;
    }
    public String getOriginatorConversationID() {
        return originatorConversationID;
    }
    public void setOriginatorConversationID(String originatorConversationID) {
        this.originatorConversationID = originatorConversationID;
    }
    public String getResponseCode() {
        return responseCode;
    }
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
    public String getResponseDescription() {
        return responseDescription;
    }
    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }

    
}
