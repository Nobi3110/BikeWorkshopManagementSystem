import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServiceBikePanel extends JPanel {

    private BikeWorkshopManagement frame;

    public ServiceBikePanel(BikeWorkshopManagement frame) {
        this.frame = frame;
        setLayout(new GridLayout(6, 2));

        setBackground(Color.LIGHT_GRAY);

        String[] servicesList = {"Wheel Alignment", "Master Service", "Oil Change", "Normal Service"};
        double[] prices = {250.0, 3500.0, 100.0, 1750.0};

        for (int i = 0; i < servicesList.length; i++) {
            JLabel serviceLabel = new JLabel(servicesList[i] + " - BDT " + prices[i]);
            add(serviceLabel);

            JButton addButton = new JButton("Add to Cart");
            final int index = i;

            addButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    Cart.getCart().add(servicesList[index]);
                    Cart.setTotalCost(Cart.getTotalCost() + prices[index]);
                    JOptionPane.showMessageDialog(null, servicesList[index] + " added to cart.");
                }
            });

            add(addButton);
        }

        JButton backButton = new JButton("Back to Main");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.showPanel("Main");
            }
        });

        add(backButton);
    }
}
