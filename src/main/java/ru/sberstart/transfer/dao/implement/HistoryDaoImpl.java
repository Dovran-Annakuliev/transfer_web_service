package ru.sberstart.transfer.dao.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ru.sberstart.transfer.dao.HistoryDao;
import ru.sberstart.transfer.dao.mapper.HistoryMapper;
import ru.sberstart.transfer.model.History;

import java.util.Date;
import java.util.List;

@Service
public class HistoryDaoImpl implements HistoryDao {
    private String SQL_CREATE = "INSERT INTO historys (cardid, userid, senderid, recipientid, balance, date) VALUES (?, ?, ?, ?, ?, ?)";
    private String SQL_READ = "SELECT * FROM historys WHERE historyid = ?";
    private String SQL_UPDATE = "UPDATE historys SET cardid = ?, userid = ?, senderid = ?, recipientid = ?, balance = ?, date = ? WHERE historyid = ?";
    private String SQL_DELETE = "DELETE FROM historys WHERE historyid = ?";
    private String SQL_FIND_ALL = "SELECT * FROM historys";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HistoryDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(History history) {
        System.out.println(history.toString());
        jdbcTemplate.update(SQL_CREATE, history.getCardId(),
                                        history.getUserId(),
                                        history.getSenderId(),
                                        history.getRecipientId(),
                                        history.getBalance(),
                                        history.getDate());
    }

    @Override
    public History read(Long id) {
        return jdbcTemplate.query(SQL_READ, new Object[]{id}, new HistoryMapper())
                .stream().findAny().orElse(null);    }

    @Override
    public void update(Long id, History history) {
        jdbcTemplate.update(SQL_UPDATE, history.getCardId(),
                                        history.getUserId(),
                                        history.getSenderId(),
                                        history.getRecipientId(),
                                        history.getBalance(),
                                        new Date(),
                                        id);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(SQL_DELETE, id);
    }

    public List<History> getHistorys() {
        return jdbcTemplate.query(SQL_FIND_ALL, new HistoryMapper());
    }
}
