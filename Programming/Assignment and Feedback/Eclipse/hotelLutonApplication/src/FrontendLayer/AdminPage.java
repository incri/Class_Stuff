package FrontendLayer;

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
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;

@SuppressWarnings("serial")
public class AdminPage extends JFrame {

	private JPanel contentPane;


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
		
		
		JLabel apLogoLabel = new JLabel("");
		apLogoLabel.setIcon(new ImageIcon("/home/vivu/Class_Stuff/Programming/Assignment and Feedback/Eclipse/hotelLutonApplication/Img/LOGO2.png"));
		apLogoLabel.setBounds(340, 12, 90, 80);
		contentPane.add(apLogoLabel);
		
		JLabel aplHotelLutonAdministration = new JLabel("HOTEL LUTON ADMINISTRATION");
		aplHotelLutonAdministration.setFont(new Font("Dialog", Font.BOLD, 28));
		aplHotelLutonAdministration.setBounds(470, 25, 524, 56);
		contentPane.add(aplHotelLutonAdministration);
		
		JPanel upperButtonPanel = new JPanel();
		upperButtonPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		upperButtonPanel.setBounds(12, 120, 1255, 56);
		contentPane.add(upperButtonPanel);
		upperButtonPanel.setLayout(null);
		
		JDesktopPane lowerDesktopPane = new JDesktopPane();
		lowerDesktopPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		lowerDesktopPane.setBounds(12, 199, 704, 436);
		contentPane.add(lowerDesktopPane);
		
		JButton apBtnUsersDetails = new JButton("Users");
		apBtnUsersDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lowerDesktopPane.removeAll();
				UserDetailsTable userTable = new UserDetailsTable();
				userTable.setVisible(true);
				lowerDesktopPane.add(userTable);
				userTable.loadAllUser();
				
			}
		});
		apBtnUsersDetails.setBounds(12, 12, 116, 27);
		upperButtonPanel.add(apBtnUsersDetails);
		
		JButton detailBtnSearch = new JButton("Search");
		detailBtnSearch.setBounds(1135, 12, 105, 32);
		upperButtonPanel.add(detailBtnSearch);
		
		JTextField detailSearchTextField = new JTextField();
		detailSearchTextField.setBounds(845, 12, 258, 32);
		upperButtonPanel.add(detailSearchTextField);
		detailSearchTextField.setColumns(10);
		
		JButton btnRoomDetails = new JButton("Rooms");
		btnRoomDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lowerDesktopPane.removeAll();
				RoomDetailsTable roomTable = new RoomDetailsTable();
				roomTable.setVisible(true);
				lowerDesktopPane.add(roomTable);
				roomTable.loadAllRoom();
				
			}
		});
		btnRoomDetails.setBounds(155, 12, 123, 27);
		upperButtonPanel.add(btnRoomDetails);
		
		JButton btnBooking = new JButton("Booking ");
		btnBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lowerDesktopPane.removeAll();
				BookingDetailsTable bookingTable = new BookingDetailsTable();
				bookingTable.setVisible(true);
				lowerDesktopPane.add(bookingTable);
				bookingTable.loadAllbooking();
				
			}
		});
		btnBooking.setBounds(305, 12, 116, 27);
		upperButtonPanel.add(btnBooking);
		
		JButton btnPayment = new JButton("Payment");
		btnPayment.setBounds(450, 12, 105, 27);
		upperButtonPanel.add(btnPayment);
		
		JDesktopPane sideDesktopPane = new JDesktopPane();
		sideDesktopPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		sideDesktopPane.setBounds(839, 263, 405, 372);
		contentPane.add(sideDesktopPane);
		
		JButton addRoomButton = new JButton("Add Rooms");
		addRoomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sideDesktopPane.removeAll();
				AddRoomPage addRoom = new AddRoomPage();
				addRoom.setVisible(true);
				sideDesktopPane.add(addRoom);
			}
		});
		addRoomButton.setBounds(839, 224, 116, 27);
		contentPane.add(addRoomButton);
		
		JButton roomAsignButton = new JButton("Assign Room");
		roomAsignButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sideDesktopPane.removeAll();
				RoomAssignBox assignBox = new RoomAssignBox();
				sideDesktopPane.add(assignBox);
				assignBox.setVisible(true);
			}
		});
		roomAsignButton.setBounds(989, 224, 128, 27);
		contentPane.add(roomAsignButton);
		
		
		
		
		
		
	}
}