package crud.Dao;

import crud.Model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository

public class DaoImpl implements Dao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List <User> getUsers() { return entityManager.createQuery("From crud.Model.User", User.class).getResultList();}

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findUser(Long id) { return entityManager.find(User.class, id);}

    @Override
    public void editUser(User updatedUser) { entityManager.merge(updatedUser);
    }


}