package FrontendLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class AdminPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920,1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel liLogoLabel = new JLabel("");
		Image logo = new ImageIcon(this.getClass().getResource("/LOGO2.png")).getImage();
		liLogoLabel.setIcon(new ImageIcon(logo));
		liLogoLabel.setBounds(340, 12, 90, 80);
		contentPane.add(liLogoLabel);
		
		JLabel lblHotelLutonAdministration = new JLabel("HOTEL LUTON ADMINISTRATION");
		lblHotelLutonAdministration.setFont(new Font("Dialog", Font.BOLD, 28));
		lblHotelLutonAdministration.setBounds(470, 25, 524, 56);
		contentPane.add(lblHotelLutonAdministration);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(12, 119, 1268, 56);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnUserDetails = new JButton("Users");
		btnUserDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SignUp signUp = new SignUp();
				signUp.loadAllUser();
			}
			
		});
		btnUserDetails.setBounds(12, 12, 116, 27);
		panel.add(btnUserDetails);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(1135, 12, 105, 32);
		panel.add(btnSearch);
		
		textField = new JTextField();
		textField.setBounds(845, 12, 258, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnRoomDetails = new JButton("Rooms");
		btnRoomDetails.setBounds(155, 12, 123, 27);
		panel.add(btnRoomDetails);
		
		JButton btnBooking = new JButton("Booking ");
		btnBooking.setBounds(305, 12, 116, 27);
		panel.add(btnBooking);
		
		JButton btnPayment = new JButton("Payment");
		btnPayment.setBounds(450, 12, 105, 27);
		panel.add(btnPayment);
		
		
	}
}
