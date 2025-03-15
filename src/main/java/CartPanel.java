import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CartPanel extends JPanel {

    private BikeWorkshopManagement frame;
    private JTextArea cartTextArea;
    private JTextField discountField;
    private double discount = 0;

    public CartPanel(BikeWorkshopManagement frame) {
        this.frame = frame;
        setLayout(new BorderLayout());

        cartTextArea = new JTextArea();
        cartTextArea.setEditable(false);
        cartTextArea.setBackground(Color.LIGHT_GRAY);
        cartTextArea.setForeground(Color.BLACK);
        add(new JScrollPane(cartTextArea), BorderLayout.CENTER);

        JPanel discountPanel = new JPanel();
        discountPanel.setLayout(new FlowLayout());

        JLabel discountLabel = new JLabel("Enter Discount (%)");
        discountField = new JTextField(5);
        JButton applyDiscountButton = new JButton("Apply Discount");

        applyDiscountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double discountPercentage = Double.parseDouble(discountField.getText());
                    if (discountPercentage < 0 || discountPercentage > 100) {
                        JOptionPane.showMessageDialog(null, "Invalid discount percentage. Please enter a value between 0 and 100.");
                    } else {
                        discount = Cart.getTotalCost() * (discountPercentage / 100);
                        double discountedTotal = Cart.getTotalCost() - discount;

                        cartTextArea.setText("Cart Contents:\n");
                        for (String item : Cart.getCart()) {
                            cartTextArea.append(item + "\n");
                        }
                        cartTextArea.append("\nOriginal Total: BDT " + Cart.getTotalCost() + "\n");
                        cartTextArea.append("Discount Applied: -BDT " + discount + "\n");
                        cartTextArea.append("Total after Discount: BDT " + discountedTotal);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number for discount.");
                }
            }
        });

        discountPanel.add(discountLabel);
        discountPanel.add(discountField);
        discountPanel.add(applyDiscountButton);

        add(discountPanel, BorderLayout.NORTH);

        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cart.getCart().clear();
                Cart.setTotalCost(0);

                cartTextArea.setText("Cart is empty.\n");
                cartTextArea.setBackground(Color.LIGHT_GRAY);
                discountField.setText("");
                discount = 0;

                frame.showPanel("Main");
            }
        });

        add(checkoutButton, BorderLayout.SOUTH);

        JButton backButton = new JButton("Back to Main");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.showPanel("Main");
            }
        });

        add(backButton, BorderLayout.WEST);
    }
}
