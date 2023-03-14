package myorg.myproject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorLogic implements ActionListener {
    private final JTextField textField;
    private String operator;
    private double operand1;

    public CalculatorLogic(JTextField textField) {
        this.textField = textField;
        operator = "";
        operand1 = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonLabel = ((JButton) e.getSource()).getText();
        if (buttonLabel.matches("[0-9]")) {
            textField.setText(textField.getText() + buttonLabel);
        } else if (buttonLabel.equals("C")) {
            textField.setText("");
            operator = "";
            operand1 = 0;
        } else if (buttonLabel.equals("=")) {
            double operand2 = Double.parseDouble(textField.getText());
            double result = calculateResult(operand1, operand2, operator);
            textField.setText(Double.toString(result));
            operator = "";
            operand1 = result;
        } else {
            operator = buttonLabel;
            operand1 = Double.parseDouble(textField.getText());
            textField.setText("");
        }
    }

    private double calculateResult(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
