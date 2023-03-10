package com.techelevator.message_board.dao;

import com.techelevator.message_board.model.Message;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMessageDao implements MessageDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcMessageDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Message addNewMessage(Message message) {
        String sql = "INSERT INTO message(message_id, message_type_id, sender_name, receiver_name, message_text, private, create_date) VALUES (Default,?,?,?,?,?,?) RETURNING message_id;";
        Integer newId = jdbcTemplate.queryForObject(sql,
                Integer.class, message.getMessageTypeId(),message.getSenderName(), message.getReceiverName(), message.getText(), message.isPrivate(), message.getCreateTime());
        message.setId(newId);
        return message;
    }

    /*Added the ability to get all public messages*/
    @Override
    public List<Message> getPublicMessages() {
        List<Message> publicMessageList = new ArrayList<>();
        String sqlSelectPublicMessages = "SELECT message_id, message_type_id, sender_name, private, receiver_name, message_text, create_date FROM message WHERE private = false;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectPublicMessages);
        while(results.next()){
            publicMessageList.add(mapRowSetToMessages(results));
        }
        return publicMessageList;
    }

    /*Added the ability for a logged in user to view messages they have sent*/

    @Override
    public List<Message> getMessagesSentByUser(String userName) {
        List<Message> listOfMessagesSentByUser = new ArrayList<>();
        String sqlSelectMessagesSentByUser = "SELECT message_id, message_type_id, sender_name, private, receiver_name, message_text, create_date FROM message WHERE sender_name = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectMessagesSentByUser, userName);
        while(results.next()){
            listOfMessagesSentByUser.add(mapRowSetToMessages(results));
        }
        return listOfMessagesSentByUser;
    }
    /*Added the ability for a logged in user to view messages they have received*/
    @Override
    public List<Message> getMessagesSentToUser(String userName) {
        List<Message> listOfMessagesSentToUser = new ArrayList<>();
        String sqlSelectMessagesSentByUser = "SELECT message_id, message_type_id, sender_name, private, receiver_name, message_text, create_date FROM message WHERE receiver_name = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectMessagesSentByUser, userName);
        while(results.next()){
            listOfMessagesSentToUser.add(mapRowSetToMessages(results));
        }
        return listOfMessagesSentToUser;
    }

    /*Decided to create the ability to get all messages associated with a user to reduce the burden of multiple calls to the database*/
    @Override
    public List<Message> getMessagesForUser(String userName) {
        List<Message> listOfMessagesForUser = new ArrayList<>();
        String sqlSelectMessagesForUser = "SELECT message_id, message_type_id, sender_name, private, receiver_name, message_text, create_date FROM message WHERE receiver_name = ? OR sender_name = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectMessagesForUser, userName, userName);
        while(results.next()){
            listOfMessagesForUser.add(mapRowSetToMessages(results));
        }
        return listOfMessagesForUser;
    }

    private Message mapRowSetToMessages(SqlRowSet results) {
        Message message = new Message();
        message.setId(results.getInt("message_id"));
        message.setMessageType(results.getInt("message_type_id"));
        message.setSenderName(results.getString("sender_name"));
        message.setPrivate(results.getBoolean("private"));
        message.setReceiverName(results.getString("receiver_name"));
        message.setText(results.getString("message_text"));
        if( results.getDate("create_date") != null){
            message.setCreateTime((results.getTimestamp("create_date").toLocalDateTime()));
        }
        return message;


    }

}
