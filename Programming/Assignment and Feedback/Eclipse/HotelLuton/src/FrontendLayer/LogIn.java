package FrontendLayer;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LogIn extends JInternalFrame {
	private JTextField liEmailAddreessTextField;
	private JPasswordField liPasswordPassField;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public LogIn() {
		setTitle("LogIn");
		setClosable(true);
		setBounds(0, 0, 560, 571);
		getContentPane().setLayout(null);
		
		JLabel logTitle = new JLabel("LOGIN TO LUTON");
		logTitle.setFont(new Font("Dialog", Font.BOLD, 28));
		logTitle.setBounds(145, 26, 249, 19);
		getContentPane().add(logTitle);
		
		JLabel liLogoLabel = new JLabel("");
		Image logo = new ImageIcon(this.getClass().getResource("/LOGO2.png")).getImage();
		liLogoLabel.setIcon(new ImageIcon(logo));
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
		
		JLabel liEmailAddreessLabel = new JLabel("User Name");
		liEmailAddreessLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		liEmailAddreessLabel.setBounds(31, 48, 166, 17);
		logInPanel.add(liEmailAddreessLabel);
		
		liEmailAddreessTextField = new JTextField();
		liEmailAddreessTextField.setBounds(31, 88, 304, 31);
		logInPanel.add(liEmailAddreessTextField);
		liEmailAddreessTextField.setColumns(10);
		
		JLabel liPasswordLabel = new JLabel("Password");
		liPasswordLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		liPasswordLabel.setBounds(31, 149, 166, 17);
		logInPanel.add(liPasswordLabel);
		
		liPasswordPassField = new JPasswordField();
		liPasswordPassField.setColumns(10);
		liPasswordPassField.setBounds(31, 189, 304, 31);
		logInPanel.add(liPasswordPassField);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(117, 262, 105, 27);
		logInPanel.add(btnLogin);

	}
}
