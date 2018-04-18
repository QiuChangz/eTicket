package j2ee.eTicket.service;

import j2ee.eTicket.entity.Order;
import j2ee.eTicket.entity.Shop;
import j2ee.eTicket.entity.User;

import java.io.File;
import java.util.ArrayList;

public interface ShopManageService {

    //管理员通过商店ID查找商店
    public Shop getShopInfo(int shopId);

    //用户通过商店信息（商店名或商店播放内容等）查找商店信息
    public ArrayList<Shop> getShopInfo(String shopInfo);

    //商店经理通过商店和自身ID搜索商店的订单
    public ArrayList<Order> getShopOrderInfo(int shopId, int managerId);

    //商店经理查找在该商店下过单的用户订单
    public ArrayList<Order> getShopOrderInfo(int shopId, int userId, int managerId);

    public Shop getShop(int managerId);

    //管理员查看所有商店信息
    public ArrayList<Shop> getAllShop();

    //新商店加入注册
    public boolean signIn(String shopName, String phone, User manager, String location, String environment);

    //商店修改资料
    public boolean edit(int shopId, String shopName, String phone, User manager, String location, String environment, File profile, String showContent);
}
