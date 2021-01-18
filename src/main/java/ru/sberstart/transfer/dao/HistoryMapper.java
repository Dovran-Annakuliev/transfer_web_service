package ru.sberstart.transfer.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.sberstart.transfer.model.History;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HistoryMapper implements RowMapper<History> {
    @Override
    public History mapRow(ResultSet resultSet, int i) throws SQLException {
        History history = new History();

        history.setId(resultSet.getLong("historyid"));
        history.setCardId(resultSet.getLong("cardid"));
        history.setUserId(resultSet.getLong("userid"));
        history.setSenderId(resultSet.getLong("senderid"));
        history.setRecipientId(resultSet.getLong("recipientid"));
        history.setBalance(resultSet.getFloat("balance"));
        history.setDate(resultSet.getDate("date"));

        return history;
    }
}
