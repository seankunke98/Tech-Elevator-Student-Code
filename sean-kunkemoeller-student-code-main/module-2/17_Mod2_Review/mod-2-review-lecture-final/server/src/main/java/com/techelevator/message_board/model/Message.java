package com.techelevator.message_board.model;

import java.time.LocalDateTime;

public class Message {

    private int id;
    private MessageType messageType = new MessageType();
    private String senderName;
    private String receiverName;
    private String text;
    private boolean isPrivate = false;
    private LocalDateTime createTime;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getMessageTypeId(){
        return messageType.getMessageTypeId();
    }
    public String getMessageType() {
        return messageType.getMessageType();
    }

    public void setMessageType(int messageTypeId) {
        this.messageType.setMessageTypeId(messageTypeId);
    }

    public String getSenderName() {
        return senderName;
    }
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }
    public String getReceiverName() {
        return receiverName;
    }
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public boolean isPrivate() {
        return isPrivate;
    }
    public void setPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
