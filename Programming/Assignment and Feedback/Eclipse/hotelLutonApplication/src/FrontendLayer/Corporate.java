package FrontendLayer;

import javax.swing.JInternalFrame;

import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Corporate extends JInternalFrame {
	JTextField CCompanyNameTextField;
	JTextField CCompanyContactTextField;

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
		
		JLabel CCompanyNameLabel = new JLabel("Company Name");
		CCompanyNameLabel.setBounds(12, 12, 96, 17);
		getContentPane().add(CCompanyNameLabel);
		
		JLabel CCompanyContactLabel = new JLabel("Company Contact");
		CCompanyContactLabel.setBounds(12, 54, 116, 17);
		getContentPane().add(CCompanyContactLabel);
		
		CCompanyNameTextField = new JTextField();
		CCompanyNameTextField.setBounds(129, 10, 175, 21);
		getContentPane().add(CCompanyNameTextField);
		CCompanyNameTextField.setColumns(10);
		
		CCompanyContactTextField = new JTextField();
		CCompanyContactTextField.setBounds(129, 52, 175, 21);
		getContentPane().add(CCompanyContactTextField);
		CCompanyContactTextField.setColumns(10);

	}
	
}
