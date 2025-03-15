import javax.swing.*;
import java.awt.*;

public class BikeWorkshopManagement extends JFrame {

    private JPanel mainPanel, buyPartsPanel, serviceBikePanel, cartPanel;
    private CardLayout cardLayout;

    public BikeWorkshopManagement() {
        setTitle("Bike Workshop Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        mainPanel = new MainPanel(this);
        buyPartsPanel = new BuyPartsPanel(this);
        serviceBikePanel = new ServiceBikePanel(this);
        cartPanel = new CartPanel(this);

        add(mainPanel, "Main");
        add(buyPartsPanel, "BuyParts");
        add(serviceBikePanel, "ServiceBike");
        add(cartPanel, "Cart");

        setVisible(true);
    }

    public void showPanel(String panelName) {
        cardLayout.show(getContentPane(), panelName);
    }

    public static void main(String[] args) {
        new BikeWorkshopManagement();
    }
}
