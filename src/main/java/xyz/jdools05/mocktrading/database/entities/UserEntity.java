package xyz.jdools05.mocktrading.database.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class UserEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id", nullable = false)
    public int id;

    @Column(name = "username")
    public String username;

    @Column(name = "user_first_name")
    public String firstName;

    @Column(name = "user_last_name")
    public String lastName;
}
