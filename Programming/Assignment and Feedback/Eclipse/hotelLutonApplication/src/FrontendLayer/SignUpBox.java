package FrontendLayer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class SignUpBox extends JInternalFrame {
	private JTextField siFirstTextField;
	private JTextField siLastTextField;
	private JTextField siEmailTextField;
	private JTextField siUsersNameTextField;
	private JPasswordField siPasswordPassField;
	/**
	 * Create the frame.
	 */
	public SignUpBox() {
		setTitle("SignUpBox");
		setClosable(true);
		setBounds(0, 0, 560, 571);
		getContentPane().setLayout(null);
		
		JLabel signTitle = new JLabel("REGISTER TO LUTON");
		signTitle.setFont(new Font("Dialog", Font.BOLD, 28));
		signTitle.setBounds(145, 26, 292, 31);
		getContentPane().add(signTitle);
		
		JLabel siLogoLabel = new JLabel("");
		Image logo = new ImageIcon(this.getClass().getResource("/LOGO.png")).getImage();
		siLogoLabel.setIcon(new ImageIcon(logo));
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
		
		JLabel siUsersNameLabel_3 = new JLabel("Users Name");
		siUsersNameLabel_3.setFont(new Font("Dialog", Font.BOLD, 18));
		siUsersNameLabel_3.setBounds(299, 115, 179, 17);
		signInPanel.add(siUsersNameLabel_3);
		
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
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnSignup.setBounds(36, 329, 115, 39);
		signInPanel.add(btnSignup);
		
		
		JDesktopPane coDesktopPane = new JDesktopPane();
		coDesktopPane.setBackground(SystemColor.scrollbar);
		coDesktopPane.setBounds(185, 278, 329, 117);
		signInPanel.add(coDesktopPane);
		
		JButton btnNewButton = new JButton("As corporate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Corporate corporate = new Corporate();
				corporate.setVisible(true);
				coDesktopPane.add(corporate);
			}
			
			
		});
		btnNewButton.setBounds(272, 227, 132, 27);
		signInPanel.add(btnNewButton);
		
		
	}

}
