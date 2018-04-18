package j2ee.eTicket.service;

import j2ee.eTicket.entity.Order;
import j2ee.eTicket.entity.Shop;
import j2ee.eTicket.entity.User;

import java.io.File;
import java.util.ArrayList;
import java.sql.Date;

public interface UserManageService {

    public User getUserInfo(String email, String password);
    public User getUserInfo(int id);
    public ArrayList<Order> getOrderInfo(int userId);
    public ArrayList<Order> getOrderInfo(int userId, String beginTime, String endTime);

    public Shop getShop(int managerId);

    public ArrayList<User> getAllUser();

    public boolean signIn(User user);
    //用户注册
    public boolean signIn(String userName, String email, String birthday, String password, String identity);

    public boolean update(User user);
    //用户修改资料
    public boolean edit(int userId, String userName, String email, String password,String birthday, String identity);

    //用户注销
    public boolean delete(int userId);

    //批量注销用户
    public boolean delete(String[] userId);

    //用户删除订单信息
    public boolean delete(int userId, int orderId);

}
