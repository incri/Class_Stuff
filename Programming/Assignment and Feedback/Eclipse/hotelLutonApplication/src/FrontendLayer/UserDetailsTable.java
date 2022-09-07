package FrontendLayer;


import java.util.ArrayList;


import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import Models.DefultModel;
import Models.Room;
import Models.Users;
import ServiceLayer.UserDetailsServiceLayer;
import ServiceLayer.UserServiceLayer;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 68, 670, 322);
		getContentPane().add(scrollPane);
		
		userTable = new JTable();
		userTable.setFillsViewportHeight(true);
		scrollPane.setViewportView(userTable);
		
		JButton btnDeleteUser = new JButton("Delete User");
		btnDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

			}
		});
		btnDeleteUser.setBounds(12, 29, 105, 27);
		getContentPane().add(btnDeleteUser);
		
		model = new DefaultTableModel();
		Object[] columnsName = new Object[5];
		columnsName[0] = "User ID";
		columnsName[1] = "Name";
		columnsName[2] = "Email";
		columnsName[3] = "Company Name";
		columnsName[4] = "Company Contact";
		
		
		model.setColumnCount(0);
		
		model.setColumnIdentifiers(columnsName);
		
	}
	
	public void loadAllUser() {
		try {
			UserDetailsServiceLayer userDetailsSL = new UserDetailsServiceLayer();
			ArrayList<DefultModel> defultModel = userDetailsSL.getAllData();
			setTableData(defultModel);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}
	
	private void setTableData(ArrayList<DefultModel> defultModel) {
		// Create the object array from arraylist and add to the table row
		Object[] rowData = new Object[5];
		// set the number of rows in table model to zero
		model.setRowCount(0);
		for(int i=0; i<defultModel.size(); i++) {
			
			rowData[0] = defultModel.get(i).getUserID();
			rowData[1] = defultModel.get(i).getName();
			rowData[2] = defultModel.get(i).getEmail();
			rowData[3] = defultModel.get(i).getCorpName();
			rowData[4] = defultModel.get(i).getCorpContact();
			model.addRow(rowData);
		}
		userTable.setModel(model);

	}
}