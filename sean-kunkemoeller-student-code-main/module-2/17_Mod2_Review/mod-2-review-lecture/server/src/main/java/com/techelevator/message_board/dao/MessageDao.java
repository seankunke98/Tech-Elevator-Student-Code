package com.techelevator.message_board.dao;

import com.techelevator.message_board.model.Message;

public interface MessageDao {

    boolean addNewMessage(Message message);

    Message getMessageById(int id);


}
