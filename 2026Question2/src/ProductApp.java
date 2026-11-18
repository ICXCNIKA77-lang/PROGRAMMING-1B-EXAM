import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ProductApp extends JFrame {
    private final JTextField txtName = new JTextField(15);
    private final JComboBox<String> cboProduct = new JComboBox<>(
            new String[]{"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"});
    private final JTextField txtPrice = new JTextField(15);

    public ProductApp() {
        super("Product App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 5, 5));

        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenuItem miProcess = new JMenuItem("Process");
        JMenuItem miClear   = new JMenuItem("Clear");
        JMenuItem miExit    = new JMenuItem("Exit");
        file.add(miExit);
        edit.add(miProcess);
        edit.add(miClear);
        bar.add(file);
        bar.add(edit);
        setJMenuBar(bar);

        JButton btnProcess = new JButton("PROCESS");

        add(new JLabel("Customer Name:")); add(txtName);
        add(new JLabel("Select Product:")); add(cboProduct);
        add(new JLabel("Enter Price:"));    add(txtPrice);
        add(new JLabel());                  add(btnProcess);


        btnProcess.addActionListener(e -> process());
        miProcess.addActionListener(e -> process());
        miClear.addActionListener(e -> clear());
        miExit.addActionListener(e -> System.exit(0));

        pack();
        setLocationRelativeTo(null);
    }

    private void process() {
        try {
            String name = txtName.getText().trim();
            String product = (String) cboProduct.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText().trim());

            IProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            JOptionPane.showMessageDialog(this,
                    "Customer Name: " + name + "\n" +
                            "Product: " + product + "\n" +
                            "VAT: R " + vat + "\n" +
                            "COMMISSION: R " + commission + "\n" +
                            "TOTAL: R " + total);

            saveToFile(name, product, vat, commission, total);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price.");
        }
    }

    private void saveToFile(String name, String product,
                            double vat, double commission, double total) {
        try (PrintWriter out = new PrintWriter(new FileWriter("data.txt", true))) {
            out.println("DATA LOG");
            out.println("*".repeat(30));
            out.println("Customer Name: " + name);
            out.println("Product: " + product);
            out.println("VAT: R " + vat);
            out.println("COMMISSION: R " + commission);
            out.println("TOTAL: R " + total);
            out.println("*".repeat(30));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not write to data.txt");
        }
    }

    private void clear() {
        txtName.setText("");
        txtPrice.setText("");
        cboProduct.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductApp().setVisible(true));
    }
}