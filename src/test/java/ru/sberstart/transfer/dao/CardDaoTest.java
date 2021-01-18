package ru.sberstart.transfer.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Transactional
class CardDaoTest extends AbstractTransactionalJUnit4SpringContextTests{
    @Autowired
    private CardDao cardDao;

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