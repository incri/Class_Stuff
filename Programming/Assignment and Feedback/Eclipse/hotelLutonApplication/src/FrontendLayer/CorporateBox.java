package FrontendLayer;

import javax.swing.JInternalFrame;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Helper.InputException;
import Models.Corporate;
import ServiceLayer.CorporateServiceLayer;




@SuppressWarnings("serial")
public class CorporateBox extends JInternalFrame {
	static JTextField CCompanyNameTextField;
	static JTextField CCompanyContactTextField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public CorporateBox() {
		
		setTitle("Company Detail");
		setClosable(true);
		setBounds(0, 0, 296, 117);
		getContentPane().setLayout(null);
		
		JLabel CCompanyNameLabel = new JLabel("Company Name");
		CCompanyNameLabel.setBounds(12, 12, 96, 17);
		getContentPane().add(CCompanyNameLabel);
		
		JLabel CCompanyContactLabel = new JLabel("Company Contact");
		CCompanyContactLabel.setBounds(12, 54, 116, 17);
		getContentPane().add(CCompanyContactLabel);
		
		CCompanyNameTextField = new JTextField();
		CCompanyNameTextField.setBounds(129, 10, 145, 21);
		getContentPane().add(CCompanyNameTextField);
		CCompanyNameTextField.setColumns(10);
		
		CCompanyContactTextField = new JTextField();
		CCompanyContactTextField.setBounds(129, 52, 145, 21);
		getContentPane().add(CCompanyContactTextField);
		CCompanyContactTextField.setColumns(10);

	}
	
	public static void saveCorporate() {
		// On click of the save button
		// Read data from the fields and store it in the model
		// Create an object of Business Layer and pass the model to business layer
		// Perform the required action from the business layer.
		try {
			Corporate corporate = new Corporate();
			corporate.setCompanyName(CCompanyNameTextField.getText());
			corporate.setCompanyContact(CCompanyContactTextField.getText());
			
			SignUpBox signup = new SignUpBox();
			CorporateServiceLayer CorporateSL = new CorporateServiceLayer();
			CorporateSL.setCorporate(corporate);
			corporate = CorporateSL.corporateSave(corporate);
		}
		catch(InputException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	
	  
}
