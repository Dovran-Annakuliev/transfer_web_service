package ru.sberstart.transfer.dao;

import ru.sberstart.transfer.model.History;

import java.util.List;

public interface HistoryDao extends CrudDao<History, Long> {
    public List<History> getHistorys();
}
