package FrontendLayer;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class RoomAssignBox extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;

	
	/**
	 * Create the frame.
	 */
	public RoomAssignBox() {
		setBounds(0, 0, 405,372);
		getContentPane().setLayout(null);
		
		JLabel addRoomtitle = new JLabel("Assign Room");
		addRoomtitle.setFont(new Font("Dialog", Font.BOLD, 24));
		addRoomtitle.setBounds(130, 12, 187, 33);
		getContentPane().add(addRoomtitle);
		
		JLabel pricePerNightLabel = new JLabel("Customer ID");
		pricePerNightLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		pricePerNightLabel.setBounds(12, 104, 159, 17);
		getContentPane().add(pricePerNightLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(12, 133, 159, 31);
		getContentPane().add(textField);
		
		JLabel pricePerNightLabel_1 = new JLabel("Customer ID");
		pricePerNightLabel_1.setFont(new Font("Dialog", Font.BOLD, 18));
		pricePerNightLabel_1.setBounds(12, 184, 159, 17);
		getContentPane().add(pricePerNightLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(12, 213, 159, 31);
		getContentPane().add(textField_1);

	}
}
