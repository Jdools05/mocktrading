package xyz.jdools05.mocktrading.database.daos;

import xyz.jdools05.mocktrading.database.entities.TransactionEntity;
import xyz.jdools05.mocktrading.database.entities.UserEntity;
import xyz.jdools05.mocktrading.enumerators.TransactionType;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SuppressWarnings("unused")
@ApplicationScoped
public class TransactionDao {

    @Transactional
    public List<TransactionEntity> listAll() {
        return TransactionEntity.listAll();
    }

    @Transactional
    public TransactionEntity get(int id) {
        return TransactionEntity.findById(id);
    }

    @Transactional
    public List<TransactionEntity> listByUser(UserEntity user) {
        return TransactionEntity.list("user", user);
    }

    @Transactional
    public List<TransactionEntity> listByType(TransactionType type) {
        return TransactionEntity.list("transactionType", type);
    }

    @Transactional
    public TransactionEntity update(int id, String mic, LocalDateTime dateTime, TransactionType transactionType, double shares, BigDecimal value) {
        TransactionEntity entity = TransactionEntity.findById(id);
        entity.mic = mic;
        entity.dateTime = dateTime;
        entity.transactionType = transactionType;
        entity.shares = shares;
        entity.value = value;
        return entity;
    }
}
