import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MathFunctionsCalculator extends JFrame {
    private JTextField inputField;
    private JLabel sqrtLabel, cbrtLabel, factorialLabel;

    public MathFunctionsCalculator() {
        // Set up the GUI window
        setTitle("Math Functions Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        // Create components
        JLabel inputLabel = new JLabel("Enter a number:");
        inputField = new JTextField(10);
        JButton calculateButton = new JButton("Calculate");
        sqrtLabel = new JLabel();
        cbrtLabel = new JLabel();
        factorialLabel = new JLabel();

        // Add components to the GUI window
        add(inputLabel);
        add(inputField);
        add(calculateButton);
        add(new JLabel());
        add(new JLabel("Square Root:"));
        add(sqrtLabel);
        add(new JLabel("Cube Root:"));
        add(cbrtLabel);
        add(new JLabel("Factorial:"));
        add(factorialLabel);

        // Add action listener to the calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateMathFunctions();
            }
        });
    }

    private void calculateMathFunctions() {
        // Get the input number from the text field
        String input = inputField.getText();
        try {
            double num = Double.parseDouble(input);

            // Calculate square root, cube root, and factorial
            double sqrt = Math.sqrt(num);
            double cbrt = Math.cbrt(num);
            long factorial = calculateFactorial((int) num);

            // Display the results
            sqrtLabel.setText(String.format("%.4f", sqrt));
            cbrtLabel.setText(String.format("%.4f", cbrt));
            factorialLabel.setText(String.format("%d", factorial));
        } catch (NumberFormatException ex) {
            // Display error message for invalid input
            sqrtLabel.setText("Error: Invalid input");
            cbrtLabel.setText("");
            factorialLabel.setText("");
        }
    }

    private long calculateFactorial(int num) {
        // Base case: factorial of 0 or 1 is 1
        if (num == 0 || num == 1) {
            return 1;
        }
        // Recursive case: factorial of n is n multiplied by factorial of n-1
        else {
            return num * calculateFactorial(num - 1);
        }
    }

    public static void main(String[] args) {
        // Create and display the MathFunctionsCalculator GUI
        MathFunctionsCalculator calculator = new MathFunctionsCalculator();
        calculator.setSize(400, 300);
        calculator.setVisible(true);
    }
}
