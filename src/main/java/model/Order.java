package model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import util.UUID;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private User user;
    private String id;
    private Product product;
    private OrderStatus orderStatus;
    private Date date;
    private double price;
    private int count;

    private PaymentMethod paymentMethod;


}


//    @Override
//    public String toString() {
//        return "Order{" +
//                "user=" + user +
//                ", product=" + product +
//                ", orderStatus=" + orderStatus +
//                ", id=" + id +
//                ", date=" + date +
//                ", price=" + price +
//                ", count=" + count +
//                ", paymentMethod=" + paymentMethod +
//                '}';
//    }

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

//    public Order(User user, Product product, OrderStatus orderStatus, Date date, double price, int count, PaymentMethod paymentMethod) {
//        this.user = user;
//        this.id= UUID.idGenerate();
//        this.product = product;
//        this.orderStatus = orderStatus;
//        this.date = date;
//        this.price = price;
//        this.count = count;
//        this.paymentMethod = paymentMethod;
//    }
//
//    public Order() {
//    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//
//    public OrderStatus getOrderStatus() {
//        return orderStatus;
//    }
//
//    public void setOrderStatus(OrderStatus orderStatus) {
//        this.orderStatus = orderStatus;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
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
//    public void setCount(int count) {
//        this.count = count;
//    }
//
//    public PaymentMethod getPaymentMethod() {
//        return paymentMethod;
//    }
//
//    public void setPaymentMethod(PaymentMethod paymentMethod) {
//        this.paymentMethod = paymentMethod;
//    }
//}
