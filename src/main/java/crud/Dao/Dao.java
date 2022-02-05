package crud.Dao;

import crud.Model.User;

import java.util.List;

public interface Dao {
    List<User> getUsers();

    void addUser(User user);

    User findUser(Long id);

    void deleteUser(Long id);

    void editUser(User user);


}