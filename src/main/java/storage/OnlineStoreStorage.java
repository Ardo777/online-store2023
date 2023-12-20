package storage;//package Homework.OnlineStore.Storage;
//
//import Homework.OnlineStore.model.*;
//
//public class OnlineStoreStorage {
//    Object[] array = new Object[10];
//    private int size;
//
//    public void add(Object value) {
//        if (size == array.length) {
//            extend();
//        }
//        array[size++] = value;
//
//    }
//
//    private void extend() {
//        Object[] newArray = new Object[array.length + 10];
//        System.arraycopy(array, 0, newArray, 0, array.length);
//        array = newArray;
//
//    }
//
//
//    public Object login(String email, String password) {
//        for (int i = 0; i < size; i++) {
//            if (array[i] instanceof User user) {
//                if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
//                    return array[i];
//                }
//            }
//        }
//        return null;
//    }
//
//    public void print() {
//        if (array.length != 0) {
//            for (int i = 0; i < size; i++) {
//                System.out.println(array[i]);
//
//            }
//        }
//    }
//
//    public Object getProductById(String id) {
//        for (int i = 0; i <= size; i++) {
//            if (array[i] instanceof Product product && product.getId().equals(id)) {
//                return product;
//            }
//        }
//        return null;
//    }
//    public void printOnlineOrders(Object onlineUser) {
//        for (int i = 0; i <= size; i++) {
//            if (array[i] instanceof Order order && order.getUser().equals(onlineUser)) {
//                System.out.println(array[i]);
//            }
//        }
//    }
//    public void changeOrderStatusCancel(String orderId){
//        for (int i = 0; i <=size; i++) {
//            if (array[i]instanceof Order order && order.getId().equals(orderId)){
//                order.setOrderStatus(OrderStatus.CANCELED);
//                order=null;
//            }
//        }
//    }
//
//    public double sumPrice(Product product, int count) {
//        return product.getPrice() * count;
//
//    }
//    public void changerUserType(User userIdForChanged){
//        userIdForChanged.setType(Type.ADMIN);
//    }
//
//    public void printUsers() {
//        for (int i = 0; i < size; i++) {
//            if (array[i] instanceof User user && user.getType() == Type.USER) {
//                System.out.println(user);
//            }
//        }
//    }
//    public Object getUserById(String userIdForChanged) {
//        for (int i = 0; i <= size; i++) {
//            if (array[i] instanceof User user && user.getId().equals(userIdForChanged)) {
//                return user;
//            }
//        }
//        return null;
//    }
//    public Object changeOrderStatus(String id) {
//        for (int i = 0; i <= size; i++) {
//            if (array[i] instanceof Order order && order.getId().equals(id)){
//                order.setOrderStatus(OrderStatus.DELIVERED);
//                order.getProduct().setCount(order.getProduct().getCount() - order.getCount());
//                if (order.getProduct().getCount() == 0){
//                    return order.getProduct();
//                }
//            }
//        }
//        return null;
//    }
//
//    public boolean delete(String productId) {
//        for (int i = 0; i < size; i++) {
//            if (array.length != 0) {
//                Product product = (Product) array[i];
//                if (product.getId().equals(productId)) {
//                    deleteByIndex(i);
//                    break;
//                } else
//                    System.out.println("invalid product id,please try again!");
//                return true;
//            }else {
//                System.out.println("Storage is empty");
//            }
//        }
//        return false;
//    }
//
//    private void deleteByIndex(int i) {
//        for (int j = i; j < size; j++) {
//            array[j] = array[j + 1];
//        }
//        size--;
//    }
//
//
//}
