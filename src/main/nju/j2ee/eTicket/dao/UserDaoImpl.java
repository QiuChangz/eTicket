package j2ee.eTicket.dao;

import j2ee.eTicket.entity.User;
import j2ee.eTicket.exception.UserNotFoundException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    public User find(int id) {
        return (User)super.load(User.class, String .valueOf(id));
    }

    public void insert(User user) {
        super.save(user);
    }

    public void update(User user) {
        super.update(user);
    }

    public void delete(User user) {
        super.delete(user);
    }

    public User find(String email, String password) throws UserNotFoundException{
        String[] names = {"email", "password"};
        String[] values = {email, password};
        List<User> userList = (List<User>)super.load(User.class, names, values);
        if(null != userList && userList.size() > 0){
            //email在数据库中不能重复，userList有且只能有一个user
            return userList.get(0);
        }else {
            //若userList为空，那么密码或邮箱出错
            throw new UserNotFoundException();
        }
    }

    public List<User> findAll() {
        return (List<User>)super.getAllList(User.class);
    }
}
