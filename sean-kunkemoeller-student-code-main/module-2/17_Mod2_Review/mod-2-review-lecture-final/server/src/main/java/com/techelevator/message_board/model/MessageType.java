package com.techelevator.message_board.model;

public class MessageType {
    private int messageTypeId;

    public String getMessageType(){
        if(messageTypeId == 1){
            return "Receive";
        } else if(messageTypeId == 2){
            return "Send";
        }
        return "message type not found.";
    }

    public int getMessageTypeId() {
        return messageTypeId;
    }

    public void setMessageTypeId(int messageTypeId) {
        this.messageTypeId = messageTypeId;
    }
}
