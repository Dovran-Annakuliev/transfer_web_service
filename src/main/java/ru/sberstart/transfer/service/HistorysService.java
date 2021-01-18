package ru.sberstart.transfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sberstart.transfer.dao.implement.CardDaoImpl;
import ru.sberstart.transfer.dao.implement.HistoryDaoImpl;
import ru.sberstart.transfer.model.Card;
import ru.sberstart.transfer.model.History;

import java.util.Date;
import java.util.List;

@Service
public class HistorysService {
    private final HistoryDaoImpl historyDaoImpl;
    private final CardDaoImpl cardDaoImpl;

    @Autowired
    public HistorysService(HistoryDaoImpl historyDaoImpl, CardDaoImpl cardDaoImpl) {
        this.historyDaoImpl = historyDaoImpl;
        this.cardDaoImpl = cardDaoImpl;
    }

    public void createHistory(History history) {
        Card senderCard = cardDaoImpl.read(history.getSenderId());
        Card recipientCard = cardDaoImpl.read(history.getRecipientId());

        history.setCardId(senderCard.getId());
        history.setUserId(senderCard.getUserIdl());

        cardDaoImpl.update(history.getSenderId(), new Card(senderCard.getBalance() - history.getBalance()));
        cardDaoImpl.update(history.getRecipientId(), new Card(recipientCard.getBalance() + history.getBalance()));

        history.setDate(new Date());

        historyDaoImpl.create(history);
    }

    public History getHistory(Long id){
        return historyDaoImpl.read(id);
    }

    public void updateHistory(Long id, History history) {
        historyDaoImpl.update(id, history);
    }

    public void deleteHistory(Long id) {
        historyDaoImpl.delete(id);
    }

    public List<History> getHistorys(){
        return historyDaoImpl.getHistorys();
    }
}
