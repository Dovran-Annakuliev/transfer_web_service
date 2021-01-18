package ru.sberstart.transfer.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.sberstart.transfer.dao.implement.CardDaoImpl;


@Transactional
class CardDaoImplTest extends Abstract{
    @Autowired
    private CardDaoImpl cardDaoImpl;

    @BeforeEach
    void setUp() {
    }

    @Test
    void create() {
    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getCards() {
    }
}