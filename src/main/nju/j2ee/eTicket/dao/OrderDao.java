package j2ee.eTicket.dao;

import j2ee.eTicket.entity.Order;
import j2ee.eTicket.dao.BaseDao;

import java.util.ArrayList;
import java.util.List;

public interface OrderDao extends BaseDao {

    public void insert(Order order);
    public void update(Order order);
    public void delete(Order order);
    public void delete(String[] ids);

    //根据放映厅查找订单
    public ArrayList<Order> getRoomOrderList(int shopId);

    //用户查找自己的订单信息
    public List<Order> find(int userId);

    //用户根据时间查找自己的订单信息
    public List<Order> find(int userId, String beginTime, String endTime);

    //商店经理查看自己的商店的订单信息
    public List<Order> find(int shopId, int managerId);

    public List<Order> find(int shopId, int userId, int managerId);

    public Order findOrder(int orderId);
}
