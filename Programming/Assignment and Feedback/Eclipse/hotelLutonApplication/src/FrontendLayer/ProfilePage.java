package FrontendLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DatabaseLayer.BookingDetailsDatabaseLayer;
import DatabaseLayer.UserDatabaseLayer;
import Models.DefultModel;
import ServiceLayer.BookingDetailsServiceLayer;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfilePage extends JFrame {

	private JPanel contentPane;
	private JTable userBookingTable;
	private DefaultTableModel model;

	
	
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
		
		JLabel nameLable = new JLabel("Name :");
		nameLable.setFont(new Font("Dialog", Font.BOLD, 18));
		nameLable.setBounds(34, 185, 82, 35);
		profilePanel.add(nameLable);
		
		JLabel emailLabel = new JLabel("Email :");
		emailLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		emailLabel.setBounds(34, 232, 82, 23);
		profilePanel.add(emailLabel);
		
		JLabel companyNameLabel = new JLabel("Company name :");
		companyNameLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		companyNameLabel.setBounds(34, 279, 168, 23);
		profilePanel.add(companyNameLabel);
		
		JLabel companyContactLebel = new JLabel("Company Contact :");
		companyContactLebel.setFont(new Font("Dialog", Font.BOLD, 18));
		companyContactLebel.setBounds(34, 326, 189, 23);
		profilePanel.add(companyContactLebel);
		
		
		JLabel cusNamelabel = new JLabel(UserDatabaseLayer.nameConcat);
		cusNamelabel.setFont(new Font("Dialog", Font.BOLD, 15));
		cusNamelabel.setForeground(Color.GRAY);
		cusNamelabel.setBounds(112, 195, 270, 17);
		profilePanel.add(cusNamelabel);
		
		JLabel cusEmailLabel = new JLabel(UserDatabaseLayer.userEmail);
		cusEmailLabel.setForeground(Color.GRAY);
		cusEmailLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		cusEmailLabel.setBounds(112, 236, 270, 17);
		profilePanel.add(cusEmailLabel);
		
		JLabel corpNameLabel = new JLabel(UserDatabaseLayer.corpName);
		corpNameLabel.setForeground(Color.GRAY);
		corpNameLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		corpNameLabel.setBounds(195, 283, 258, 17);
		profilePanel.add(corpNameLabel);
		
		JLabel corpContactLabel = new JLabel(UserDatabaseLayer.corpcontact);
		corpContactLabel.setForeground(Color.GRAY);
		corpContactLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		corpContactLabel.setBounds(216, 330, 237, 17);
		profilePanel.add(corpContactLabel);
		
		JDesktopPane lowerDesktopPane = new JDesktopPane();
		lowerDesktopPane.setBounds(597, 315, 595, 237);
		contentPane.add(lowerDesktopPane);
		
		JButton btnEditProfile = new JButton("Edit Profile");
		btnEditProfile.setBounds(34, 374, 105, 27);
		profilePanel.add(btnEditProfile);
		
		JButton btnGenerateBiil = new JButton("Generate Biil");
		btnGenerateBiil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				BillGenerateBox billGenerate = new BillGenerateBox();
				lowerDesktopPane.add(billGenerate);
				billGenerate.setVisible(true);
			}
		});
		btnGenerateBiil.setBounds(161, 374, 135, 27);
		profilePanel.add(btnGenerateBiil);
		
		JButton btnCancelBooking = new JButton("Cancel Booking");
		btnCancelBooking.setBounds(216, 428, 135, 27);
		profilePanel.add(btnCancelBooking);
		
		JButton btnEditBookingDetails = new JButton("Edit Booking Details");
		btnEditBookingDetails.setBounds(34, 428, 168, 27);
		profilePanel.add(btnEditBookingDetails);
		
		JDesktopPane upperDesktopPane = new JDesktopPane();
		upperDesktopPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		upperDesktopPane.setBounds(597, 62, 595, 214);
		contentPane.add(upperDesktopPane);
		upperDesktopPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 50, 568, 152);
		upperDesktopPane.add(scrollPane);
		
		userBookingTable = new JTable();
		scrollPane.setViewportView(userBookingTable);
		
		JLabel lblBookingHistory = new JLabel("Booking History");
		lblBookingHistory.setFont(new Font("Dialog", Font.BOLD, 16));
		lblBookingHistory.setBounds(218, 12, 142, 23);
		upperDesktopPane.add(lblBookingHistory);
		
		
		
		model = new DefaultTableModel();
		Object[] columnsName = new Object[9];
		columnsName[0] = "Booking ID";
		columnsName[1] = "Name";
		columnsName[2] = "Credit Number";
		columnsName[3] = "Prefered Room";
		columnsName[4] = "Check In date";
		columnsName[5] = "Check Out date";
		columnsName[6] = "Booking Status";
		columnsName[7] = "Room No";
		columnsName[8] = "Payment Status";
		
		model.setColumnCount(0);
		model.setColumnIdentifiers(columnsName);
		
	}
	
	public void loadAllUserbooking() {
		try {
			BookingDetailsServiceLayer bookingSL = new BookingDetailsServiceLayer();
			ArrayList<DefultModel> defultModel = bookingSL.getAllUserBooking();
			setTableBookingData(defultModel);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}
	
	private void setTableBookingData(ArrayList<DefultModel> defultModel) {
		// Create the object array from arraylist and add to the table row
		Object[] rowData = new Object[9];
		// set the number of rows in table model to zero
		model.setRowCount(0);
		for(int i=0; i<defultModel.size(); i++) {
			rowData[0] = defultModel.get(i).getBookingID();
			rowData[1] = defultModel.get(i).getName();
			rowData[2] = defultModel.get(i).getCardNumber();
			rowData[3] = defultModel.get(i).getRoomPreference();
			rowData[4] = defultModel.get(i).getCheckInDate();
			rowData[5] = defultModel.get(i).getCheckOutDate();
			rowData[6] = defultModel.get(i).getBookingStatus();
			rowData[7] = defultModel.get(i).getRoomNo();
			rowData[8] = defultModel.get(i).getPaymentStatus();
		
			model.addRow(rowData);
		}
		userBookingTable.setModel(model);

	}
	
	 
}
