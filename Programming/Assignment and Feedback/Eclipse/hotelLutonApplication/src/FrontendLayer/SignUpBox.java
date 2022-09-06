package FrontendLayer;

import java.awt.Color;





import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import Helper.InputException;
import Models.Corporate;
import Models.Customer;
import Models.Users;
import ServiceLayer.CorporateServiceLayer;
import ServiceLayer.CustomerServiceLayer;
import ServiceLayer.UserServiceLayer;
import javax.swing.JCheckBox;

public class SignUpBox extends JInternalFrame {
	private JTextField siFirstTextField;
	private JTextField siLastTextField;
	private JTextField siEmailTextField;
	private JTextField siUsersNameTextField;
	private JPasswordField siPasswordPassField;
	private JPasswordField siConfirmPasswordPassField;
	public JCheckBox corporateCheckBox;
	public JDesktopPane coDesktopPane;
	/**
	 * Create the frame.
	 */
	public SignUpBox() {
		setTitle("SignUpBox");
		setVisible(true);
		setClosable(true);
		setBounds(0, 0, 560, 571);
		getContentPane().setLayout(null);
		
		BasicInternalFrameUI basicInternalFrameUI = ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI());
		for(MouseListener listener: basicInternalFrameUI.getNorthPane().getMouseListeners()){
			basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
			
		}
		
		JLabel signTitle = new JLabel("REGISTER TO LUTON");
		signTitle.setFont(new Font("Dialog", Font.BOLD, 28));
		signTitle.setBounds(145, 26, 292, 31);
		getContentPane().add(signTitle);		
		
		JLabel siLogoLabel = new JLabel("");
		siLogoLabel.setIcon(new ImageIcon("/home/vivu/Class_Stuff/Programming/Assignment and Feedback/Eclipse/hotelLutonApplication/Img/LOGO2.png"));
		siLogoLabel.setBounds(31, 12, 90, 80);
		getContentPane().add(siLogoLabel);
		
		JLabel signInMess = new JLabel("Welcome to Luton Family");
		signInMess.setFont(new Font("Dialog", Font.BOLD, 18));
		signInMess.setBounds(166, 79, 228, 17);
		getContentPane().add(signInMess);
		
		JPanel signInPanel = new JPanel();
		signInPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		signInPanel.setBounds(12, 130, 526, 407);
		getContentPane().add(signInPanel);
		signInPanel.setLayout(null);
		
		JLabel siFirstLabel = new JLabel("First Name");
		siFirstLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		siFirstLabel.setBounds(12, 28, 179, 17);
		signInPanel.add(siFirstLabel);
		
		JLabel siLastLabel = new JLabel("Last Name");
		siLastLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		siLastLabel.setBounds(299, 28, 198, 17);
		signInPanel.add(siLastLabel);
		
		siFirstTextField = new JTextField();
		siFirstTextField.setColumns(10);
		siFirstTextField.setBounds(12, 57, 215, 31);
		signInPanel.add(siFirstTextField);
		
		siLastTextField = new JTextField();
		siLastTextField.setColumns(10);
		siLastTextField.setBounds(299, 57, 215, 31);
		signInPanel.add(siLastTextField);
		
		JLabel siEmailAddreessLabel = new JLabel("Email");
		siEmailAddreessLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		siEmailAddreessLabel.setBounds(12, 113, 179, 17);
		signInPanel.add(siEmailAddreessLabel);
		
		JLabel siUsersNameLabel = new JLabel("Users Name");
		siUsersNameLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		siUsersNameLabel.setBounds(299, 115, 179, 17);
		signInPanel.add(siUsersNameLabel);
		
		siEmailTextField = new JTextField();
		siEmailTextField.setColumns(10);
		siEmailTextField.setBounds(12, 143, 215, 31);
		signInPanel.add(siEmailTextField);
		
		siUsersNameTextField = new JTextField();
		siUsersNameTextField.setColumns(10);
		siUsersNameTextField.setBounds(299, 143, 215, 31);
		signInPanel.add(siUsersNameTextField);
		
		JLabel siPasswordLabel = new JLabel("Password");
		siPasswordLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		siPasswordLabel.setBounds(12, 195, 179, 17);
		signInPanel.add(siPasswordLabel);
		
		siPasswordPassField = new JPasswordField();
		siPasswordPassField.setColumns(10);
		siPasswordPassField.setBounds(12, 225, 215, 31);
		signInPanel.add(siPasswordPassField);
		
		
		JButton btnSignup = new JButton("SIGNUP");
		btnSignup.setBounds(12, 356, 115, 39);
		signInPanel.add(btnSignup);
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				register();
		
			}
		});
		
		
		coDesktopPane = new JDesktopPane();
		
		coDesktopPane.setBackground(SystemColor.scrollbar);
		coDesktopPane.setBounds(218, 278, 296, 117);
		signInPanel.add(coDesktopPane);
		
		corporateCheckBox = new JCheckBox("As Corporate");
		corporateCheckBox.setBounds(12, 278, 115, 27);
		signInPanel.add(corporateCheckBox);
		
		JButton btnCorporateButton = new JButton("Add Company Details");
		btnCorporateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(corporateCheckBox.isSelected()) {
					coDesktopPane.removeAll();
					CorporateBox corporate = new CorporateBox();
					corporate.setVisible(true);
					coDesktopPane.add(corporate);
				}
			}	
		});
		btnCorporateButton.setBounds(12, 317, 179, 27);
		signInPanel.add(btnCorporateButton);	
		
		JLabel siConfirmPasswordTextField = new JLabel("Confirm Password");
		siConfirmPasswordTextField.setFont(new Font("Dialog", Font.BOLD, 18));
		siConfirmPasswordTextField.setBounds(299, 197, 179, 17);
		signInPanel.add(siConfirmPasswordTextField);
		
		siConfirmPasswordPassField = new JPasswordField();
		siConfirmPasswordPassField.setColumns(10);
		siConfirmPasswordPassField.setBounds(299, 225, 215, 31);
		signInPanel.add(siConfirmPasswordPassField);
		
		
	}
	
	
	
	private void register() {
		// On click of the save button
		// Read data from the fields and store it in the model
		// Create an object of Business Layer and pass the model to business layer
		// Perform the required action from the business layer.
		try {
			Users user = new Users();
			user.setEmail(siEmailTextField.getText());
			user.setUserName(siUsersNameTextField.getText());
			user.setPassword(String.valueOf(siPasswordPassField.getPassword()));
			user.setConfirmPassword(String.valueOf(siConfirmPasswordPassField.getPassword()));
			
			Customer customer = new Customer();
			customer.setFirstName(siFirstTextField.getText());
			customer.setLastName(siLastTextField.getText());
			
			
			
			UserServiceLayer userSL = new UserServiceLayer();
			CustomerServiceLayer customerSL = new CustomerServiceLayer();
			CorporateServiceLayer corporateSL = new CorporateServiceLayer();
			
			if(corporateCheckBox.isSelected()) {
				
				Corporate corporate = new Corporate();
				corporate.setCompanyName(CorporateBox.CCompanyNameTextField.getText());
				corporate.setCompanyContact(CorporateBox.CCompanyContactTextField.getText());
				
				if(userSL.ValidateSignup(user) && customerSL.ValidateCustomer(customer) && corporateSL.ValidateCorporate(corporate))  {
					user = userSL.userSave(user);
					customer = customerSL.customerSave(customer);
					corporate = corporateSL.corporateSave(corporate);
				}
			}
			 else {
				if(userSL.ValidateSignup(user) && customerSL.ValidateCustomer(customer))  {
					user = userSL.userSave(user);
					customer = customerSL.customerSave(customer);
				}
			}
		}
		catch(InputException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Complete your information");
		}
	}
	
	}

	