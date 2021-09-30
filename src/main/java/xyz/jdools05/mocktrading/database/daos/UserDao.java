package xyz.jdools05.mocktrading.database.daos;

import xyz.jdools05.mocktrading.database.entities.UserEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@SuppressWarnings("unused")
@ApplicationScoped
public class UserDao {

    @Transactional
    public List<UserEntity> listAll() {
        return UserEntity.listAll();
    }

    @Transactional
    public UserEntity get(int id) {
        return UserEntity.findById(id);
    }

    @Transactional
    public List<UserEntity> listByUsername(String username) {
        return UserEntity.list("username", username);
    }

    @Transactional
    public List<UserEntity> listByFirstName(String firstName) {
        return UserEntity.list("firstName", firstName);
    }

    //TODO fix findByNames because it will only work if you send id...
    @Transactional
    public List<UserEntity> listByLastName(String lastName) {
        return UserEntity.list("lastName", lastName);
    }

    @Transactional
    public UserEntity findByUsername(String username) {
        return UserEntity.find("username", username).firstResult();
    }

    @Transactional
    public UserEntity findByFirstName(String firstName) {
        return UserEntity.find("firstName", firstName).firstResult();
    }

    @Transactional
    public UserEntity findByLastName(String lastName) {
        return UserEntity.find("lastName", lastName).firstResult();
    }

    @Transactional
    public boolean exists(int id) {
        return UserEntity.count("id", id) == 1;
    }

    @Transactional
    public UserEntity update(int id, UserEntity updatedEntity) {
        UserEntity entity = UserEntity.findById(id);
        entity.username = updatedEntity.username;
        entity.firstName = updatedEntity.firstName;
        entity.lastName = updatedEntity.lastName;
        return entity;
    }

    @Transactional
    public UserEntity create(String username, String firstName, String lastName) {
        UserEntity entity = new UserEntity();
        entity.username = username;
        entity.firstName = firstName;
        entity.lastName = lastName;
        entity.persist();
        return entity;
    }

    @Transactional
    public UserEntity create(UserEntity entity) {
        if (exists(entity.id)) {
            return update(entity.id, entity);
        } else {
            entity.persist();
            return entity;
        }
    }

    @Transactional
    public void delete(int id) {
        UserEntity entity = UserEntity.findById(id);
        entity.delete();
    }
}
