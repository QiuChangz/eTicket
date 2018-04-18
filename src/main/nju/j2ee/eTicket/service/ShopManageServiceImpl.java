package j2ee.eTicket.service;

import j2ee.eTicket.dao.OrderDao;
import j2ee.eTicket.dao.ShopDao;
import j2ee.eTicket.entity.Order;
import j2ee.eTicket.entity.Shop;
import j2ee.eTicket.entity.User;
import j2ee.eTicket.exception.ShopNotFoundException;
import j2ee.eTicket.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.io.File;
import java.util.ArrayList;

@Service("ShopManageService")
public class ShopManageServiceImpl implements ShopManageService {

    @Autowired
    private ShopDao shopDao;
    @Autowired
    private OrderDao orderDao;

    @Transactional
    public Shop getShopInfo(int shopId) {
        return shopDao.find(shopId);
    }

    @Transactional
    public ArrayList<Shop> getShopInfo(String shopInfo) {
        ArrayList<Shop> shops;
        try {
            shops = (ArrayList<Shop>)shopDao.find(shopInfo);
        } catch (ShopNotFoundException e) {
            shops = null;
            e.printStackTrace();
        }
        return shops;
    }

    @Transactional
    public ArrayList<Order> getShopOrderInfo(int shopId, int managerId) {
        try {
            return (ArrayList<Order>)orderDao.find(shopId, managerId);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Transactional
    public ArrayList<Order> getShopOrderInfo(int shopId, int userId, int managerId) {
        try{
            return (ArrayList<Order>)orderDao.find(shopId, userId, managerId);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public Shop getShop(int managerId) {
        return shopDao.getShop(managerId);
    }

    @Transactional
    public ArrayList<Shop> getAllShop() {
        return (ArrayList<Shop>)shopDao.getAllList(Shop.class);
    }

    @Transactional
    public boolean signIn(String shopName, String phone, User manager, String location, String environment) {
        Shop shop = new Shop();
        shop.setName(shopName);
        shop.setPhone(phone);
        shop.setManagerId(manager.getId());
        shop.setLocation(location);
        shop.setEnvironment(environment);
        try {
            shopDao.insert(shop);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Transactional
    public boolean edit(int shopId, String shopName, String phone, User manager, String location, String environment, File profile, String showContent) {
        Shop shop = new Shop();
        shop.setId(shopId);
        shop.setName(shopName);
        shop.setPhone(phone);
        shop.setLocation(location);
        shop.setEnvironment(environment);
        shop.setProfile(FileUtil.saveImage(profile));
        shop.setShowContent(showContent);
        try {
            shopDao.update(shop);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
