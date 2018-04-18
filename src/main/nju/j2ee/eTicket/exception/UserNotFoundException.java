package j2ee.eTicket.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(){
        super();
    }

    public String getMessage(){
        return "Something wrong happens with username or password";
    }

    public void printStackTrace(){
        System.out.println("USER_NOT_FOUND");
        super.printStackTrace();
    }

}
