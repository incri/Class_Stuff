package FrontendLayer;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Corporate extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Corporate() {
		
		setTitle("Company Detail");
		setClosable(true);
		setBounds(0, 0, 329, 117);
		getContentPane().setLayout(null);
		
		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setBounds(12, 12, 96, 17);
		getContentPane().add(lblCompanyName);
		
		JLabel lblCompanyContact = new JLabel("Company Contact");
		lblCompanyContact.setBounds(12, 54, 116, 17);
		getContentPane().add(lblCompanyContact);
		
		textField = new JTextField();
		textField.setBounds(129, 10, 175, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(129, 52, 175, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

	}
}
