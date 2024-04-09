package EnocaTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = Customer.CustomerNameListele();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please Enter your Name: ");
        String customerName = scanner.nextLine();
        int input2 = 0;
        int stock = 0;
        double unitprice = 0.0;
        Cart cart = new Cart();


        
        int customerID = findCustomerIDByName(customers, customerName);
        if (customerID != -1) {
            System.out.println("Welcome");
        } else {
            System.out.println("Customer hasn't been found");

         
            Customer newCustomer = new Customer(customerName, customers.size() + 1);
            customers.add(newCustomer);


          
            System.out.println("Customer List:");
            for (Customer c : customers) {
                System.out.println(c.getCustomerID() + ": " + c.getCustomerName());
            }

        List<Product> products = Product.ProductListele();
        Product.ProductNameListele();

        Scanner scan = new Scanner(System.in);
        String orderName;
 
    
        boolean productFound;
        do {
            productFound = false;
            System.out.print("Please Enter the product: ");
            orderName = scan.next(); 
            for (Product product : products) {
                if (product.getProductName().equalsIgnoreCase(orderName)) {
                    productFound = true;
                    if (product.getStockState() > 0) {
                        System.out.print("Please enter that how many it has: ");
                        input2 = scan.nextInt(); 
                        cart.setItemStock(input2);
                    } else {
                        System.out.println("Product is available");
                    }
                    break;
                }
            }
            if (!productFound) {
                System.out.println("Product is not available");
                System.out.print("Do you would you like to add this product? (Y/N)");
                String enterProduct = scan.next();
                
                if(enterProduct.equalsIgnoreCase("Y")) {
                	System.out.print("Enter stock number for " + orderName + " :");
                    stock = scan.nextInt();
                    
                    System.out.print("Enter unit price for " + orderName + " :");
                    unitprice = scan.nextInt();
                    
                   
                   Product newProduct = new Product(orderName, stock, unitprice); 
                   products.add(newProduct);
                   
                   
                   System.out.println("Product List:");
                  for (Product p : products) {
               	   System.out.println(p.getProductName() + ": " + " Stock Number: " +p.getStockState() +" - " + p.getPrice());
                }
             }
                
            }
            
           
            Product selectedProduct = findProductByName(products, orderName);
            if (selectedProduct != null) {
            	double totalPrice = selectedProduct.getPrice() * input2;
                cart.addToCart(selectedProduct, input2,totalPrice);
                 
             }

            
            System.out.print("Do you want to enter another product? (Y/N): ");
            scan.nextLine();
        } while (scan.nextLine().equalsIgnoreCase("Y"));


        
     
        
        

 


        if (!cart.isEmpty()) {
            System.out.print("Do you want to delete orders? Y/N:");
            String emptyCart = scanner.next();

            if (emptyCart.equalsIgnoreCase("Y")) {
            	 System.out.print("Which one do you want to delete?");
            	 String emptyProduct = scanner.next();
            	 System.out.print("How many do you want to delete?");
            	int emptyStock = scanner.nextInt();
            	 for (Product product : cart.getItems()) {
                    if (product.getProductName().equalsIgnoreCase(emptyProduct)) {
                         cart.removeFromCart(product, emptyStock);
                         break; 
                     }
                }
            	
            } else if (emptyCart.equalsIgnoreCase("N")) {
                System.out.println("Your order hasn't been deleted");
            } else {
                System.out.println("Fail try");
                System.out.println("Do you would like to delete all? ");
                String entry = scanner.next();
                
                if(entry.equalsIgnoreCase("Y")) {
                	 cart.emptyCart();
                }
                
                else if (entry.equalsIgnoreCase("N")) {
                    System.out.println("Your order hasn't been deleted");
            }
         else {
            System.out.println("Order hasn't created.");
        }
    


            }
            
            
        }
        
        }
        
}



    private static Product findProductByName(List<Product> products, String input) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(input)) {
                return product;
            }
        }
        return null;
    }




  private static int findCustomerIDByName(List<Customer> customers, String name) {
        for (Customer customer : customers) {
            if (customer.getCustomerName().equalsIgnoreCase(name)) {
                return customer.getCustomerID();
            }
       }
        return -1;



    }



}
