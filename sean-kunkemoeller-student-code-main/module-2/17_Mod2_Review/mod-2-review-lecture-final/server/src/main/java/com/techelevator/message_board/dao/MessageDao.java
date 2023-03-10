package com.techelevator.message_board.dao;

import com.techelevator.message_board.model.Message;

import java.util.List;

public interface MessageDao {

    Message addNewMessage(Message message);
    List<Message> getPublicMessages();
    List<Message> getMessagesSentByUser(String userName);
    List<Message> getMessagesSentToUser(String userName);
    List<Message> getMessagesForUser(String userName);
}
