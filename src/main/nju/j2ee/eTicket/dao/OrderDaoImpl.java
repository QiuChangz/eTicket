package j2ee.eTicket.dao;

import j2ee.eTicket.entity.Order;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDaoImpl extends BaseDaoImpl implements OrderDao {
    private static OrderDaoImpl ourInstance = new OrderDaoImpl();

    public static OrderDaoImpl getInstance() {
        return ourInstance;
    }

    private OrderDaoImpl() {
    }



    public void insert(Order order) {
        super.save(order);
    }

    public void update(Order order) {
        super.update(order);
    }

    public void delete(Order order) {
        super.delete(order);
    }

    public void delete(String[] ids) {
        super.delete(Order.class, ids);
    }

    public ArrayList<Order> getRoomOrderList(int shopId) {
        return (ArrayList<Order>)super.load(Order.class, "shop_id", String.valueOf(shopId));
    }

    @Override
    public Object load(Class c, String id) {
        try {
            Session session = super.getSession();
//            Transaction tx=session.beginTransaction();
            String fullClassName = c.getName();
            String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
            String hql = "from "+className+" where user = '" + id+"'";
            Query query=session.createQuery(hql);
            List result=query.getResultList();
//            tx.commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Order> find(int userId) {
        List<Order> orderList = (List<Order>)load(Order.class, String.valueOf(userId));
        return orderList;
    }

    public List<Order> find(int userId, String beginTime, String endTime) {
        String names[] = {"user_id", "create_time", "create_time"};
        String values[] = {String.valueOf(userId), beginTime, endTime};
        return (List<Order>)super.load(Order.class, names, values);
    }

    public List<Order> find(int shopId, int managerId) {
        return (List<Order>)super.load(Order.class,"shop_id",String.valueOf(shopId));
    }

    public List<Order> find(int shopId, int userId, int managerId) {
        String names[] = {"shop_id", "user_id"};
        String values[] = {String.valueOf(shopId), String.valueOf(userId)};
        return (List<Order>)super.load(Order.class, names, values);
    }

    public Order findOrder(int orderId) {
        return (Order)super.load(Order.class, String.valueOf(orderId));
    }
}
