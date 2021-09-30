package xyz.jdools05.mocktrading.apis;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import xyz.jdools05.mocktrading.database.daos.UserDao;
import xyz.jdools05.mocktrading.database.entities.UserEntity;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Tag(name = "Users", description = "Endpionts available for managing users in the database")
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserDao userDao;

    @GET
    public List<UserEntity> get() {
        return userDao.listAll();
    }

    @GET
    @Path("/{user_id}")
    public UserEntity get(@PathParam("user_id") int userId) {
        return userDao.get(userId);
    }

    @GET
    @Path("/{username}")
    public UserEntity findByUsername(@PathParam("username") String username) {
        return userDao.findByUsername(username);
    }

    @GET
    @Path("/{first_name}")
    public UserEntity findByFirstName(@PathParam("first_name") String firstName) {
        return userDao.findByFirstName(firstName);
    }

    @GET
    @Path("/{last_name}")
    public UserEntity findByLastName(@PathParam("last_name") String lastName) {
        return userDao.findByLastName(lastName);
    }

    @POST
    public UserEntity create(UserEntity entity) {
        return userDao.create(entity);
    }

    @PUT
    @Path("/{user_id}")
    public UserEntity update(@PathParam("user_id") int id, UserEntity entity) {
        return userDao.update(id, entity);
    }

    @DELETE
    @Path("{user_id}")
    public void delete(@PathParam("user_id") int id) {
        userDao.delete(id);
    }
}
