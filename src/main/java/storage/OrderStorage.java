package storage;


import model.Order;
import model.OrderStatus;

import java.util.LinkedList;

public class OrderStorage {
    private final LinkedList<Order> orderLinkedList = new LinkedList<>();

    public void addOrder(Order order) {
        orderLinkedList.add(order);
    }

    public void printOnlineOrders(Object onlineUser) {
        for (Order order : orderLinkedList) {
            if (order.getUser().equals(onlineUser)) {
                System.out.println(order);
            }
        }
    }

    public void printOrders() {
        if (!orderLinkedList.isEmpty()) {
            for (Order order : orderLinkedList) {
                System.out.println(order);
            }
        }
    }



    public void changeOrderStatus(String id) {
        for (Order order : orderLinkedList) {
            if (order.getId().equals(id)) {
                order.setOrderStatus(OrderStatus.DELIVERED);
                order.getProduct().setCount(order.getProduct().getCount() - order.getCount());
            }
        }
    }
    public void cancelOrderById(String orderId) {
        boolean exist = false;
        for (Order order : orderLinkedList) {
            if (order.getId().equals(orderId)) {
                order.setOrderStatus(OrderStatus.CANCELED);
                exist = true;
                System.out.println("Order canceled");
            }
        }
        if (!exist) {
            System.out.println(orderId + " this id dose not found");
        }
    }
}
