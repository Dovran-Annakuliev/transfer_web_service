package ru.sberstart.transfer.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.sberstart.transfer.model.Card;
import ru.sberstart.transfer.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CardMapper implements RowMapper<Card> {
    @Override
    public Card mapRow(ResultSet resultSet, int i) throws SQLException {
        Card card = new Card();

        card.setId(resultSet.getLong("cardid"));
        card.setUserIdl(resultSet.getLong("userid"));
        card.setCardNumber(resultSet.getLong("cardnumber"));
        card.setBalance(resultSet.getFloat("balance"));

        return card;
    }
}
