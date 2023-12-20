package storage;



import model.Product;

import java.util.HashSet;
import java.util.Set;


public class ProductStorage {
    private  final Set<Product> productHashSet = new HashSet<>();


    public void printAllProducts() {
        boolean exist = true;
        for (Product product : productHashSet) {
            System.out.println(product);
            exist = false;
        }
        if (exist) {
            System.out.println("Storage is empty");
        }
    }

    public Product getProductById(String productId) {
        for (Product product : productHashSet) {
            if (product.getId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public double sumPrice(Product product, int count) {
        return product.getPrice() * count;

    }
    public boolean deleteProductById(String id){
        productHashSet.removeIf(product -> product.getId().equals(id));

        return false;
    }

    public boolean isEmpty(){
       return productHashSet.isEmpty();
    }

public void addProduct(Product product){
        productHashSet.add(product);
}


}
