package ru.sberstart.transfer.dao;

import ru.sberstart.transfer.model.Card;

import java.util.List;

public interface CardDao extends CrudDao<Card, Long> {
    public List<Card> getCards();
}
