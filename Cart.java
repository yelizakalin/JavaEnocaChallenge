package EnocaTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart implements CartMethods{

    private List<Product> items;
    private int itemStock;
    private double price;
    double amount;
    
    
    public List<Product> getItems() {
        return items;
    }

    public int getItemStock() {
        return itemStock;
    }

    public void setItemStock(int itemStock) {
        this.itemStock = itemStock;
    }

    public int getPrice() {
        return itemStock;
    }

    public void setPrice(double priceTotal) {
        this.price = priceTotal;
    }
    
    public Cart() {
        items = new ArrayList<>();
    }
    
    
    public boolean isEmpty() {
    	return items.isEmpty();
    }
    
    

    
    


   
    
    @Override
    public void getCart() {
        System.out.println("Items in cart:");
        Product lastProduct = items.get(items.size() - 1);
        int quantity = getItemStock();
            System.out.println(lastProduct.getProductName() + " - Quantity: " + quantity + 
                               " Total Amount: " + (lastProduct.getPrice() * quantity));
            price += (lastProduct.getPrice() * quantity);

    }
    
    
    

    
    public void removeFromCart(Product product, int emptyStock) {
        if (items.contains(product)) {
            int index = items.indexOf(product);
            Product removedProduct = items.get(index);
            while (emptyStock > itemStock) {
                System.out.println("The entered an unavailable quantity. Please enter a valid quantity.");
                System.out.print("How many do you want to delete?");
                Scanner scanner = new Scanner(System.in);
                emptyStock = scanner.nextInt();
            }
            items.remove(index);
            removedProduct.increaseStockState(emptyStock); 
            System.out.println("Product removed from cart: " + removedProduct.getProductName());
        } else {
            System.out.println("The product is not in the cart.");
        }
    }

    

    @Override
    public void emptyCart() {
        items.clear();
        System.out.println("Cart emptied.");
    }

   public void addToCart(Product product, int itemStock,double priceTotal) {
    	
    	if (product.getStockState() >= itemStock) {

    		items.add(product);

    		 product.decreaseStockState(itemStock);
    		 
    		 getCart();

        } else {
           System.out.println("We're sorry, it has no stock");
        }	
    }
}
