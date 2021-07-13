import java.util.Vector;
public class User {
    protected int userId;
    protected String name;
    private double accountBalance;
    protected String accountType;
    private Address address;
    private Vector<Product> cart;
    private int productsNum; //number of products seller added
    private Vector<Product> myProducts;

    public User(){
        accountType=null;
    }

    //Constructor for customer
    public User(int userId, String name, double accountBalance){
        this.accountBalance=accountBalance;
        this.accountType="Customer";
        address=new Address();
        cart= new Vector<Product>();
    }

    public User(int userId,String name) {
        this.accountType="Seller";
        myProducts = new Vector<Product>();
        productsNum=myProducts.size();
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void addCustProduct(Product p) {
        if((accountBalance>=p.getProductCost()) && (p.getQuantity()>0)){
            cart.add(p);
            accountBalance-=p.getProductCost();
            p.setQuantity(p.getQuantity()-1);
        }
        else{
            System.out.println("Unable to add product: "+p.getProductName()+" due to " +
                                "insufficient account balance or sold out");
        }
    }

    public void addSellerProduct(Product p) {
        myProducts.add(p);
    }

    public void removeCustProduct(Product p) {
        if(cart.contains(p)){
            cart.remove(p);
            accountBalance+=p.getProductCost();
            p.setQuantity(p.getQuantity()+1);
        }
        else{
            System.out.println("Product: "+ p.getProductName() + "was not added to cart");
        }

    }

    public void  removeSellerProduct(Product p){
        myProducts.remove(p);
    }

    public int getProductsNum() {
        return productsNum;
    }

    public void updateQuantity(Product p, int q){
        p.setQuantity(q);
    }

    public int getUserId() {
        return userId;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getName() {
        return name;
    }

    public Vector<Product> getCart() {
        return cart;
    }
    
    public void printCustInfo() {
        System.out.println("    Customer Information");
        System.out.println("********************************");
        System.out.println("Address: " + address.getFullAddress());

    }

    public void printSellerInfo() {
        System.out.println("    Seller Information");
        System.out.println("********************************");
        System.out.println("Number of products: " + myProducts.size());
    }

    public void printInfo(){
        System.out.println("User ID: " + userId);
        System.out.println("Name: " + name);
    }
}
