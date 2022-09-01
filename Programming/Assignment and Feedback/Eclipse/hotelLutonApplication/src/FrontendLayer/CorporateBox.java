package FrontendLayer;

import java.awt.event.MouseListener;

import javax.swing.JInternalFrame;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import Helper.InputException;
import Models.Corporate;
import Models.Users;
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
		
		BasicInternalFrameUI basicInternalFrameUI = ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI());
		for(MouseListener listener: basicInternalFrameUI.getNorthPane().getMouseListeners()){
			basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
		}
		
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
		CCompanyContactTextField.setColumns(10);
		CCompanyContactTextField.setBounds(129, 52, 145, 21);
		getContentPane().add(CCompanyContactTextField);
		

	}
}
