import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExponentialFunctionsCalculator extends JFrame {
    private JTextField xField, yField;
    private JLabel exponentiationLabel, exponentialLabel;

    public ExponentialFunctionsCalculator() {
        // Set up the GUI window
        setTitle("Exponential Functions Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        // Create components
        JLabel xLabel = new JLabel("Enter x:");
        JLabel yLabel = new JLabel("Enter y (for Exponentiation):");
        xField = new JTextField(10);
        yField = new JTextField(10);
        JButton calculateButton = new JButton("Calculate");
        exponentiationLabel = new JLabel();
        exponentialLabel = new JLabel();

        // Add components to the GUI window
        add(xLabel);
        add(xField);
        add(yLabel);
        add(yField);
        add(calculateButton);
        add(new JLabel());
        add(new JLabel("Exponentiation (x^y):"));
        add(exponentiationLabel);
        add(new JLabel("Exponential Function (e^x):"));
        add(exponentialLabel);

        // Add action listener to the calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateExponentialFunctions();
            }
        });
    }

    private void calculateExponentialFunctions() {
        // Get the input x and y from the text fields
        String xInput = xField.getText();
        String yInput = yField.getText();
        try {
            double x = Double.parseDouble(xInput);
            double y = Double.parseDouble(yInput);

            // Calculate exponential functions
            double exponentiation = Math.pow(x, y);
            double exponential = Math.exp(x);

            // Display the results
            exponentiationLabel.setText(String.format("%.4f", exponentiation));
            exponentialLabel.setText(String.format("%.4f", exponential));
        } catch (NumberFormatException ex) {
            // Display error message for invalid input
            exponentiationLabel.setText("Error: Invalid input");
            exponentialLabel.setText("");
        }
    }

    public static void main(String[] args) {
        // Create and display the ExponentialFunctionsCalculator GUI
        ExponentialFunctionsCalculator calculator = new ExponentialFunctionsCalculator();
        calculator.setSize(400, 300);
        calculator.setVisible(true);
    }
}
