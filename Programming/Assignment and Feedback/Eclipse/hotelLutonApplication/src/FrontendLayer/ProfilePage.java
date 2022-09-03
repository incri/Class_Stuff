package FrontendLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import DatabaseLayer.UserDatabaseLayer;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class ProfilePage extends JFrame {

	private JPanel contentPane;

	
	
	public ProfilePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920,1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel profilePanel = new JPanel();
		profilePanel.setBorder(new LineBorder(new Color(192, 192, 192), 2, true));
		profilePanel.setBounds(51, 62, 465, 490);
		contentPane.add(profilePanel);
		profilePanel.setLayout(null);
		
		JLabel profilePictureLable = new JLabel("");
		profilePictureLable.setIcon(new ImageIcon("/home/vivu/Class_Stuff/Programming/Assignment and Feedback/Eclipse/hotelLutonApplication/Img/LOGO.png"));
		profilePictureLable.setBounds(161, 30, 135, 105);
		profilePanel.add(profilePictureLable);
		
		JLabel userNameLabel = new JLabel(UserDatabaseLayer.uName);
		userNameLabel.setForeground(Color.GRAY);
		userNameLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		userNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userNameLabel.setBounds(132, 130, 189, 37);
		profilePanel.add(userNameLabel);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Dialog", Font.BOLD, 18));
		lblName.setBounds(34, 185, 82, 35);
		profilePanel.add(lblName);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 18));
		lblEmail.setBounds(34, 232, 82, 23);
		profilePanel.add(lblEmail);
		
		JLabel lblCompanyName = new JLabel("Company name :");
		lblCompanyName.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCompanyName.setBounds(34, 279, 168, 23);
		profilePanel.add(lblCompanyName);
		
		JLabel lblCompanyContact = new JLabel("Company Contact :");
		lblCompanyContact.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCompanyContact.setBounds(34, 326, 189, 23);
		profilePanel.add(lblCompanyContact);
		
		JLabel lblName_3_1 = new JLabel("Booking :");
		lblName_3_1.setFont(new Font("Dialog", Font.BOLD, 18));
		lblName_3_1.setBounds(34, 369, 104, 23);
		profilePanel.add(lblName_3_1);
		
		JLabel lblBaibhavPaudel = new JLabel("Baibhav Paudel");
		lblBaibhavPaudel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblBaibhavPaudel.setForeground(Color.GRAY);
		lblBaibhavPaudel.setBounds(112, 195, 270, 17);
		profilePanel.add(lblBaibhavPaudel);
		
		JLabel lblBaibhavPaudel_1 = new JLabel("Baibhav Paudel");
		lblBaibhavPaudel_1.setForeground(Color.GRAY);
		lblBaibhavPaudel_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblBaibhavPaudel_1.setBounds(112, 236, 270, 17);
		profilePanel.add(lblBaibhavPaudel_1);
		
		JLabel lblBaibhavPaudel_2 = new JLabel("Baibhav Paudel");
		lblBaibhavPaudel_2.setForeground(Color.GRAY);
		lblBaibhavPaudel_2.setFont(new Font("Dialog", Font.BOLD, 15));
		lblBaibhavPaudel_2.setBounds(195, 283, 258, 17);
		profilePanel.add(lblBaibhavPaudel_2);
		
		JLabel lblBaibhavPaudel_3 = new JLabel("Baibhav Paudel");
		lblBaibhavPaudel_3.setForeground(Color.GRAY);
		lblBaibhavPaudel_3.setFont(new Font("Dialog", Font.BOLD, 15));
		lblBaibhavPaudel_3.setBounds(216, 330, 237, 17);
		profilePanel.add(lblBaibhavPaudel_3);
		
		JLabel lblBaibhavPaudel_3_1 = new JLabel("Baibhav Paudel");
		lblBaibhavPaudel_3_1.setForeground(Color.GRAY);
		lblBaibhavPaudel_3_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblBaibhavPaudel_3_1.setBounds(132, 374, 237, 17);
		profilePanel.add(lblBaibhavPaudel_3_1);
		
		JButton btnEditProfile = new JButton("Edit Profile");
		btnEditProfile.setBounds(34, 428, 105, 27);
		profilePanel.add(btnEditProfile);
		
		JButton btnGenerateBiil = new JButton("Generate Biil");
		btnGenerateBiil.setBounds(318, 428, 135, 27);
		profilePanel.add(btnGenerateBiil);
		
		JButton btnCancelBooking = new JButton("Cancel Booking");
		btnCancelBooking.setBounds(161, 428, 135, 27);
		profilePanel.add(btnCancelBooking);
	}
}
