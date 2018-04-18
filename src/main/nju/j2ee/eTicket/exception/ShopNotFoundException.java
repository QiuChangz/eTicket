package j2ee.eTicket.exception;

public class ShopNotFoundException extends Exception {

    public void printStackTrace(){
        System.out.println("SHOP_NOT_FOUND");
        super.printStackTrace();
    }
}
