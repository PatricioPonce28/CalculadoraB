import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora Básica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);
        frame.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Número 1:");
        JTextField textField1 = new JTextField(10);

        JLabel label2 = new JLabel("Número 2:");
        JTextField textField2 = new JTextField(10);

        JButton btnSuma = new JButton("+");
        JButton btnResta = new JButton("-");
        JButton btnMultiplicacion = new JButton("*");
        JButton btnDivision = new JButton("%");

        JLabel lblResultado = new JLabel("Resultado: ");

        frame.add(label1);
        frame.add(textField1);
        frame.add(label2);
        frame.add(textField2);

        frame.add(btnSuma);
        frame.add(btnResta);
        frame.add(btnMultiplicacion);
        frame.add(btnDivision);

        frame.add(lblResultado);

        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(textField1.getText());
                    double num2 = Double.parseDouble(textField2.getText());
                    double resultado = 0;

                    if (e.getSource() == btnSuma) {
                        resultado = num1 + num2;
                    } else if (e.getSource() == btnResta) {
                        resultado = num1 - num2;
                    } else if (e.getSource() == btnMultiplicacion) {
                        resultado = num1 * num2;
                    } else if (e.getSource() == btnDivision) {
                        if (num2 != 0) {
                            resultado = num1 / num2;
                        } else {
                            lblResultado.setText("Error: División por cero");
                            return;
                        }
                    }

                    lblResultado.setText("Resultado: " + resultado);
                } catch (NumberFormatException ex) {
                    lblResultado.setText("Error: Entrada no válida");
                }
            }
        };

        btnSuma.addActionListener(actionListener);
        btnResta.addActionListener(actionListener);
        btnMultiplicacion.addActionListener(actionListener);
        btnDivision.addActionListener(actionListener);

        frame.setVisible(true);
    }
}