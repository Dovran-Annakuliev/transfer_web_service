package ru.sberstart.transfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sberstart.transfer.dao.implement.CardDaoImpl;
import ru.sberstart.transfer.model.Card;

import java.util.List;

@Service
public class CardsService {
    private final CardDaoImpl cardDaoImpl;

    @Autowired
    public CardsService(CardDaoImpl cardDaoImpl) {
        this.cardDaoImpl = cardDaoImpl;
    }

    public void createCard(Card card) {
        cardDaoImpl.create(card);
    }

    public Card getCard(Long id){
        return cardDaoImpl.read(id);
    }

    public void updateCard(Long id, Card card) {
        card.setBalance(card.getBalance() + cardDaoImpl.read(id).getBalance());
        cardDaoImpl.update(id, card);
    }

    public void deleteCard(Long id) {
        cardDaoImpl.delete(id);
    }

    public List<Card> getCards(){
        return cardDaoImpl.getCards();
    }
}
