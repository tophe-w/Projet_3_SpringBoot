package com.WildCodeSchool.Projet_3.dto;

public class ChatMessageDto {
    private String senderName;
    private String targetUserName;
    private String message;

    public ChatMessageDto() {}
    
    public String getSenderName() {
        return senderName;
    }
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }
    public String getTargetUserName() {
        return targetUserName;
    }
    public void setTargetUserName(String targetUserName) {
        this.targetUserName = targetUserName;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }



}