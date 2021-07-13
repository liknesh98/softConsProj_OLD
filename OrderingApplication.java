public class OrderingApplication {
    public static void main(String[] args) {
        Product a = new Product(1, "shampoo", 30.25);
        Product b = new Product(2, "soap", 4.75);
        User seller1 = new User(1, "me");
        seller1.addSellerProduct(a);
        seller1.addSellerProduct(b);
        seller1.updateQuantity(a, 10);
        seller1.updateQuantity(b, 5);
        Address ad1 = new Address("No 2 Jalan Mawar", "Skudai", "Johor Bahru");
        User Cust1 = new User(1, "yasser", 90.0);
        Cust1.setAddress(ad1);
        Cust1.addCustProduct(a);
        Cust1.addCustProduct(a);
        Cust1.addCustProduct(b);
        Order o = new Order();
        o.setCustomer(Cust1);
        o.setSeller(seller1);
        o.setCart(Cust1.getCart());
        o.printOrder();

    }
}
