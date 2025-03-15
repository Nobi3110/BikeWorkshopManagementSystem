import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {

    private BikeWorkshopManagement frame;

    public MainPanel(BikeWorkshopManagement frame) {
        this.frame = frame;
        setLayout(new GridLayout(3, 1));

        JButton buyPartsButton = new JButton("Buy Parts");
        JButton serviceBikeButton = new JButton("Service Bike");
        JButton viewCartButton = new JButton("View Cart");

        buyPartsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.showPanel("BuyParts");
            }
        });

        serviceBikeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.showPanel("ServiceBike");
            }
        });

        viewCartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.showPanel("Cart");
            }
        });

        add(buyPartsButton);
        add(serviceBikeButton);
        add(viewCartButton);
    }
}
