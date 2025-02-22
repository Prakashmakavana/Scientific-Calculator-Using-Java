import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogarithmicFunctionsCalculator extends JFrame {
    private JTextField numberField, baseField;
    private JLabel log10Label, lnLabel, logBaseLabel;

    public LogarithmicFunctionsCalculator() {
        // Set up the GUI window
        setTitle("Logarithmic Functions Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        // Create components
        JLabel numberLabel = new JLabel("Enter Number:");
        JLabel baseLabel = new JLabel("Enter Base (for Logarithm):");
        numberField = new JTextField(10);
        baseField = new JTextField(10);
        JButton calculateButton = new JButton("Calculate");
        log10Label = new JLabel();
        lnLabel = new JLabel();
        logBaseLabel = new JLabel();

        // Add components to the GUI window
        add(numberLabel);
        add(numberField);
        add(baseLabel);
        add(baseField);
        add(calculateButton);
        add(new JLabel());
        add(new JLabel("Logarithm (base 10):"));
        add(log10Label);
        add(new JLabel("Natural Logarithm (base e):"));
        add(lnLabel);
        add(new JLabel("Logarithm (custom base):"));
        add(logBaseLabel);

        // Add action listener to the calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateLogarithmicFunctions();
            }
        });
    }

    private void calculateLogarithmicFunctions() {
        // Get the input number and base from the text fields
        String numberInput = numberField.getText();
        String baseInput = baseField.getText();
        try {
            double number = Double.parseDouble(numberInput);
            double base = Double.parseDouble(baseInput);

            // Calculate logarithmic functions
            double log10 = Math.log10(number);
            double ln = Math.log(number);
            double logBase = Math.log(number) / Math.log(base);

            // Display the results
            log10Label.setText(String.format("%.4f", log10));
            lnLabel.setText(String.format("%.4f", ln));
            logBaseLabel.setText(String.format("%.4f", logBase));
        } catch (NumberFormatException ex) {
            // Display error message for invalid input
            log10Label.setText("Error: Invalid input");
            lnLabel.setText("");
            logBaseLabel.setText("");
        }
    }

    public static void main(String[] args) {
        // Create and display the LogarithmicFunctionsCalculator GUI
        LogarithmicFunctionsCalculator calculator = new LogarithmicFunctionsCalculator();
        calculator.setSize(400, 300);
        calculator.setVisible(true);
    }
}
