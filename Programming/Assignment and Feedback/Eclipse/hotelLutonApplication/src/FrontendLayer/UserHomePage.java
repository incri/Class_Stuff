package FrontendLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DatabaseLayer.UserDatabaseLayer;

import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserHomePage extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public UserHomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToHotel = new JLabel("HOTEL LUTON");
		lblWelcomeToHotel.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToHotel.setForeground(Color.BLACK);
		lblWelcomeToHotel.setFont(new Font("Dialog", Font.BOLD, 32));
		lblWelcomeToHotel.setBackground(UIManager.getColor("Button.select"));
		lblWelcomeToHotel.setBounds(456, 12, 356, 69);
		contentPane.add(lblWelcomeToHotel);
		
		JTabbedPane singleRoomTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		singleRoomTabbedPane.setBounds(133, 222, 259, 213);
		contentPane.add(singleRoomTabbedPane);
		
		JLabel singleRoomLabel = new JLabel("");
		singleRoomTabbedPane.addTab("Room", null, singleRoomLabel, null);
		singleRoomLabel.setIcon(new ImageIcon("/home/vivu/Class_Stuff/Programming/Assignment and Feedback/IMAGE/SingleRoom.jpg"));
		
		JLabel sRSwimmingLable = new JLabel("");
		singleRoomTabbedPane.addTab("Pool", null, sRSwimmingLable, null);
		sRSwimmingLable.setIcon(new ImageIcon("/home/vivu/Class_Stuff/Programming/Assignment and Feedback/IMAGE/SwimmingPool.jpg"));
		
		JLabel singleRoomDetailsLabel = new JLabel("<html>Room Type: Single Room<br/>"
				+ "Room Price: 1500/-<br>Room Facilities: Swimming Pool</html>");
		singleRoomTabbedPane.addTab("Details", null, singleRoomDetailsLabel, null);
		singleRoomDetailsLabel.setBackground(Color.CYAN);
		singleRoomDetailsLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		
		JTabbedPane deluxRoomTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		deluxRoomTabbedPane.setBounds(491, 222, 282, 213);
		contentPane.add(deluxRoomTabbedPane);
		
		JLabel deluxRoomLabel = new JLabel("");
		deluxRoomTabbedPane.addTab("Room", null, deluxRoomLabel, null);
		deluxRoomLabel.setIcon(new ImageIcon("/home/vivu/Class_Stuff/Programming/Assignment and Feedback/IMAGE/TwinRoom.jpg"));
		
		JLabel tRSwimming = new JLabel("");
		deluxRoomTabbedPane.addTab("Pool", null, tRSwimming, null);
		tRSwimming.setIcon(new ImageIcon("/home/vivu/Class_Stuff/Programming/Assignment and Feedback/IMAGE/SwimmingPool.jpg"));
		
		JLabel tRBarLabel = new JLabel("");
		deluxRoomTabbedPane.addTab("Bar", null, tRBarLabel, null);
		tRBarLabel.setIcon(new ImageIcon("/home/vivu/Class_Stuff/Programming/Assignment and Feedback/IMAGE/Bar.jpg"));
		
		JLabel deluxRoomDetailsLabel = new JLabel("<html>Room Type: Twin Room<br/>"
				+ "Room Price: 2500/-<br>Room Facilities: Swimming Pool, Bar</html>");
		deluxRoomTabbedPane.addTab("Details", null, deluxRoomDetailsLabel, null);
		deluxRoomDetailsLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		deluxRoomDetailsLabel.setBackground(Color.CYAN);
		
		JTabbedPane doubleRoomTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		doubleRoomTabbedPane.setBounds(879, 222, 259, 213);
		contentPane.add(doubleRoomTabbedPane);
		
		JLabel doubleRoomLabel = new JLabel("");
		doubleRoomTabbedPane.addTab("Room", null, doubleRoomLabel, null);
		doubleRoomLabel.setIcon(new ImageIcon("/home/vivu/Class_Stuff/Programming/Assignment and Feedback/IMAGE/DoubleRoom.jpg"));
		
		JLabel doRSwimmingLabel = new JLabel("");
		doubleRoomTabbedPane.addTab("Pool", null, doRSwimmingLabel, null);
		doRSwimmingLabel.setIcon(new ImageIcon("/home/vivu/Class_Stuff/Programming/Assignment and Feedback/IMAGE/SwimmingPool.jpg"));
		
		JLabel dorBarLabel = new JLabel("");
		doubleRoomTabbedPane.addTab("Bar", null, dorBarLabel, null);
		dorBarLabel.setIcon(new ImageIcon("/home/vivu/Class_Stuff/Programming/Assignment and Feedback/IMAGE/Bar.jpg"));
		
		JLabel dorSpaLabel = new JLabel("");
		doubleRoomTabbedPane.addTab("Spa", null, dorSpaLabel, null);
		dorSpaLabel.setIcon(new ImageIcon("/home/vivu/Class_Stuff/Programming/Assignment and Feedback/Eclipse/hotelLutonApplication/Img/Spa.jpg"));
		
		JLabel doubleRoomDetailsLabel = new JLabel("<html>Room Type: Double Room<br/>Room Price: 3500/-<br>"
				+ "Room Facilities: Swimming Pool, Bar , Spa</html>");
		doubleRoomTabbedPane.addTab("Details", null, doubleRoomDetailsLabel, null);
		doubleRoomDetailsLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		doubleRoomDetailsLabel.setBackground(Color.CYAN);
		
		JLabel logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon("/home/vivu/Class_Stuff/Programming/Assignment and Feedback/Eclipse/hotelLutonApplication/Img/LOGO.png"));
		logoLabel.setBounds(12, 0, 135, 115);
		contentPane.add(logoLabel);
		
		JLabel lblRooms = new JLabel("Rooms and facilities");
		lblRooms.setFont(new Font("Dialog", Font.BOLD, 18));
		lblRooms.setBounds(133, 171, 191, 17);
		contentPane.add(lblRooms);
		
		JLabel lblSingleRoom = new JLabel("Single Room");
		lblSingleRoom.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSingleRoom.setBounds(133, 458, 191, 17);
		contentPane.add(lblSingleRoom);
		
		JLabel lblTwinRooms = new JLabel("Twin Room");
		lblTwinRooms.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTwinRooms.setBounds(491, 460, 191, 17);
		contentPane.add(lblTwinRooms);
		
		JLabel lblDoubleRooms = new JLabel("Double Room");
		lblDoubleRooms.setFont(new Font("Dialog", Font.BOLD, 18));
		lblDoubleRooms.setBounds(879, 460, 191, 17);
		contentPane.add(lblDoubleRooms);
		
		JButton btnBookNow = new JButton("BOOK NOW");
		btnBookNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				BookingFormPage form = new BookingFormPage();
				form.setVisible(true);
			}
			
		});
		btnBookNow.setForeground(Color.WHITE);
		btnBookNow.setBackground(Color.RED);
		btnBookNow.setBounds(553, 548, 144, 45);
		contentPane.add(btnBookNow);
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProfilePage profile = new ProfilePage();
				profile.setVisible(true);
			}
		});
		btnProfile.setBackground(Color.LIGHT_GRAY);
		btnProfile.setBounds(1119, 98, 105, 27);
		contentPane.add(btnProfile);
		
		JLabel userNameLabel = new JLabel(UserDatabaseLayer.uName);
		userNameLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		userNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		userNameLabel.setBounds(966, 98, 135, 27);
		contentPane.add(userNameLabel);
	}
}
