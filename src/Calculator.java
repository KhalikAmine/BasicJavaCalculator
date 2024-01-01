import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Amine
 *
 */


public class Calculator implements ActionListener {
	JFrame frame;
	JTextField textField;
	JButton[] numberOfButtons = new JButton[10];
	JButton[] numberOfFunctions = new JButton[9];
	
	JButton addition, subtraction, division, multiplication, 
			equal,decimal,clear;
	
	JPanel panel;
	
	
	Font myFont = new Font("Calibri",Font.BOLD,25);
	
	double num1 = 0, num2 = 0, result = 0;
	String operator;
	
	Calculator() {
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 600);
		frame.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(50, 25, 300, 50);
		textField.setFont(myFont);
		textField.setEditable(false);
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
		
		addition = new JButton("+");
		subtraction = new JButton("-");
		division = new JButton("÷");
		multiplication = new JButton("×");
		equal = new JButton("=");
		decimal = new JButton(".");
		
		numberOfFunctions[0] = addition;
		numberOfFunctions[1] = subtraction;
		numberOfFunctions[2] = division;
		numberOfFunctions[3] = multiplication;
		numberOfFunctions[4] = equal;
		numberOfFunctions[5] = decimal;
		
		
		
		
		
		
		for(int i = 0; i < 10; i++) {
			numberOfButtons[i] = new JButton("" + i);
			numberOfButtons[i].setFont(myFont);
			numberOfButtons[i].addActionListener(this);
			panel.add(numberOfButtons[i]);
		}
		
		for(int i = 0; i < 6; i++) {
			numberOfFunctions[i].addActionListener(this);
			numberOfFunctions[i].setFont(myFont);
			numberOfFunctions[i].setFocusable(false);
			panel.add(numberOfFunctions[i]);
		}
		
	
		
		
		frame.add(panel);
		frame.add(textField);
		frame.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new Calculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		for(int i = 0; i < 10; i++) {
			if(e.getSource() == numberOfButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
	
	if(e.getSource() == addition) {
		num1 = Double.parseDouble(textField.getText());
		operator = "+";
		textField.setText("");
	}
	if(e.getSource() == subtraction) {
		num1 = Double.parseDouble(textField.getText());
		operator = "-";
		textField.setText("");
	}
	if(e.getSource() == division) {
		num1 = Double.parseDouble(textField.getText());
		operator = "÷";
		textField.setText("");
	}
	if(e.getSource() == multiplication) {
		num1 = Double.parseDouble(textField.getText());
		operator = "×";
		textField.setText("");
	}
	if(e.getSource() == equal) {
		num2 = Double.parseDouble(textField.getText());
		switch(operator) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case"÷":
			result = num1 / num2;
			break;
		case"×":
			result = num1 * num2;
			break;
		}
		textField.setText(String.valueOf(result));
		num1 = result;
	}
	if(e.getSource() == decimal) {
		if(!textField.getText().contains(".")) {
		textField.setText(textField.getText().concat("."));
		}
	}
	}
}



