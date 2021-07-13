import java.util.Vector;

public class printReceipt {

    public printReceipt(User c, User s, int orderId, Vector<Product> orderItems) {
        s.printInfo();
        c.printInfo();
        System.out.println("        Order Details");
        System.out.println("********************************");
        System.out.println("Order ID: " + orderId);
        System.out.println("Number of products in the Order: " + orderItems.size());
        System.out.println("        Products");
        System.out.println("********************************");
        for (int i = 0; i < orderItems.size(); i++) {
            System.out.println("* " + (i + 1) + " *");
            orderItems.elementAt(i).printInfo();
        }
        System.out.println("Total order price: " + calcPrice(orderItems));
    }

    public double calcPrice(Vector<Product> orderItems) {
        double orderPrice = 0;
        for (int i = 0; i < orderItems.size(); i++) {
            orderPrice += orderItems.elementAt(i).getProductCost();
        }
        return orderPrice;
    }

}
