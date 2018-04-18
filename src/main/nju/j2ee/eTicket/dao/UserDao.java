package j2ee.eTicket.dao;

import j2ee.eTicket.entity.User;
import j2ee.eTicket.exception.UserNotFoundException;

import java.util.List;

public interface UserDao extends BaseDao {

    public User find(int id);
    public void insert(User user);
    public void update(User user);
    public void delete(User user);
    public User find(String email, String password) throws UserNotFoundException;
    public List<User> findAll();
}
