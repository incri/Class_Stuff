package FrontendLayer;

import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;


import Helper.InputException;
import Models.Users;
import ServiceLayer.UserServiceLayer;

@SuppressWarnings("serial")
public class LogInBox extends JInternalFrame {
	public JTextField liUserNameTextField;
	public JPasswordField liPasswordPassField;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public LogInBox() {
		setTitle("LogIn");
		setClosable(true);
		setBounds(0, 0, 560, 571);
		getContentPane().setLayout(null);
		setVisible(true);
		
		BasicInternalFrameUI basicInternalFrameUI = ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI());
		for(MouseListener listener: basicInternalFrameUI.getNorthPane().getMouseListeners()){
			basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
		}
		
		JLabel logTitle = new JLabel("LOGIN TO LUTON");
		logTitle.setFont(new Font("Dialog", Font.BOLD, 28));
		logTitle.setBounds(145, 26, 249, 19);
		getContentPane().add(logTitle);
		
		JLabel liLogoLabel = new JLabel("");
		liLogoLabel.setIcon(new ImageIcon("/home/vivu/Class_Stuff/Programming/Assignment and Feedback/Eclipse/hotelLutonApplication/Img/LOGO2.png"));
		liLogoLabel.setBounds(43, 0, 90, 80);
		getContentPane().add(liLogoLabel);
		
		JLabel logInMess = new JLabel("Welcome Back User");
		logInMess.setFont(new Font("Dialog", Font.BOLD, 18));
		logInMess.setBounds(186, 121, 191, 17);
		getContentPane().add(logInMess);
		
		JPanel logInPanel = new JPanel();
		logInPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		logInPanel.setBounds(94, 164, 373, 340);
		getContentPane().add(logInPanel);
		logInPanel.setLayout(null);
		
		JLabel liUserNameLabel = new JLabel("User Name");
		liUserNameLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		liUserNameLabel.setBounds(31, 48, 166, 17);
		logInPanel.add(liUserNameLabel);
		
		liUserNameTextField = new JTextField();
		liUserNameTextField.setBounds(31, 88, 304, 31);
		logInPanel.add(liUserNameTextField);
		liUserNameTextField.setColumns(10);
		
		JLabel liPasswordLabel = new JLabel("Password");
		liPasswordLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		liPasswordLabel.setBounds(31, 149, 166, 17);
		logInPanel.add(liPasswordLabel);
		
		liPasswordPassField = new JPasswordField();
		liPasswordPassField.setColumns(10);
		liPasswordPassField.setBounds(31, 189, 304, 31);
		logInPanel.add(liPasswordPassField);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userLogIn();
				
			}
		});
		btnLogin.setBounds(117, 262, 105, 27);
		logInPanel.add(btnLogin);	
		
		
	}
	public JTextField getLiUserNameTextField() {
		return liUserNameTextField;
	}


	public void setLiUserNameTextField(JTextField liUserNameTextField) {
		this.liUserNameTextField = liUserNameTextField;
	}


	public JPasswordField getLiPasswordPassField() {
		return liPasswordPassField;
	}


	public void setLiPasswordPassField(JPasswordField liPasswordPassField) {
		this.liPasswordPassField = liPasswordPassField;
	}


	
	private void userLogIn() {
		// On click of the log In button
		// It fetch the data from the field
		// Create an object of Service Layer and pass the model to Service layer
		// Perform the required action from the Service layer.
		try {
			Users user = new Users();
			user.setUserName(liUserNameTextField.getText());
			user.setPassword(String.valueOf(liPasswordPassField.getPassword()));
			
			
			UserServiceLayer userSL = new UserServiceLayer();
			userSL.ValidateLogIn(user);
			userSL.userLogIn(user);
			
			
		}
		catch(InputException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
			
	}
	
}
