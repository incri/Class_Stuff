package FrontendLayer;

import java.awt.EventQueue;
import java.awt.event.MouseListener;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class CardDetailBox extends JInternalFrame {
	static JTextField cardTypeTextField;
	static JTextField nameOnCardTextField;
	static JTextField cardNumberTextField;

	
	public CardDetailBox() {
		setBounds(0, 0, 316, 316);
		setTitle("Credit Card Details");
		BasicInternalFrameUI basicInternalFrameUI = ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI());
		for(MouseListener listener: basicInternalFrameUI.getNorthPane().getMouseListeners()){
			basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
		}
		getContentPane().setLayout(null);
		
		JLabel cardTypeLabel = new JLabel("Credit Card Type");
		cardTypeLabel.setBounds(22, 12, 126, 17);
		getContentPane().add(cardTypeLabel);
		
		JLabel nameOnCardLabel = new JLabel("Name On Card");
		nameOnCardLabel.setBounds(22, 74, 126, 34);
		getContentPane().add(nameOnCardLabel);
		
		JLabel cardNumberLabel= new JLabel("Card Number");
		cardNumberLabel.setBounds(22, 146, 126, 34);
		getContentPane().add(cardNumberLabel);
		
		
		cardTypeTextField = new JTextField();
		cardTypeTextField.setBounds(22, 41, 249, 21);
		getContentPane().add(cardTypeTextField);
		cardTypeTextField.setColumns(10);
		
		nameOnCardTextField = new JTextField();
		nameOnCardTextField.setColumns(10);
		nameOnCardTextField.setBounds(22, 113, 249, 21);
		getContentPane().add(nameOnCardTextField);
		
		cardNumberTextField = new JTextField();
		cardNumberTextField.setColumns(10);
		cardNumberTextField.setBounds(22, 189, 249, 21);
		getContentPane().add(cardNumberTextField);
		
		JButton btnAddExistingDetails = new JButton("Add Existing Details");
		btnAddExistingDetails.setBounds(22, 232, 155, 27);
		getContentPane().add(btnAddExistingDetails);
	}
}
