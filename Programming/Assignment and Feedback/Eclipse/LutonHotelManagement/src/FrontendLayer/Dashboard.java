package FrontendLayer;

import javax.swing.JFrame;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BusinessLayer.BLUser;
import Helper.InputException;
import Models.Users;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;

public class Dashboard {

	private JFrame mainFrame;
	private JTextField tfName;
	private JTextField tfAddress;
	private DefaultTableModel model;
	private JTextField tfSearchName;
	private JTextField tfSearchAddress;
	private JTable tblData;
	
	/**
	 * Create the application.
	 */
	public Dashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setBounds(100, 100, 854, 549);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel paneltop = new JPanel();
		mainFrame.getContentPane().add(paneltop, BorderLayout.NORTH);
		
		JLabel lblName = new JLabel("Name");
		paneltop.add(lblName);
		
		tfName = new JTextField();
		paneltop.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		paneltop.add(lblAddress);
		
		tfAddress = new JTextField();
		paneltop.add(tfAddress);
		tfAddress.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveUser();
			}
		});
		paneltop.add(btnSave);
		
		JButton btnListAll = new JButton("List All Users");
		btnListAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadAllUser();
			}
		});
		paneltop.add(btnListAll);
		
		JPanel panelMain = new JPanel();
		mainFrame.getContentPane().add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(new BorderLayout());
		
		JPanel panelFilter = new JPanel();
		panelFilter.setBackground(new Color(128, 128, 255));
		panelMain.add(panelFilter, BorderLayout.NORTH);
		
		JLabel lblSearchText = new JLabel("Search Users :");
		panelFilter.add(lblSearchText);
		
		JLabel lblSearchName = new JLabel("Name");
		panelFilter.add(lblSearchName);
		
		tfSearchName = new JTextField();
		panelFilter.add(tfSearchName);
		tfSearchName.setColumns(10);
		
		JLabel lblSearchAddress = new JLabel("Address");
		panelFilter.add(lblSearchAddress);
		
		tfSearchAddress = new JTextField();
		tfSearchAddress.setText("");
		panelFilter.add(tfSearchAddress);
		tfSearchAddress.setColumns(10);
		
		JButton btnSearch = new JButton("Search Users");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchUser();
			}
		});
		panelFilter.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		panelMain.add(scrollPane, BorderLayout.CENTER);
		
		tblData = new JTable();
		scrollPane.setViewportView(tblData);
		
		// Set column for the default table model;
		model = new DefaultTableModel();
		Object[] columnsName = new Object[3];
		columnsName[0] = "Id";
		columnsName[1] = "Name";
		columnsName[2] = "Address";
		model.setColumnIdentifiers(columnsName);
		
	}
	
	private void saveUser() {
		// On click of the save button
		// Read data from the fields and store it in the model
		// Create an object of Business Layer and pass the model to business layer
		// Perform the required action from the business layer.
		try {
			Users user = new Users();
			user.setName(tfName.getText());
			user.setAddress(tfAddress.getText());
			
			BLUser blUser = new BLUser();
			blUser.setUser(user);
			user = blUser.save();
			searchUser();
			
		}
		catch(InputException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	
	private void loadAllUser() {
		try {
			BLUser bl = new BLUser();
			ArrayList<Users> users = bl.getAllUser();
			setTableData(users);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}
	
	private void searchUser() {
		// Define the search key and value array
		// Pass them to the BLUser Object, get the arraylist 
		// Set it to the table
		try {
			String[] keys, values;
			BLUser bl = new BLUser();
			ArrayList<Users> users;
			if(tfSearchName.getText().length()>0 && tfSearchAddress.getText().length()>0) {
				keys = new String[2];
				values = new String[2];
				keys[0] = "name"; values[0] = tfSearchName.getText();
				keys[1] = "address"; values[1] = tfSearchAddress.getText();
				users = bl.searchUser(keys, values);
			}else if(tfSearchName.getText().length()>0) {
				keys = new String[1];
				values = new String[1];
				keys[0] = "name"; values[0] = tfSearchName.getText();
				users = bl.searchUser(keys, values);
			}else if(tfSearchAddress.getText().length()>0) {
				keys = new String[1];
				values = new String[1];
				keys[0] = "address"; values[0] = tfSearchAddress.getText();
				users = bl.searchUser(keys, values);
			}else {
				users = bl.getAllUser();
			}
			setTableData(users);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}
	
	private void setTableData(ArrayList<Users> users) {
		// Create the object array from arraylist and add to the table row
		Object[] rowData = new Object[3];
		// set the number of rows in table model to zero
		model.setRowCount(0);
		for(int i=0; i<users.size(); i++) {
			rowData[0] = users.get(i).getUserId();
			rowData[1] = users.get(i).getName();
			rowData[2] = users.get(i).getAddress();
			model.addRow(rowData);
		}
		tblData.setModel(model);
	}
	
	public void setVisible(boolean state) {
		mainFrame.setVisible(state);
	}

}
