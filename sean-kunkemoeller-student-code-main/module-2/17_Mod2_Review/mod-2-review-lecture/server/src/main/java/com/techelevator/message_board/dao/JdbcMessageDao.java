package com.techelevator.message_board.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import com.techelevator.message_board.model.Message;


@Component
public class JdbcMessageDao implements MessageDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcMessageDao(JdbcTemplate jdbcTemplate){ this.jdbcTemplate = jdbcTemplate; }


    @Override
    public boolean addNewMessage(Message message) {
        String sql = "INSERT INTO message (message_id, message_type_id, sender_name, receiver_name, message_text) VALUES (?, ?, ?, ?, ?) RETURNING message_id";
        Integer newMessageId;
        try { newMessageId = jdbcTemplate.queryForObject(sql, Integer.class, message.getMessageTypeId(), message.getSenderName(), message.isPrivate(), message.getReceiverName(), message.getMessageText(), message.getCreateDate() ); }
        catch (DataAccessException e){
            return false;
        }

        return true;

    }

    @Override
    public Message getMessageById(int id) {
        Message message = new Message();
        String sql = "SELECT * FROM message WHERE message_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        if(result.next()){
            message = mapRowToMessage(result);
        }
        return message;
    }


    private Message mapRowToMessage(SqlRowSet result) {
        Message message = new Message();
        message.setMessageId(result.getInt("message_id"));
        message.setMessageTypeId((result.getInt("message_type_id")));
        message.setMessageText(result.getString("message_text"));
        message.setSenderName(result.getString("sender_name"));
        message.setReceiverName(result.getString("receiver_name"));
        return message;
    }
}
