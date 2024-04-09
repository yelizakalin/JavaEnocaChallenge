package EnocaTest;
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String CustomerName;
    private  int CustomerID;
    
    private static List<Customer> customerList = CustomerNameListele();
    
    private static int lastCustomerID = customerList.size();
    
    
    public  Customer(String CustomerName, int CustomerID){
        this.CustomerName = CustomerName;
        this.CustomerID = CustomerID;
    }
    

    

    public String getCustomerName() {
        return CustomerName;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

  

    public static List<Customer>  CustomerNameListele(){
    	List<Customer> customer = new ArrayList<>();
        customer.add(new Customer("Ayşe Benli",1));
        customer.add(new Customer("Kieun Choie",2));
        customer.add(new Customer("Yeliz Akalın",3));
        return  customer;
    }

}
