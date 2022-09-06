package FrontendLayer;



import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;


import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import Helper.DatabaseConnector;
import Helper.InputException;
import Models.DefultModel;
import Models.Users;
import ServiceLayer.PaymentDetailsServiceLayer;
import ServiceLayer.RoomAssignServiceLayer;
import ServiceLayer.RoomServiceLayer;
import ServiceLayer.UserServiceLayer;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class BillGenerateBox extends JInternalFrame {
	private JTextField reserveTextBox;
	private DatabaseConnector db;
	private Connection connection;
	private DefultModel defultModel;


	
	/**
	 * Create the frame.
	 */
	public BillGenerateBox() {
		setBounds(0, 0, 595, 237);
		getContentPane().setLayout(null);
		
		BasicInternalFrameUI basicInternalFrameUI = ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI());
		for(MouseListener listener: basicInternalFrameUI.getNorthPane().getMouseListeners()){
			basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
			
		}
		
		JLabel billLabel = new JLabel("Generate Bill");
		billLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		billLabel.setBounds(202, 12, 232, 33);
		getContentPane().add(billLabel);
		
		JLabel bookingLabel = new JLabel("Booking ID");
		bookingLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		bookingLabel.setBounds(27, 55, 159, 33);
		getContentPane().add(bookingLabel);
		
		reserveTextBox = new JTextField();
		reserveTextBox.setColumns(10);
		reserveTextBox.setBounds(27, 100, 159, 31);
		getContentPane().add(reserveTextBox);
		
		JLabel messageLable = new JLabel("Please enter your booking ID to generate your bill......");
		messageLable.setBounds(201, 103, 332, 24);
		getContentPane().add(messageLable);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				generateBill();
			}
		});
		btnGenerate.setBounds(239, 153, 105, 27);
		getContentPane().add(btnGenerate);

	}
	
	private void generateBill() {
		// On click of the log In button
		// It fetch the data from the field
		// Create an object of Service Layer and pass the model to Service layer
		// Perform the required action from the Service layer.
		try {
			DefultModel model = new DefultModel();
			model.setBookingID(reserveTextBox.getText());
			
			
			PaymentDetailsServiceLayer payment = new PaymentDetailsServiceLayer();
			payment.generateBill(model);
			
			
		}
		catch(InputException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
			
	}
}
