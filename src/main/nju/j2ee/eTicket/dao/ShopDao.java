package j2ee.eTicket.dao;

import j2ee.eTicket.entity.Shop;
import j2ee.eTicket.exception.ShopNotFoundException;

import java.util.List;

public interface ShopDao extends BaseDao {

    public void insert(Shop shop);
    public void update(Shop shop);
    public void delete(Shop shop);
    public List<Shop> find(String shopInfo) throws ShopNotFoundException;
    public Shop find(int shopId);
    public Shop getShop(int managerId);
//    public List<Shop> find(String showContent);
}
