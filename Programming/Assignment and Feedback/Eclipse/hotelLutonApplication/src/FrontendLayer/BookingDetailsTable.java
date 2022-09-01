package FrontendLayer;


import java.util.ArrayList;


import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import Models.DefultModel;
import Models.Room;
import Models.Users;
import ServiceLayer.BookingDetailsServiceLayer;
import ServiceLayer.UserDetailsServiceLayer;
import javax.swing.JScrollPane;



public class BookingDetailsTable extends JInternalFrame {
	private DefaultTableModel model;
	private JTable bookingTable;


	/**
	 * Create the frame.
	 */
	public BookingDetailsTable() {
		setClosable(true);
		setBounds(0, 0, 704, 436);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 68, 670, 322);
		getContentPane().add(scrollPane);
		
		bookingTable = new JTable();
		scrollPane.setViewportView(bookingTable);
		
		model = new DefaultTableModel();
		Object[] columnsName = new Object[8];
		columnsName[0] = "Cus ID";
		columnsName[1] = "Company ID";
		columnsName[2] = "Name";
		columnsName[3] = "Room Preference";
		columnsName[4] = "Check In Date";
		columnsName[5] = "Check Out Date";
		columnsName[6] = "Card Number";
		columnsName[7] = "Booking Status";
		
		
		model.setColumnCount(0);
		
		model.setColumnIdentifiers(columnsName);
		
	}
	
	public void loadAllUser() {
		try {
			BookingDetailsServiceLayer bookingDetailsSL = new BookingDetailsServiceLayer();
			ArrayList<DefultModel> defultModel = bookingDetailsSL.getAllData();
			setTableData(defultModel);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}
	
	private void setTableData(ArrayList<DefultModel> defultModel) {
		// Create the object array from arraylist and add to the table row
		Object[] rowData = new Object[8];
		// set the number of rows in table model to zero
		model.setRowCount(0);
		for(int i=0; i<defultModel.size(); i++) {
			
			rowData[0] = defultModel.get(i).getCusID();
			rowData[1] = defultModel.get(i).getCorpID();
			rowData[2] = defultModel.get(i).getName();
			rowData[3] = defultModel.get(i).getRoomPreference();
			rowData[4] = defultModel.get(i).getCheckInDate();
			rowData[5] = defultModel.get(i).getCheckOutDate();
			rowData[6] = defultModel.get(i).getCardNumber();
			rowData[7] = defultModel.get(i).getBookingStatus();
			model.addRow(rowData);
		}
		bookingTable.setModel(model);

	}
	
}