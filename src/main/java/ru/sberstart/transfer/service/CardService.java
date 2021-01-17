package ru.sberstart.transfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sberstart.transfer.dao.CardDao;
import ru.sberstart.transfer.model.Card;

import java.util.List;

@Service
public class CardService {
    private final CardDao cardDao;

    @Autowired
    public CardService(CardDao cardDao) {
        this.cardDao = cardDao;
    }

    public void createUCard(Card card) {
        cardDao.create(card);
    }

    public Card getCard(Long id){
        return cardDao.read(id);
    }

    public void updateCard(Long id, Card card) {
        card.setBalance(card.getBalance() + cardDao.read(id).getBalance());
        cardDao.update(id, card);
    }

    public void deleteCard(Long id) {
        cardDao.delete(id);
    }

    public List<Card> getCards(){
        return cardDao.getCards();
    }
}
