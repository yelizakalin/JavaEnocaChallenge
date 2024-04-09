package EnocaTest;
import java.util.ArrayList;
import java.util.List;

public  class Product {
    public String productName;
    private double price;
    private int stockState;
    
    private static List<Product> productList = ProductListele();
    

    public Product(String productName,int stockState,double price){
        this.productName = productName;
        this.stockState = stockState;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

  public double getPrice() {
       return price;
   }
    public void setPrice(double price) {
       this.price = price;
   }

    public int getStockState() {
      return stockState;
    }

    public void setStockState(int stockState) {
       this.stockState = stockState;
    }


public static void ProductNameListele(){
    List<String> productList = new ArrayList<>();
    productList.add("Apple");
    productList.add("Chocolate");
    productList.add("Simit");
    productList.add("Cola");
    productList.add("Ice Cream");
    productList.add("Bread");
    System.out.println("Product = " + productList);
}
  public static List<Product> ProductListele(){
      List<Product> productList= new ArrayList();
      productList.add(new Product("Apple",10,12.5));
      productList.add(new Product("Chocolate",5,10.0));
      productList.add(new Product("Simit",50,5.5));
      productList.add(new Product("Cola",100,23.78));
      productList.add(new Product("Ice Cream",7,12.45));
      productList.add(new Product("Bread",122,15.50));
      return productList;
  }
  
  
  
  
  
    public static void StockListele(List<Product> products, String productName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                System.out.println(product.getProductName() + " Stock State: " + product.getStockState());
            }
        }
    }
    
    
    
    
    public void decreaseStockState(int quantity) {
        this.stockState -= quantity;
       System.out.println( getProductName()+ " stok sayısı:" + getStockState());
    }
    
    
    public void increaseStockState(int quantity) {
    	
    	this.stockState += quantity;
        System.out.println( getProductName()+ " stok sayısı:" + getStockState());
    }
}


