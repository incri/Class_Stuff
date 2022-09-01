package FrontendLayer;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DatabaseLayer.UserDetailsDatabaseLayer;
import Models.UserDetails;
import ServiceLayer.UserDetailsServiceLayer;

import javax.swing.JScrollPane;

public class UserDetailsTable extends JInternalFrame {
	private DefaultTableModel model;
	private JTable userTable;


	/**
	 * Create the frame.
	 */
	public UserDetailsTable() {
		setClosable(true);
		setBounds(0, 0, 704, 436);
		getContentPane().setLayout(null);
		
		userTable = new JTable();
		userTable.setBounds(12, 68, 670, 322);
		getContentPane().add(userTable);
		
		
		
		//model.setColumnIdentifiers(columnsName);
		

	}
	
	public void loadAllUser() {
		try {
			
			this.model = (DefaultTableModel) userTable.getModel();
			Object[] columnsName = new Object[3];
			columnsName[0] = "Room no";
			columnsName[1] = "Room Type";
			columnsName[2] = "Price Per Night";
			
			model.addColumn(columnsName);
			
			UserDetailsServiceLayer userDetailsService = new UserDetailsServiceLayer();
			ArrayList<UserDetails> usersDetails = userDetailsService.getAllUserDetails();
			setTableData(usersDetails);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}
	
	private void setTableData(ArrayList<UserDetails> userDetails) throws SQLException {
		
		Object[] rowData = new Object[3];
		// set the number of rows in table model to zero
		this.model.setRowCount(0);
		for(int i=0; i<userDetails.size(); i++) {
			rowData[0] = userDetails.get(i).getUserID();
			rowData[1] = userDetails.get(i).getCusID();
			rowData[2] = userDetails.get(i).getName();
			
			this.model.addRow(rowData);
		}
		userTable.setModel(this.model);
	}
}
