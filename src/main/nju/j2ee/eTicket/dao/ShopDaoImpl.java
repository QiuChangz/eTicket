package j2ee.eTicket.dao;

import j2ee.eTicket.entity.Shop;
import j2ee.eTicket.exception.ShopNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ShopDaoImpl extends BaseDaoImpl implements ShopDao {
    public void insert(Shop shop) {
        super.save(shop);
    }

    public void update(Shop shop) {
        super.update(shop);
    }

    public void delete(Shop shop) {
        super.delete(shop);
    }

    public List<Shop> find(String shopInfo) throws ShopNotFoundException {
        List<Shop> resultList = new ArrayList<Shop>();
        //基于播放内容的模糊查询
        List<Shop> shopContentList = (List<Shop>)super.load(Shop.class,"show_content", shopInfo);
        //基于商店名的模糊查询
        List<Shop> shopNameList = (List<Shop>)super.load(Shop.class, "name", shopInfo);
        //基于商店地址的模糊查询
        List<Shop> shopAddressList = (List<Shop>)super.load(Shop.class, "location", shopInfo);
        if( !isEmpty(shopNameList) || !isEmpty(shopAddressList) || !isEmpty(shopContentList)){
            resultList.addAll(shopNameList);
            resultList.addAll(shopAddressList);
            resultList.addAll(shopContentList);
            return resultList;
        }else {
            throw new ShopNotFoundException();
        }
    }

    public Shop find(int shopId) {
        return (Shop)super.load(Shop.class, String.valueOf(shopId));
    }

    public Shop getShop(int managerId) {
        ArrayList<Shop> shops = (ArrayList<Shop>)super.load(Shop.class, "manager_id", String.valueOf(managerId));
        return shops.get(0);
    }

    private boolean isEmpty(List<Shop> list){
        return null == list || list.isEmpty();
    }
}
