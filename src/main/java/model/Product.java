package model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    private String name;
    private String id;
    private String description;
    private double price;
    private int count;
    private TypeProducts typeproducts;

//    public Product(String name, String description, String price, String count) {
//    }
//
//    public Product() {
//    }
//
//    public Product(String name, String description, double price, int count, TypeProducts type) {
//        this.id = UUID.idGenerate();
//        this.name = name;
//        this.description = description;
//        this.price = price;
//        this.count =count ;
//        this.typeproducts=type;
//
//    }
//
//
//    public  String getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public int getCount() {
//        return count;
//    }
//
//    public void setStockQty(int count) {
//        this.count = count;
//    }
//
//    public void setCount(int count) {
//        this.count = count;
//    }
//
//    public TypeProducts getType() {
//        return typeproducts;
//    }
//
//    public void setType(TypeProducts type) {
//        this.typeproducts = type;
//    }
//
//    @Override
//    public String toString() {
//        return "Product{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                ", price=" + price +
//                ", count=" + count +
//                ", type=" + typeproducts +
//                '}';
//    }
}

