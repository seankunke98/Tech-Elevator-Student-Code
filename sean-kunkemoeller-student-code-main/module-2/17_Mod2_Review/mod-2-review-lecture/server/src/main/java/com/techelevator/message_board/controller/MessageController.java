package com.techelevator.message_board.controller;


import com.techelevator.message_board.dao.JdbcMessageDao;
import com.techelevator.message_board.dao.MessageDao;
import com.techelevator.message_board.model.Message;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class MessageController {

    private MessageDao messageDao;

    public MessageController(MessageDao messageDao) {
        this.messageDao = messageDao;
    }


    @RequestMapping(path = "/message", method = RequestMethod.POST)
    public boolean postMessage(@Valid @RequestBody Message message){
        boolean success = messageDao.addNewMessage(message);
        return success;
    }
}
