package ru.sberstart.transfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sberstart.transfer.dao.CardDao;
import ru.sberstart.transfer.dao.HistoryDao;
import ru.sberstart.transfer.model.Card;
import ru.sberstart.transfer.model.History;

import java.util.Date;
import java.util.List;

@Service
public class HistorysService {
    private final HistoryDao historyDao;
    private final CardDao cardDao;

    @Autowired
    public HistorysService(HistoryDao historyDao, CardDao cardDao) {
        this.historyDao = historyDao;
        this.cardDao = cardDao;
    }

    public void createHistory(History history) {
        Card senderCard = cardDao.read(history.getSenderId());
        Card recipientCard = cardDao.read(history.getRecipientId());

        history.setCardId(senderCard.getId());
        history.setUserId(senderCard.getUserIdl());

        cardDao.update(history.getSenderId(), new Card(senderCard.getBalance() - history.getBalance()));
        cardDao.update(history.getRecipientId(), new Card(recipientCard.getBalance() + history.getBalance()));

        history.setDate(new Date());

        historyDao.create(history);
    }

    public History getHistory(Long id){
        return historyDao.read(id);
    }

    public void updateHistory(Long id, History history) {
        historyDao.update(id, history);
    }

    public void deleteHistory(Long id) {
        historyDao.delete(id);
    }

    public List<History> getHistorys(){
        return historyDao.getHistorys();
    }
}
