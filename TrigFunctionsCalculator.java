import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrigFunctionsCalculator extends JFrame {
    private JTextField angleField;
    private JLabel sinLabel, cosLabel, tanLabel, cotLabel, secLabel, cscLabel;

    public TrigFunctionsCalculator() {
        // Set up the GUI window
        setTitle("Trig Functions Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

        // Create components
        JLabel angleLabel = new JLabel("Enter Value :");
        angleField = new JTextField(10);
        JButton calculateButton = new JButton("Calculate");
        sinLabel = new JLabel();
        cosLabel = new JLabel();
        tanLabel = new JLabel();
        cotLabel = new JLabel();
        secLabel = new JLabel();
        cscLabel = new JLabel();

        // Add components to the GUI window
        add(angleLabel);
        add(angleField);
        add(calculateButton);
        add(new JLabel());
        add(new JLabel("Sine:"));
        add(sinLabel);
        add(new JLabel("Cosine:"));
        add(cosLabel);
        add(new JLabel("Tangent:"));
        add(tanLabel);
        add(new JLabel("Cotangent:"));
        add(cotLabel);
        add(new JLabel("Secant:"));
        add(secLabel);
        add(new JLabel("Cosecant:"));
        add(cscLabel);

        // Add action listener to the calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTrigFunctions();
            }
        });
    }

    private void calculateTrigFunctions() {
        // Get the input angle in degrees from the text field
        String input = angleField.getText();
        try {
            double angle = Double.parseDouble(input);

            // Convert angle to radians
            double angleRad = Math.toRadians(angle);

            // Calculate trigonometric functions
            double sin = Math.sin(angleRad);
            double cos = Math.cos(angleRad);
            double tan = Math.tan(angleRad);
            double cot = 1 / Math.tan(angleRad);
            double sec = 1 / Math.cos(angleRad);
            double csc = 1 / Math.sin(angleRad);

            // Display the results
            sinLabel.setText(String.format("%.4f", sin));
            cosLabel.setText(String.format("%.4f", cos));
            tanLabel.setText(String.format("%.4f", tan));
            cotLabel.setText(String.format("%.4f", cot));
            secLabel.setText(String.format("%.4f", sec));
            cscLabel.setText(String.format("%.4f", csc));
        } catch (NumberFormatException ex) {
            // Display error message for invalid input
            sinLabel.setText("Error: Invalid input");
            cosLabel.setText("");
            tanLabel.setText("");
            cotLabel.setText("");
            secLabel.setText("");
            cscLabel.setText("");
        }
    }

    public static void main(String[] args) {
        // Create and display the TrigFunctionsCalculator GUI
        TrigFunctionsCalculator calculator = new TrigFunctionsCalculator();
        calculator.setSize(400, 300);
        calculator.setVisible(true);
    }
}
