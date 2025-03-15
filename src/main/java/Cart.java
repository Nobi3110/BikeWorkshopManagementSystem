import java.util.ArrayList;

public class Cart {

    private static ArrayList<String> cart = new ArrayList<>();
    private static double totalCost = 0;

    public static ArrayList<String> getCart() {
        return cart;
    }

    public static double getTotalCost() {
        return totalCost;
    }

    public static void setTotalCost(double totalCost) {
        Cart.totalCost = totalCost;
    }

    static void addToCart(String oil_Change, int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    static void clearCart() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
