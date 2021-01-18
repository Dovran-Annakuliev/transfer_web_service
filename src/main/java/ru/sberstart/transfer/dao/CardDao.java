package ru.sberstart.transfer.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ru.sberstart.transfer.model.Card;

import java.util.List;

@Service
public class CardDao implements CrudDao<Card, Long>{
    private String SQL_CREATE = "INSERT INTO cards (userid, balance) VALUES (?, ?)";
    private String SQL_READ = "SELECT * FROM cards WHERE cardid = ?";
    private String SQL_UPDATE = "UPDATE cards SET balance = ? WHERE cardid = ?";
    private String SQL_DELETE = "DELETE FROM cards WHERE cardid = ?";
    private String SQL_FIND_ALL = "SELECT * FROM cards";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CardDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Card card) {
        jdbcTemplate.update(SQL_CREATE, card.getUserIdl(), card.getBalance());
    }

    @Override
    public Card read(Long id) {
        return jdbcTemplate.query(SQL_READ, new Object[]{id}, new CardMapper())
                .stream().findAny().orElse(null);
    }

    @Override
    public void update(Long id, Card card) {
        jdbcTemplate.update(SQL_UPDATE, card.getBalance(), id);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(SQL_DELETE, id);
    }

    public List<Card> getCards() {
        return jdbcTemplate.query(SQL_FIND_ALL, new CardMapper());
    }
}
