package commands;

public interface Commands {

    String EXIT = "0";
    String LOGOUT = "0";
    String ADD_PRODUCT = "1";
    String LOGIN = "1";
    String PRINT_ALL_PRODUCTS = "1";
    String REGISTER = "2";
    String REMOVE_PRODUCT_BY_ID = "2";
    String BUY_PRODUCT = "2";
    String PRINT_PRODUCTS = "3";
    String PRINT_MY_ORDERS = "3";
    String CANCEL_ORDER_BY_ID = "4";
    String PRINT_USERS = "4";
    String PRINT_ORDERS = "5";
    String CHANGE_ORDER_STATUS = "6";
    String ADD_ADMIN = "7";

    static void printCommands() {
        System.out.println("Please input " + EXIT + " for EXIT");
        System.out.println("Please input " + LOGIN + " for LOGIN");
        System.out.println("Please input " + REGISTER + " for REGISTER");

    }

    static void printUserCommands() {
        System.out.println("PLease input " + LOGOUT + " for LOGOUT");
        System.out.println("PLease input " + PRINT_ALL_PRODUCTS + " for PRINT ALL PRODUCTS");
        System.out.println("PLease input " + BUY_PRODUCT + " for BUY PRODUCT");
        System.out.println("PLease input " + PRINT_MY_ORDERS + " for PRINT MY ORDERS");
        System.out.println("PLease input " + CANCEL_ORDER_BY_ID + " for CANCEL ORDER BY ID");

    }

    static void printAdminCommands() {
        System.out.println("PLease input " + LOGOUT + " for LOGOUT");
        System.out.println("PLease input " + ADD_PRODUCT + " for ADD PRODUCT");
        System.out.println("PLease input " + REMOVE_PRODUCT_BY_ID + " for REMOVE PRODUCT BY ID");
        System.out.println("PLease input " + PRINT_PRODUCTS + " for PRINT PRODUCTS");
        System.out.println("PLease input " + PRINT_USERS + " for PRINT USERS");
        System.out.println("PLease input " + PRINT_ORDERS + " for PRINT ORDERS");
        System.out.println("PLease input " + CHANGE_ORDER_STATUS + " for CHANGE ORDER STATUS");
        System.out.println("Please input " + ADD_ADMIN + " for ADD ADMIN");


    }


}
