package com.techelevator.message_board.controller;

import com.techelevator.message_board.dao.MessageDao;
import com.techelevator.message_board.model.Message;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
public class MessageController {

    private MessageDao messageDao;

    public MessageController(MessageDao messageDao){
        this.messageDao = messageDao;
    }

    @RequestMapping(path = "/messages", method = RequestMethod.POST)
    public void createNewMessage(@RequestBody Message message){
        message.setCreateTime(LocalDateTime.now());
        messageDao.addNewMessage(message);
    }

    /*Added a method to display all public messages and overrode the auth requirement*/
    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Message> listAllPublicMessages(){
        return messageDao.getPublicMessages();
    }


    /*Added a method to display all messages for a logged in user*/
    @RequestMapping(path = "/messages", method = RequestMethod.GET)
    public List<Message> listAllMessagesForUser(@RequestParam(defaultValue = "false") Boolean sender, @RequestParam(defaultValue = "false") Boolean receiver, Principal principal){
        List<Message> messages = new ArrayList<>();
        if(sender == false && receiver == false){
            //since messages are tied to sender and receiver, by not including either, you want where the user is either a sender or receiver
           return messages = messageDao.getMessagesForUser(principal.getName());
        }else if(sender){
            return messages = messageDao.getMessagesSentByUser(principal.getName());
        } else if(receiver){
            return messages = messageDao.getMessagesSentToUser(principal.getName());
        } else {
           return messages;
        }

    }
}
