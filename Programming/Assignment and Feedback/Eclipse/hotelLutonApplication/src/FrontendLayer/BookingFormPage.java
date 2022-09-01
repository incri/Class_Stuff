package FrontendLayer;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import DatabaseLayer.UserDatabaseLayer;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

import Helper.InputException;
import Models.CreditCard;
import Models.GuestData;
import Models.Reservation;
import ServiceLayer.CreditServiceLayer;
import ServiceLayer.GuestServiceLayer;
import ServiceLayer.ReserveServiceLayer;

import javax.swing.JCheckBox;

public class BookingFormPage extends JFrame {

	private JPanel contentPane;
	private JTextField fullNameTextField;
	private JTextField contactTextField;
	private JTextField roomPreferenceTextField;
	private JTextField countryTextField;
	private JTextField cityTextField;
	private JTextField stateTextField;
	private JTextField dOBTextField;
	private JTextField checkInDateTextField;
	private JTextField checkOutDateTextField;
	private JCheckBox creditCardChckbx;
	

	/**
	 * Launch the application.
	 */
	
	public BookingFormPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon("/home/vivu/Class_Stuff/Programming/Assignment and Feedback/Eclipse/hotelLutonApplication/Img/LOGO.png"));
		logoLabel.setBounds(12, 0, 135, 115);
		contentPane.add(logoLabel);
		
		JLabel lblReservationFom = new JLabel("Reservation Form");
		lblReservationFom.setHorizontalAlignment(SwingConstants.CENTER);
		lblReservationFom.setForeground(Color.BLACK);
		lblReservationFom.setFont(new Font("Dialog", Font.BOLD, 32));
		lblReservationFom.setBackground(UIManager.getColor("Button.select"));
		lblReservationFom.setBounds(411, 21, 570, 69);
		contentPane.add(lblReservationFom);
		
		JPanel detailsPanel = new JPanel();
		detailsPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		detailsPanel.setBounds(375, 92, 636, 546);
		contentPane.add(detailsPanel);
		detailsPanel.setLayout(null);
		
		JLabel lblGuestDetails = new JLabel("Guest Details");
		lblGuestDetails.setBounds(260, 33, 120, 26);
		lblGuestDetails.setFont(new Font("Dialog", Font.BOLD, 18));
		detailsPanel.add(lblGuestDetails);
		
		
		JLabel fullnameLabel = new JLabel("Full Name");
		fullnameLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		fullnameLabel.setBounds(26, 95, 179, 17);
		detailsPanel.add(fullnameLabel);
		
		fullNameTextField = new JTextField();
		fullNameTextField.setColumns(10);
		fullNameTextField.setBounds(26, 124, 215, 31);
		detailsPanel.add(fullNameTextField);
		
		
		JLabel birthDateLabel = new JLabel("Date Of Birth");
		birthDateLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		birthDateLabel.setBounds(397, 95, 179, 17);
		detailsPanel.add(birthDateLabel);
		
		JLabel contactLabel = new JLabel("Contact");
		contactLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		contactLabel.setBounds(26, 177, 179, 17);
		detailsPanel.add(contactLabel);
		
		contactTextField = new JTextField();
		contactTextField.setColumns(10);
		contactTextField.setBounds(26, 206, 215, 31);
		detailsPanel.add(contactTextField);
		
		
		JLabel roomPrefLabel = new JLabel("Room Preference");
		roomPrefLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		roomPrefLabel.setBounds(397, 177, 179, 17);
		detailsPanel.add(roomPrefLabel);
		
		roomPreferenceTextField = new JTextField();
		roomPreferenceTextField.setColumns(10);
		roomPreferenceTextField.setBounds(397, 206, 215, 31);
		detailsPanel.add(roomPreferenceTextField);
		
		JLabel countryLabel = new JLabel("Country");
		countryLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		countryLabel.setBounds(26, 260, 179, 17);
		detailsPanel.add(countryLabel);
		
		JLabel stateLabel = new JLabel("State");
		stateLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		stateLabel.setBounds(250, 260, 179, 17);
		detailsPanel.add(stateLabel);
		
		JLabel cityLabel = new JLabel("City");
		cityLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		cityLabel.setBounds(457, 260, 131, 17);
		detailsPanel.add(cityLabel);
		
		countryTextField = new JTextField();
		countryTextField.setColumns(10);
		countryTextField.setBounds(26, 289, 153, 31);
		detailsPanel.add(countryTextField);
		
		cityTextField = new JTextField();
		cityTextField.setColumns(10);
		cityTextField.setBounds(457, 289, 153, 31);
		detailsPanel.add(cityTextField);
		
		stateTextField = new JTextField();
		stateTextField.setColumns(10);
		stateTextField.setBounds(239, 289, 153, 31);
		detailsPanel.add(stateTextField);
		
		
		JLabel checkInLabel = new JLabel("Check In Date");
		checkInLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		checkInLabel.setBounds(26, 343, 179, 17);
		detailsPanel.add(checkInLabel);
		
		JLabel checkOutLabel = new JLabel("Check Out Date");
		checkOutLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		checkOutLabel.setBounds(277, 343, 179, 17);
		detailsPanel.add(checkOutLabel);
		
		
		
		JButton btnBookNow = new JButton("Book Now");
		btnBookNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guestDetails();
			}
		});
		btnBookNow.setForeground(Color.WHITE);
		btnBookNow.setBackground(Color.RED);
		btnBookNow.setBounds(229, 489, 198, 31);
		detailsPanel.add(btnBookNow);
		
		JDesktopPane creditDesktopPane = new JDesktopPane();
		creditDesktopPane.setBounds(47, 322, 316, 316);
		contentPane.add(creditDesktopPane);
		
		JButton btnAdd = new JButton("ADD ");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(creditCardChckbx.isSelected()) {
					creditDesktopPane.removeAll();
					CardDetailBox cardDetails = new CardDetailBox();
					cardDetails.setVisible(true);
					creditDesktopPane.add(cardDetails);
				}
				
			}
		});
		btnAdd.setBounds(26, 454, 129, 27);
		detailsPanel.add(btnAdd);
		
		dOBTextField = new JTextField();
		dOBTextField.setColumns(10);
		dOBTextField.setBounds(397, 124, 215, 31);
		detailsPanel.add(dOBTextField);
		
		checkInDateTextField = new JTextField();
		checkInDateTextField.setColumns(10);
		checkInDateTextField.setBounds(26, 372, 215, 31);
		detailsPanel.add(checkInDateTextField);
		
		checkOutDateTextField = new JTextField();
		checkOutDateTextField.setColumns(10);
		checkOutDateTextField.setBounds(277, 372, 215, 31);
		detailsPanel.add(checkOutDateTextField);
		
		creditCardChckbx = new JCheckBox("Credit Card Details");
		creditCardChckbx.setBounds(26, 422, 153, 25);
		detailsPanel.add(creditCardChckbx);
		
		
		
	}
	
	private void guestDetails() {
		// On click of the save button
		// Read data from the fields and store it in the model
		// Create an object of Business Layer and pass the model to business layer
		// Perform the required action from the business layer.
		try {
			
			GuestData guest = new GuestData();
			Reservation reserve = new Reservation();
			
			guest.setFullName(fullNameTextField.getText());
			guest.setdOB(dOBTextField.getText());
			guest.setContact(contactTextField.getText());
			guest.setRoomPreference(roomPreferenceTextField.getText());
			guest.setCountry(countryTextField.getText());
			guest.setState(stateTextField.getText());
			guest.setCity(cityTextField.getText());
			guest.setCheckInDate(checkInDateTextField.getText());
			guest.setCheckOutDate(checkOutDateTextField.getText());
			
			
			
			
			GuestServiceLayer guestSL = new GuestServiceLayer();
			ReserveServiceLayer reserveSL = new ReserveServiceLayer();
			
			String bookingStatus = "Pending";
			String paymentStatus = "Pending";
			
			
			
			if(creditCardChckbx.isSelected()) {
				CreditCard credit = new CreditCard();
				CreditServiceLayer creditSL = new CreditServiceLayer();
				
				credit.setCardType(CardDetailBox.cardTypeTextField.getText());
				credit.setNameOnCard(CardDetailBox.nameOnCardTextField.getText());
				credit.setCardNo(CardDetailBox.cardNumberTextField.getText());
				 
				if(guestSL.validateGuestDetails(guest) && creditSL.validateCreditDetails(credit)) {
					guest = guestSL.guestSave(guest);
					credit = creditSL.creditSave(credit);
					reserve.setBookingStatus(bookingStatus);
					reserve.setPaymentStatus(paymentStatus);
					reserve = reserveSL.reservationSave(reserve);
				}
			}
			else {
					guestSL.validateGuestDetails(guest);
					guest = guestSL.guestSave(guest);
					reserve.setBookingStatus(bookingStatus);
					reserve.setPaymentStatus(paymentStatus);
					reserve = reserveSL.reservationSave(reserve);
					
			}
			
			
			
		}
		catch(InputException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	
}
