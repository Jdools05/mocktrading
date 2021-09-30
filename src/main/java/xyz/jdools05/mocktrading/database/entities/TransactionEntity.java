package xyz.jdools05.mocktrading.database.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import xyz.jdools05.mocktrading.enumerators.TransactionType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@SuppressWarnings("unused")
@Entity
@Table(name = "Transactions")
public class TransactionEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "transaction_id", nullable = false)
    public int id;

    @Column(name = "transaction_market_identifier_code")
    public String mic;

    @Column(name = "transaction_time")
    public LocalDateTime dateTime;

    @Column(name = "transaction_type")
    public TransactionType transactionType;

    @Column(name = "transaction_shares")
    public double shares;

    @Column(name = "transaction_value")
    public BigDecimal value;

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    public UserEntity user;
}
