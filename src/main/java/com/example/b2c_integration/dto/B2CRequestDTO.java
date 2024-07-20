package com.example.b2c_integration.dto;

public class B2CRequestDTO {

    private String originatorConversationID;
    private String initiatorName;
    private String securityCredential;
    private String commandID;
    private String amount;
    private String partyA;
    private String partyB;
    private String remarks;
    private String queueTimeOutURL;
    private String resultURL;
    private String occasion;
    public String getOriginatorConversationID() {
        return originatorConversationID;
    }
    public void setOriginatorConversationID(String originatorConversationID) {
        this.originatorConversationID = originatorConversationID;
    }
    public String getInitiatorName() {
        return initiatorName;
    }
    public void setInitiatorName(String initiatorName) {
        this.initiatorName = initiatorName;
    }
    public String getSecurityCredential() {
        return securityCredential;
    }
    public void setSecurityCredential(String securityCredential) {
        this.securityCredential = securityCredential;
    }
    public String getCommandID() {
        return commandID;
    }
    public void setCommandID(String commandID) {
        this.commandID = commandID;
    }
    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }
    public String getPartyA() {
        return partyA;
    }
    public void setPartyA(String partyA) {
        this.partyA = partyA;
    }
    public String getPartyB() {
        return partyB;
    }
    public void setPartyB(String partyB) {
        this.partyB = partyB;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getQueueTimeOutURL() {
        return queueTimeOutURL;
    }
    public void setQueueTimeOutURL(String queueTimeOutURL) {
        this.queueTimeOutURL = queueTimeOutURL;
    }
    public String getResultURL() {
        return resultURL;
    }
    public void setResultURL(String resultURL) {
        this.resultURL = resultURL;
    }
    public String getOccasion() {
        return occasion;
    }
    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

}
