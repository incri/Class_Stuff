package FrontendLayer;

import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import Helper.InputException;
import Models.Room;
import Models.Users;
import ServiceLayer.RoomServiceLayer;
import ServiceLayer.UserServiceLayer;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AddRoomPage extends JInternalFrame {
	private JTextField pricePerNightTextField;
	private JTextField detailsTextField;
	private JComboBox statusChooser;
	private JComboBox roomTypeChooser;
	private DefaultTableModel model;

	/**
	 * Create the frame.
	 */
	public AddRoomPage() {
		setClosable(true);
		setBounds(0, 0, 405, 372);
		getContentPane().setLayout(null);
		
		BasicInternalFrameUI basicInternalFrameUI = ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI());
		for(MouseListener listener: basicInternalFrameUI.getNorthPane().getMouseListeners()){
			basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
			
		}
		
		JLabel addRoomtitle = new JLabel("ADD ROOMS");
		addRoomtitle.setFont(new Font("Dialog", Font.BOLD, 24));
		addRoomtitle.setBounds(117, 12, 187, 25);
		getContentPane().add(addRoomtitle);
		
		JLabel roomTypeLabel = new JLabel("Room Type");
		roomTypeLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		roomTypeLabel.setBounds(12, 71, 107, 17);
		getContentPane().add(roomTypeLabel);
		
		JLabel pricePerNightLabel = new JLabel("Price Per Night");
		pricePerNightLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		pricePerNightLabel.setBounds(227, 71, 159, 17);
		getContentPane().add(pricePerNightLabel);
		
		String[] roomType = { "single Room", "Delux Room", "Double Room" };
		roomTypeChooser = new JComboBox(roomType);
		roomTypeChooser.setBounds(12, 104, 159, 26);
		getContentPane().add(roomTypeChooser);
		
		pricePerNightTextField = new JTextField();
		pricePerNightTextField.setColumns(10);
		pricePerNightTextField.setBounds(227, 102, 159, 31);
		getContentPane().add(pricePerNightTextField);
		
		
		JLabel roomDetailsLabel = new JLabel("Room Details");
		roomDetailsLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		roomDetailsLabel.setBounds(12, 155, 144, 17);
		getContentPane().add(roomDetailsLabel);
		
		JLabel statusLable = new JLabel("Status");
		statusLable.setFont(new Font("Dialog", Font.BOLD, 18));
		statusLable.setBounds(12, 234, 107, 17);
		getContentPane().add(statusLable);
		
		detailsTextField = new JTextField();
		detailsTextField.setColumns(10);
		detailsTextField.setBounds(12, 184, 374, 31);
		getContentPane().add(detailsTextField);
		
		String[] roomStatus = { "Available", "Reserved", "Booked" };
		statusChooser = new JComboBox(roomStatus);
		statusChooser.setBounds(12, 263, 208, 26);
		getContentPane().add(statusChooser);
		
		JButton btnAddRoom = new JButton("ADD ROOM");
		btnAddRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveRoom();
			}
		});
		btnAddRoom.setBounds(262, 263, 105, 27);
		getContentPane().add(btnAddRoom);
		
		
		
	
	}
	private void saveRoom() {
		// On click of the save button
		// Read data from the fields and store it in the model
		// Create an object of Business Layer and pass the model to business layer
		// Perform the required action from the business layer.
		try {
			Room room = new Room();
	
			room.setRoomType(roomTypeChooser.getSelectedItem());
			room.setPricePerNight(pricePerNightTextField.getText());
			room.setRoomDetails(detailsTextField.getText());
			room.setRoomStatus(statusChooser.getSelectedItem());
			
			RoomServiceLayer roomSL = new RoomServiceLayer();
			room = roomSL.roomSave(room);
		}
		catch(InputException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	
	
	
	}

