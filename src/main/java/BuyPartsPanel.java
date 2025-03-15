import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyPartsPanel extends JPanel {

    private BikeWorkshopManagement frame;

    public BuyPartsPanel(BikeWorkshopManagement frame) {
        this.frame = frame;
        setLayout(new GridLayout(6, 2));

        setBackground(Color.LIGHT_GRAY);

        String[] partsList = {"Brake Pads", "Tires", "Chain", "Lubricant"};
        double[] prices = {880.0, 3550.0, 4850.0, 1890.0};

        for (int i = 0; i < partsList.length; i++) {

            JLabel partLabel = new JLabel(partsList[i] + " - BDT " + prices[i]);
            add(partLabel);

            JButton addButton = new JButton("Add to Cart");
            final int index = i;

            addButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Cart.getCart().add(partsList[index]);
                    Cart.setTotalCost(Cart.getTotalCost() + prices[index]);
                    JOptionPane.showMessageDialog(null, partsList[index] + " added to cart.");
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
