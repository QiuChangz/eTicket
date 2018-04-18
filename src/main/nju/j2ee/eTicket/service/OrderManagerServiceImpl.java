package j2ee.eTicket.service;

import j2ee.eTicket.dao.OrderDao;
import j2ee.eTicket.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class OrderManagerServiceImpl implements OrderManagerService {
    @Autowired
    private OrderDao orderDao;

    @Transactional
    public Order getOrderInfo(int orderId) {
        return (Order)orderDao.findOrder(orderId);
    }

    @Transactional
    public void update(Order order) {
        orderDao.update(order);
    }

    @Transactional
    public void delete(Order order) {
        orderDao.delete(order);
    }

    public void save(Order order) {
        orderDao.save(order);
    }

    public ArrayList<Order> getOrderList(int shopId) {
        return orderDao.getRoomOrderList(shopId);
    }
}
