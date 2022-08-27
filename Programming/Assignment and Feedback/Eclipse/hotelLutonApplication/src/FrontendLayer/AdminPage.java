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

@SuppressWarnings("serial")
public class AdminPage extends JFrame {

	private JPanel contentPane;
	private JTable userDatatable;

	/**
	 * Launch the application.
	 */

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
		Image logo = new ImageIcon(this.getClass().getResource("/LOGO2.png")).getImage();
		apLogoLabel.setIcon(new ImageIcon(logo));
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
		
		JButton apBtnUsersDetails = new JButton("Users");
		apBtnUsersDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
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
		btnRoomDetails.setBounds(155, 12, 123, 27);
		upperButtonPanel.add(btnRoomDetails);
		
		JButton btnBooking = new JButton("Booking ");
		btnBooking.setBounds(305, 12, 116, 27);
		upperButtonPanel.add(btnBooking);
		
		JButton btnPayment = new JButton("Payment");
		btnPayment.setBounds(450, 12, 105, 27);
		upperButtonPanel.add(btnPayment);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 223, 841, 412);
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		contentPane.add(scrollPane);
		
		userDatatable = new JTable();
		userDatatable.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		scrollPane.setViewportView(userDatatable);
		
		
		
	}
}