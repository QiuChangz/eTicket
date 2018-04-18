package j2ee.eTicket.service;

import j2ee.eTicket.entity.Order;

import java.util.ArrayList;

public interface OrderManagerService {
    public Order getOrderInfo(int orderId);
    public void update(Order order);
    public void delete(Order order);
    public void save(Order order);
    public ArrayList<Order> getOrderList(int shopId);
}
