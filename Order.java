import java.util.*;
import java.util.Vector;
public class Order {
    Vector<Product> orderItems;
    User C;
    User S;
    private int orderId;
    private double orderPrice;

    Order(){
        orderItems =new Vector<Product>();
        C= new User();
        S=new User();
    }
    public int getOrderId() {
        return orderId;
    }

    public void setCart(Vector<Product> orderItems) {
        this.orderItems = orderItems;
    }

    public void setCustomer(User c) {
        C = c;
    }

    public void setSeller(User s) {
        S = s;
    }

    public double calcPrice(){
        orderPrice=0;
        for (int i=0;i<orderItems.size();i++){
            orderPrice+=orderItems.elementAt(i).getProductCost();
        }
        return orderPrice;
    }
  

    public void printOrder(){
        S.printInfo();
        C.printInfo();
        System.out.println("        Order Details");
        System.out.println("********************************");
        System.out.println("Order ID: " + orderId);
        System.out.println("Number of products in the Order: " + orderItems.size());
        System.out.println("        Products");
        System.out.println("********************************");
        for(int i=0; i<orderItems.size();i++){
            System.out.println("* " + (i+1) +" *");
            orderItems.elementAt(i).printInfo();
        }
        System.out.println("Total order price: " + calcPrice());
    }

}
