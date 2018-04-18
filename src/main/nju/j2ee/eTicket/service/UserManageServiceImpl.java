package j2ee.eTicket.service;

import j2ee.eTicket.dao.OrderDao;
import j2ee.eTicket.dao.ShopDao;
import j2ee.eTicket.dao.UserDao;
import j2ee.eTicket.entity.Order;
import j2ee.eTicket.entity.Shop;
import j2ee.eTicket.entity.User;
import j2ee.eTicket.exception.UserNotFoundException;
import j2ee.eTicket.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
import java.sql.Date;

@Service("UserManageService")
public class UserManageServiceImpl implements UserManageService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ShopDao shopDao;

    @Transactional
    public User getUserInfo(String email, String password) {
        User user;
        try {
            user = userDao.find(email,password);
        }catch (UserNotFoundException e){
            user = null;
            e.printStackTrace();
        }
        return user;
    }

    @Transactional
    public User getUserInfo(int id) {
        return userDao.find(id);
    }

    //获得用户的订单列表
    @Transactional
    public ArrayList<Order> getOrderInfo(int userId) {
        return (ArrayList<Order>)orderDao.find(userId);
    }

    @Transactional
    public ArrayList<Order> getOrderInfo(int userId, String beginTime, String endTime) {
        return (ArrayList<Order>)orderDao.find(userId, beginTime, endTime);
    }

    public Shop getShop(int managerId) {
        return shopDao.getShop(managerId);
    }

    public ArrayList<User> getAllUser() {
        return (ArrayList<User>) userDao.getAllList(User.class);
    }

    public boolean signIn(User user) {
        try{
            userDao.insert(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Transactional
    public boolean signIn(String userName,String email, String birthday, String password, String identity) {
        User user = new User();
        user.setName(userName);
        user.setEmail(email);
        user.setPassword(password);
        user.setCreateTime(new Date(System.currentTimeMillis()));
        user.setUpdateTime(new Date(System.currentTimeMillis()));
        user.setBirthday(Date.valueOf(birthday));
        if(null == identity){
            identity = "普通用户";
        }else{
            identity = "商店经理";
        }
        user.setIdentity(identity);
        user.setId((int)Math.random()*100000);
        user.setProfile(FileUtil.getDefaultProfile());
        return signIn(user);
    }

    public boolean update(User user) {
        try{
            user.setUpdateTime(new Date(System.currentTimeMillis()));
            userDao.update(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Transactional
    public boolean edit(int userId, String userName, String email, String password, String birthday, String identity) {
        User user = new User();
        user.setId(userId);
        user.setName(userName);
        user.setEmail(email);
        user.setUpdateTime(new Date(System.currentTimeMillis()));
        user.setBirthday(Date.valueOf(birthday));
        user.setPassword(password);
        user.setIdentity(identity);
        try{
            userDao.update(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Transactional
    public boolean delete(int userId) {
        try{
            userDao.delete(User.class, String.valueOf(userId));
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Transactional
    public boolean delete(String[] userId) {
        try{
            userDao.delete(User.class, userId);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Transactional
    public boolean delete(int userId, int orderId) {
        try{
            Order order = orderDao.findOrder(orderId);
            if(userId == order.getUser().getId()){
                orderDao.delete(order);
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return false;
        }
    }
}
