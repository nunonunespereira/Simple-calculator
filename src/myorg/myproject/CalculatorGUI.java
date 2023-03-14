package myorg.myproject;
import javax.swing.*;
import java.awt.*;

public class CalculatorGUI extends JFrame {
    private final JTextField textField;

    public CalculatorGUI() {
        setTitle("Simple Java Calculator ver_0.1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.DARK_GRAY);

        textField = new JTextField();
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.PLAIN, 40));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setBackground(new Color(50, 50, 50));
        textField.setForeground(Color.WHITE);
        add(textField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));
        String[] buttonLabels = {
                "7", "8", "9", "+",
                "4", "5", "6", "-",
                "1", "2", "3", "*",
                "C", "0", "=", "/"
        };
        CalculatorLogic calculatorLogic = new CalculatorLogic(textField);
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 40));
            button.setBackground(new Color(50, 50, 50));
            button.setForeground(Color.BLACK);
            button.addActionListener(calculatorLogic);
            buttonPanel.add(button);
        }
        buttonPanel.setBackground(new Color(30, 30, 30));
        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}
