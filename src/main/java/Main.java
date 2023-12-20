

import commands.Commands;
import model.*;
import storage.OrderStorage;
import storage.ProductStorage;
import storage.UserStorage;
import util.UUID;

import java.util.Date;
import java.util.Scanner;

public class Main implements Commands {
    private static User onlineUser;

    private static boolean isRun = true;
    private static final Scanner scanner = new Scanner(System.in);
    private static UUID uuid=new UUID();

    //    private static final OnlineStoreStorage userStorage = new OnlineStoreStorage();

    //   private static final OnlineStoreStorage productStorage = new OnlineStoreStorage();

    // private static final OnlineStoreStorage orderStorage = new OnlineStoreStorage();
    private static final UserStorage userStorage = new UserStorage();
    private static final ProductStorage productStorage = new ProductStorage();
    private static final OrderStorage orderStorage = new OrderStorage();

    public static void main(String[] args) {
        while (isRun) {
            Commands.printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    onlineUser = null;
                    break;
                case LOGIN:
                    login();
                    break;
                case REGISTER:
                    register();
                    break;
                default:
                    System.out.println("Invalid command,Try again!");
            }
        }
    }

    private static void login() {
        System.out.println("Please input email");
        String email = scanner.nextLine();
        System.out.println("please input password");
        String password = scanner.nextLine();
        User user = userStorage.login(email, password);
        if (user != null) {
            onlineUser = user;
            if (user.getType() == Type.ADMIN) {
                loginAdmin();
            } else if (user.getType() == Type.USER) {
                loginUser();
            }

        } else {
            System.out.println("invalid email or password,Try Again!");
            login();
        }

    }

    private static void loginUser() {
        System.out.println("Your profile  |" + onlineUser.getUsername() + "|  your role  |" + onlineUser.getType() + "|  your ID  |" + onlineUser.getId() + "|");
        boolean isRunUser = true;
        while (isRunUser) {
            Commands.printUserCommands();
            String command = scanner.nextLine();
            switch (command) {
                case LOGOUT:
                    isRunUser = false;
                    onlineUser = null;
                    break;
                case PRINT_ALL_PRODUCTS:
                    productStorage.printAllProducts();
                    break;
                case BUY_PRODUCT:
                    buy_product();
                    break;
                case PRINT_MY_ORDERS:
                    orderStorage.printOnlineOrders(onlineUser);
                    break;
                case CANCEL_ORDER_BY_ID:
                    changeOrderStatusCancel();
                    break;
                default:
                    System.out.println("Invalid command,Try again!");
            }
        }
    }

    private static void changeOrderStatusCancel() {
        orderStorage.printOrders();
        System.out.println("Please input order id for canceling");
        String orderID = scanner.nextLine();
        orderStorage.cancelOrderById(orderID);
    }

    private static void buy_product() {
        productStorage.printAllProducts();
        System.out.println("Please input product id");
        String productId = scanner.nextLine();
        Product product = productStorage.getProductById(productId);
        if (product == null) {
            System.out.println("Product " + productId + " " + " does not exist");
        } else {
            System.out.println("Please input quantity of product you want to purchase");
            String countProduct = scanner.nextLine();
            if (product.getCount() >= Integer.parseInt(countProduct) || product.getCount() != 0) {
                double sum;
                sum = productStorage.sumPrice(product, Integer.parseInt(countProduct));
                buy_products(product, sum, Integer.parseInt(countProduct));
            } else {
                System.out.println("Sorry,there are not enough products in storage");
                loginUser();
            }
        }
    }

    private static void buy_products(Product product, double sum, int count) {
        PaymentMethod[] values = PaymentMethod.values();
        for (PaymentMethod value : values) {
            System.out.println(value + " ");
        }
        System.out.println("\nPlease input your payment method");
        String paymentMethod = scanner.nextLine();
        System.out.println("If you want to buy a product in quantities " + count + " for which you will pay " + sum + " please enter <YES> if not enter <NO>");
        String answer = scanner.nextLine();
        if (answer.toUpperCase().equals("YES")) {
            orderStorage.addOrder(new Order(onlineUser,UUID.idGenerate(), product, OrderStatus.NEW, new Date(), sum, count, PaymentMethod.valueOf(paymentMethod)));
            System.out.println("Order created");
        } else
            loginUser();
    }

    private static void loginAdmin() {
        boolean isRunAdmin = true;
        while (isRunAdmin) {
            Commands.printAdminCommands();
            String command = scanner.nextLine();
            switch (command) {
                case LOGOUT:
                    isRunAdmin = false;
                    break;
                case ADD_PRODUCT:
                    addProduct();
                    break;
                case REMOVE_PRODUCT_BY_ID:
                    deleteProductById();
                    break;
                case PRINT_PRODUCTS:
                    productStorage.printAllProducts();
                    break;
                case PRINT_USERS:
                    userStorage.printUsers();
                    break;
                case PRINT_ORDERS:
                    orderStorage.printOrders();
                    break;
                case CHANGE_ORDER_STATUS:
                    changeOrderStatus();
                    break;
                case ADD_ADMIN:
                    addAdmin();
                    break;
                default:
                    System.out.println("Invalid command,Try again!");
            }
        }
    }

    private static void changeOrderStatus() {
        orderStorage.printOrders();
        System.out.println("Please input order id for change");
        orderStorage.changeOrderStatus(scanner.nextLine());
        System.out.println("Order Delivered");
    }

    private static void addAdmin() {
        userStorage.printUsers();
        System.out.println("Please input user id");
        String userIdForChanged = scanner.nextLine();
        User userById = (User) userStorage.getUserById(userIdForChanged);
        if (userById == null) {
            System.out.println("user with " + userIdForChanged + " " + " does not exist");
        } else {
            userStorage.changerUserType(userById);
            System.out.println("User role changed to Admin!");
        }
    }

    private static void deleteProductById() {
        productStorage.printAllProducts();
        if (!productStorage.isEmpty()) {
            System.out.println("Please input product id for deleting");
            String productId = scanner.nextLine();
            if (productStorage.deleteProductById(productId)) {
                System.out.println("Product deleted");
            }
        } else System.out.println("Storage is empty");
    }

    private static void addProduct() {
        System.out.println("Please input product name");
        String name = scanner.nextLine();
        System.out.println("Please input product description");
        String description = scanner.nextLine();
        System.out.println("Please input product price");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Please input count of product");
        int count = Integer.parseInt(scanner.nextLine());
        System.out.println("Please input product categories");
        TypeProducts[] values = TypeProducts.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
        String typeProducts = scanner.nextLine();
        if (typeProducts.equals(TypeProducts.ELECTRONICS.name()) || typeProducts.equals(TypeProducts.CLOTHING.name()) || typeProducts.equals(TypeProducts.BOOKS.name())) {
            Product product = new Product(name, UUID.idGenerate(),description, price, count, TypeProducts.valueOf(typeProducts));
            productStorage.addProduct(product);
            System.out.println("Product added");
        } else {
            System.out.println("Invalid type product,try again!");

        }
    }

    private static void register() {
        System.out.println("Please input username");
        String username = scanner.nextLine();
        System.out.println("Please input email");
        String email = scanner.nextLine();
        System.out.println("Please input password");
        String password = scanner.nextLine();
        System.out.println("Please input phone number");
        String phoneNumber = scanner.nextLine();
        System.out.println("Please input user type");
        Type[] values = Type.values();
        for (Type value : values) {
            System.out.println(value + " ");
        }
        String typeUser = scanner.nextLine().toUpperCase();
        if (typeUser.equals(Type.USER.name()) || typeUser.equals(Type.ADMIN.name())) {
            User user = new User(username,UUID.idGenerate(), email, password, phoneNumber, Type.valueOf(typeUser));
            userStorage.add(email, user);
            System.out.println("You have registered");
        } else {
            System.out.println("Invalid type user,try again!");
            register();
        }
    }
}
