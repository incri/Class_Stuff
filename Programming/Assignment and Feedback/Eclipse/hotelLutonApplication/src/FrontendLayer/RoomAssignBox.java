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
import ServiceLayer.RoomAssignServiceLayer;
import ServiceLayer.RoomServiceLayer;
import ServiceLayer.UserServiceLayer;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class RoomAssignBox extends JInternalFrame {
	private JTextField customerTextBox;
	private JTextField roomNoTextField;
	private DatabaseConnector db;
	private Connection connection;
	private DefultModel defultModel;


	
	/**
	 * Create the frame.
	 */
	public RoomAssignBox() {
		setBounds(0, 0, 405,372);
		getContentPane().setLayout(null);
		
		BasicInternalFrameUI basicInternalFrameUI = ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI());
		for(MouseListener listener: basicInternalFrameUI.getNorthPane().getMouseListeners()){
			basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
			
		}
		
		JLabel addRoomtitle = new JLabel("Booking Manager");
		addRoomtitle.setFont(new Font("Dialog", Font.BOLD, 24));
		addRoomtitle.setBounds(84, 12, 232, 33);
		getContentPane().add(addRoomtitle);
		
		JLabel pricePerNightLabel = new JLabel("Booking ID");
		pricePerNightLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		pricePerNightLabel.setBounds(12, 83, 159, 17);
		getContentPane().add(pricePerNightLabel);
		
		customerTextBox = new JTextField();
		customerTextBox.setColumns(10);
		customerTextBox.setBounds(12, 112, 159, 31);
		getContentPane().add(customerTextBox);
		
		JLabel pricePerNightLabel_1 = new JLabel("Room No");
		pricePerNightLabel_1.setFont(new Font("Dialog", Font.BOLD, 18));
		pricePerNightLabel_1.setBounds(12, 155, 159, 17);
		getContentPane().add(pricePerNightLabel_1);
		
		roomNoTextField = new JTextField();
		roomNoTextField.setColumns(10);
		roomNoTextField.setBounds(12, 184, 159, 31);
		getContentPane().add(roomNoTextField);
		
		JButton assignButton = new JButton("Assign Room");
		assignButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignRoom();
			}
		});
		assignButton.setBounds(12, 259, 147, 27);
		getContentPane().add(assignButton);
		
		JButton btnNewButton_1 = new JButton("Cancel Booking");
		btnNewButton_1.setBounds(171, 259, 133, 27);
		getContentPane().add(btnNewButton_1);

	}
	
	private void assignRoom() {
	
		try {
			 defultModel = new DefultModel();
			 defultModel.setBookingID(Integer.parseInt(customerTextBox.getText()));
			 defultModel.setRoomNo(roomNoTextField.getText());
			
			
			RoomAssignServiceLayer roomAssignSL = new RoomAssignServiceLayer();
			
			roomAssignSL.roomAssign(defultModel);
			
			
		}
		catch(InputException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
			
	}
	
}
