import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator {
    // GUI components
    private JFrame frame;
    private JTextField textField;
    private JButton[] buttons;
    private String[] buttonLabels = {
            "0", "1", "2", "3",
            "4", "5", "6", "7",
            "8", "9", "+", "-",
            "*", "/", "="
    };
    private JButton btnClear;
    private double firstOperand;
    private String operator;

    public SimpleCalculator() {
        frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setEditable(false);
        frame.add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        buttons = new JButton[buttonLabels.length];
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].addActionListener(new ButtonClickListener());
            panel.add(buttons[i]);
        }

        btnClear = new JButton("C");
        btnClear.addActionListener(new ButtonClickListener());
        panel.add(btnClear);

        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            JButton source = (JButton) event.getSource();
            String text = source.getText();

            switch (text) {
                case "=":
                    double secondOperand = Double.parseDouble(textField.getText());
                    double result = 0.0;
                    switch (operator) {
                        case "+":
                            result = firstOperand + secondOperand;
                            break;
                        case "-":
                            result = firstOperand - secondOperand;
                            break;
                        case "*":
                            result = firstOperand * secondOperand;
                            break;
                        case "/":
                            result = firstOperand / secondOperand;
                            break;
                    }
                    textField.setText(String.valueOf(result));
                    operator = null;
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    operator = text;
                    firstOperand = Double.parseDouble(textField.getText());
                    textField.setText("");
                    break;
                case "C":
                    textField.setText("");
                    operator = null;
                    break;
                default:
                    textField.setText(textField.getText() + text);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SimpleCalculator();
        });
    }
}
