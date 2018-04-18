package j2ee.eTicket.controller;

import com.sun.org.apache.xpath.internal.operations.Or;
import j2ee.eTicket.entity.Order;
import j2ee.eTicket.entity.Room;
import j2ee.eTicket.entity.Shop;
import j2ee.eTicket.entity.User;
import j2ee.eTicket.service.OrderManagerService;
import j2ee.eTicket.service.RoomManagerService;
import j2ee.eTicket.service.ShopManageService;
import j2ee.eTicket.service.UserManageService;
import j2ee.eTicket.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "/")
public class MainController {

    private ModelAndView modelAndView = new ModelAndView();
    @Autowired
    private UserManageService userManageService;
    @Autowired
    private ShopManageService shopManageService;
    @Autowired
    private OrderManagerService orderManagerService;
    @Autowired
    private RoomManagerService roomManagerService;
    @Autowired
    private  ApplicationContext context;

    @RequestMapping(value = "cancel", method = RequestMethod.POST)
    public String cancel(ModelMap modelMap, HttpSession session, Order order){
        ArrayList<Order> orders = (ArrayList<Order>) session.getAttribute("order");
        orders.remove(order);
        orderManagerService.delete(order);
        User user = (User) session.getAttribute("user");
        int totalPrice = order.getPrice()*order.getNum()*order.getDiscount()/100;
        user.setMoney(user.getMoney() + order.getPrice()+ totalPrice/2);
        user.setCredit(user.getCredit() - totalPrice/2);
        userManageService.update(user);
        session.setAttribute("user", user);
        session.setAttribute("order", orders);
        return "profile";
    }

    @RequestMapping(value = "addMovie", method = RequestMethod.GET)
    public String addMovie(ModelMap modelMap, HttpSession session){
        Shop shop = (Shop) session.getAttribute("shop");
        ArrayList<Room> rooms = roomManagerService.getShopRooms(String.valueOf(shop.getId()));
        modelMap.addAttribute("rooms",rooms);
        return "place/addMovie";
    }

    @RequestMapping(value = "addMovie", method = RequestMethod.POST)
    public String addMovie(String showContent, Date showTime, int price, int roomId, ModelMap modelMap, HttpSession session){
        Room room = roomManagerService.getRoom(roomId);
        room.setShowContent(showContent);
        room.setShowTime(showTime);
        room.setPrice(price);
        roomManagerService.save(room);
        Shop shop = (Shop) session.getAttribute("shop");
        ArrayList<Room> rooms = roomManagerService.getShopRooms(String.valueOf(shop.getId()));
        modelMap.addAttribute("rooms",rooms);
        return "place/addMovie";
    }


    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(ModelMap modelMap, HttpSession session){
        session.removeAttribute("user");
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(ModelMap modelMap){
        return "login";
    }

    @RequestMapping(value = "recharge", method = RequestMethod.GET)
    public String recharge(ModelMap modelMap){
        return "recharge";
    }

    @RequestMapping(value = "recharge", method = RequestMethod.POST)
    public String recharge(ModelMap modelMap, int num, HttpSession session){
        User user = (User)session.getAttribute("user");
        user.setMoney(user.getMoney() + num);
        userManageService.update(user);
        session.setAttribute("user",user);
        return "profile";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(String email, String password, ModelMap modelMap, HttpSession session){
        User user = null;
        try {
            user = userManageService.getUserInfo(email,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        session.setAttribute("user",user);
        modelMap.addAttribute("user",user);
        if(user.getIdentity().equals("商店经理")){
            Shop shop = userManageService.getShop(user.getId());
            modelMap.addAttribute("shop",shop);
            session.setAttribute("shop", shop);
        }
        return "profile";
    }

    @RequestMapping(value = "signUp",method = RequestMethod.GET)
    public String signUp(ModelMap modelMap){
        return "signUp";
    }

    @RequestMapping(value = "signUp",method = RequestMethod.POST)
    public String signUp(@ModelAttribute("SpringWeb") User user, ModelMap modelMap, HttpSession session){
//        userManageService.signIn(userName, email, birthday, password, identity);
        userManageService.signIn(user);
//        User user = userManageService.getUserInfo(email,password);
        session.setAttribute("user",user);
        modelMap.addAttribute("user", user);
        return "profile";
    }

//    @RequestMapping(value = "editUserInfo/{id}",method = RequestMethod.GET)
//    public String edit(@PathVariable String id, ModelMap modelMap){
//        User user = userManageService.getUserInfo(Integer.parseInt(id));
//        modelMap.addAttribute("user", user);
//        return "edit";
//    }

    @RequestMapping(value = "editUserInfo",method = RequestMethod.GET)
    public String edit(ModelMap modelMap){
        return "edit";
    }

    @RequestMapping(value = "editUserInfo",method = RequestMethod.POST)
    public String edit(HttpSession session, String userName, String email, String birthday,int userId, ModelMap modelMap){
        User user = userManageService.getUserInfo(userId);
        user.setName(userName);
        user.setEmail(email);
        user.setProfile(FileUtil.getDefaultProfile());
//        user.setBirthday(birthday);
        userManageService.update(user);
        modelMap.addAttribute("user", userManageService.getUserInfo(user.getId()));
        if(user.getIdentity().equals("商店经理")){
            modelMap.addAttribute("shop",userManageService.getShop(user.getId()));
        }
        session.setAttribute("user", user);
        return "profile";
    }

    @RequestMapping(value = "editEvaluation",method = RequestMethod.POST)
    public String editEvaluation(String evaluation, int score, int orderId, ModelMap modelMap, HttpSession session){
        Order order = orderManagerService.getOrderInfo(orderId);
        order.setUpdateTime(new Date(System.currentTimeMillis()));
        order.setEvaluation(evaluation);
        order.setScore(score);
        orderManagerService.update(order);
        User user = (User)session.getAttribute("user");
        ArrayList<Order> orders = userManageService.getOrderInfo(user.getId());
        modelMap.addAttribute("order",orders);
        session.setAttribute("order", orders);
        return "showOrder";
    }

    @RequestMapping(value = "editEvaluation/{orderId}",method = RequestMethod.GET)
    public String editEvaluation(@PathVariable String orderId, ModelMap modelMap){
        Order order = orderManagerService.getOrderInfo(Integer.parseInt(orderId));
        modelMap.addAttribute("order",order);
        return "editEvaluation";
    }

    @RequestMapping(value = "profile", method = RequestMethod.GET)
    public String getProfile(ModelMap modelMap){
        return "profile";
    }

    @RequestMapping(value = "search",method = RequestMethod.POST)
    public String getSearchResult(String shopInfo, ModelMap modelMap){
        ArrayList<Shop> shops = shopManageService.getShopInfo(shopInfo);

        modelMap.addAttribute("shops", shops);
        return "result";
    }

    @RequestMapping(value = "showOrder", method = RequestMethod.GET)
    public String showUserOrder(ModelMap modelMap, HttpSession session){
        User user = (User)session.getAttribute("user");
        ArrayList<Order> orders = userManageService.getOrderInfo(user.getId());
//        modelMap.addAttribute("orders",orders);
        session.setAttribute("order", orders);
        return "showOrder";
    }

    @RequestMapping(value = "shopProfile", method = RequestMethod.GET)
    public String showShopProfile(ModelMap modelMap, HttpSession session){
        User manager = (User)session.getAttribute("user");
        Shop shop = shopManageService.getShop(manager.getId());
        session.setAttribute("shop",shop);
        modelMap.addAttribute("shop", shop);
        modelMap.addAttribute("user", manager);
        return "shopProfile";
    }

    @RequestMapping(value = "shopProfile", method = RequestMethod.POST)
    public String showShopProfile(String shopId,ModelMap modelMap){
        Shop shop = shopManageService.getShopInfo(Integer.parseInt(shopId));
        modelMap.addAttribute("shop", shop);
        return "shopProfile";
    }

    @RequestMapping(value = "update",method = RequestMethod.GET)
    public String update(ModelMap modelMap, HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user.getCredit() >= 500){
            user.setIdentity("普通会员");
        }
        session.setAttribute("user",user);
        userManageService.update(user);
        return "profile";
    }

    @RequestMapping(value = "showCinemaOrder",method = RequestMethod.GET)
    public String showCinemaOrder(ModelMap modelMap, HttpSession session){
        User user = (User)session.getAttribute("user");
        Shop shop = (Shop)session.getAttribute("shop");
        ArrayList<Order> orders = shopManageService.getShopOrderInfo(shop.getId(),user.getId());
        ArrayList<User> users = userManageService.getAllUser();
        for(int i = 0; i < orders.size() - 1; i++){
            User tempUser = orders.get(i).getUser();
            for(User user1 : users){
                if(user1.getId() == tempUser.getId()){
                    orders.get(i).setUser(user1);
                    break;
                }
            }
        }
        modelMap.addAttribute("orders",orders);
        return "showCinemaOrder";
    }

    @RequestMapping(value = "buy/{shopId}",method = RequestMethod.GET)
    public String buyTicket(@PathVariable String shopId, ModelMap modelMap){
        Shop shop = shopManageService.getShopInfo(Integer.parseInt(shopId));
        String contents[] = shop.getShowContent().split(";");
        ArrayList<Room> rooms = roomManagerService.getShopRooms(shopId);

        modelMap.addAttribute("rooms",rooms);
        return "buyTicket";
    }

    @RequestMapping(value = "book",method = RequestMethod.POST)
    public String book(String[] seats, int roomId, int shopId, ModelMap modelMap){
        Shop shop = shopManageService.getShopInfo(shopId);
        Room room = roomManagerService.getRoom(roomId);
        modelMap.addAttribute("shop",shop);
        modelMap.addAttribute("room",room);
        modelMap.addAttribute("seats", seats);
        return "book";
    }

    @RequestMapping(value = "payOrder",method = RequestMethod.POST)
    public String payOrder(int orderId, HttpSession session, ModelMap modelMap){
        Order orderInfo = orderManagerService.getOrderInfo(orderId);
        User user = (User) session.getAttribute("user");
        int totalPrice = orderInfo.getPrice()*orderInfo.getNum()*orderInfo.getDiscount()/100;
        ArrayList<Order> orders = (ArrayList<Order>) session.getAttribute("order");
        for(Order order: orders){
            if(order.getId().equals(orderInfo.getId())){
                orders.remove(order);
                break;
            }
        }
        if( totalPrice <= user.getMoney()){
            user.setMoney(user.getMoney() - totalPrice);
            orderInfo.setState("已支付");
            orderManagerService.update(orderInfo);
            orders.add(orderInfo);
        }
        session.setAttribute("order", orders);
//        modelMap.addAttribute("order",(Order)session.getAttribute("order"));
        return "showOrder";
    }

    @RequestMapping(value = "pay",method = RequestMethod.POST)
    public String pay(int userId,int shopId, int roomId, String seats, ModelMap modelMap){
        seats = seats.substring(0,seats.length()-1);
        String[] seat = seats.split(";");
        User user = userManageService.getUserInfo(userId);
        Shop shop = shopManageService.getShopInfo(shopId);
        Room room = roomManagerService.getRoom(roomId);
        Order order = new Order();
        order.setSeats(seats);
        order.setShopLocation(shop.getLocation());
        order.setId(String.valueOf(Math.random()*10000));
        order.setPrice(room.getPrice());
        order.setNum(seat.length);
        order.setState("支付中");
        order.setUser(user);
        order.setShop(shop);
        order.setShowTime(room.getShowTime());
        order.setCreateTime(new Date(System.currentTimeMillis()));
        order.setUpdateTime(new Date(System.currentTimeMillis()));
        order.setShowContent(room.getShowContent());
        if(user.getIdentity().equals("普通会员") &&user.getCredit()>=500&&user.getCredit()<=1000){
            order.setDiscount(95);
        }else if(user.getIdentity().equals("普通会员") &&user.getCredit()>1000&&user.getCredit()<=2000) {
            order.setDiscount(85);
        }else if(user.getIdentity().equals("普通会员") &&user.getCredit()>2000){
                order.setDiscount(85);
        }else{
            order.setDiscount(100);
        }
        order.setEvaluation("5");
        order.setEvaluation("");
        orderManagerService.save(order);
        int total = order.getPrice()*order.getNum()*order.getDiscount()/100;
        if(user.getMoney() >= total){
            user.setMoney(user.getMoney() - total);
            order.setState("已支付");
            user.setCredit(user.getCredit() + order.getPrice());
        }else{
            return "pay";
        }
        modelMap.addAttribute("user",user);
        return "profile";
    }

    @RequestMapping(value = "select" ,method = RequestMethod.POST)
    public String select( int roomId, ModelMap modelMap){
        Room room = roomManagerService.getRoom(roomId);
        modelMap.addAttribute("room",room);
        return "select";
    }

    @RequestMapping(value = "place/signUp" ,method = RequestMethod.GET)
    public String placeSignUp( ModelMap modelMap){
        return "place/signUp";
    }

    @RequestMapping(value = "place/signUp" ,method = RequestMethod.POST)
    public String placeSignUp( ModelMap modelMap, HttpSession session, String name, String seats){
        Room room = new Room();
        room.setName(name);
        room.setSeat(seats);
        Shop shop = (Shop) session.getAttribute("shop");
        room.setShop(shop);
        room.setShowContent("");
        roomManagerService.save(room);
        session.setAttribute("room", room);
        return "place/profile";
    }

    @RequestMapping(value = "checkSelect" ,method = RequestMethod.GET)
    public String check( ModelMap modelMap, HttpSession session){
        Shop shop = (Shop) session.getAttribute("shop");
        ArrayList<Order> orders = orderManagerService.getOrderList(shop.getId());
        ArrayList<Order> orderResult = new ArrayList<Order>();
        for(Order order: orders){
            if(!order.getState().equals("已完成")){
                orderResult.add(order);
            }
        }
        modelMap.addAttribute("orders", orderResult);
        session.setAttribute("orders", orderResult);
        return "place/check";
    }

    @RequestMapping(value = "check" ,method = RequestMethod.POST)
    public String check( ModelMap modelMap, HttpSession session, int orderId){
        Shop shop = (Shop) session.getAttribute("shop");
//        Order order = orderManagerService.getOrderInfo(orderId);
        ArrayList<Order> orders = (ArrayList<Order>) session.getAttribute("orders");
        ArrayList<Order> orderResult = new ArrayList<Order>();
        for(Order order: orders){
            if(order.getState().equals("已支付")){
                order.setState("已完成");
                orderManagerService.update(order);
            }else{
                orderResult.add(order);
            }
        }
        session.setAttribute("orders", orderResult);
        modelMap.addAttribute("orders", orderResult);
        return "place/check";
    }

}
