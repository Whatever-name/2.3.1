package crud.Service;

import crud.Dao.DaoImpl;
import crud.Model.User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private DaoImpl userDao;

    @Autowired
    public UserService(DaoImpl userDao){
        this.userDao = userDao;
    }

    @Transactional
    public List<User> getUsers() {return userDao.getUsers(); }

    @Transactional
    public void addUser(User user){userDao.addUser(user);}

    @Transactional
    public User findUser(Long id){return userDao.findUser(id);}

    @Transactional
    public void editUser(User updatedUser){userDao.editUser(updatedUser);}

    @Transactional
    public void deleteUser(Long id){userDao.deleteUser(id);}

}