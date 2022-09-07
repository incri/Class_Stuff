package FrontendLayer;

import java.awt.event.MouseListener;


import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import Models.DefultModel;
import Models.Room;
import ServiceLayer.BookingDetailsServiceLayer;
import ServiceLayer.RoomServiceLayer;
import ServiceLayer.UserDetailsServiceLayer;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookingDetailsTable extends JInternalFrame {
	private JTable bookingtable;
	private DefaultTableModel model;
	
	/**
	 * Create the frame.
	 */
	public BookingDetailsTable() {
		setClosable(true);
		setBounds(0, 0, 704, 436);
		getContentPane().setLayout(null);
		
		BasicInternalFrameUI basicInternalFrameUI = ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI());
		for(MouseListener listener: basicInternalFrameUI.getNorthPane().getMouseListeners()){
			basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 67, 670, 323);
		getContentPane().add(scrollPane);
		
		bookingtable = new JTable();
		scrollPane.setViewportView(bookingtable);
		
		JButton btnDeleteBooking = new JButton("DELETE Booking");
		btnDeleteBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(bookingtable.getSelectionModel().isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null,"No Selected Item" );

                }
                int row = bookingtable.getSelectedRow();
                DefaultTableModel model =  (DefaultTableModel) bookingtable.getModel();
                int reserveID = Integer.parseInt(model.getValueAt(row, 0).toString());

                DefultModel defultmodel = new DefultModel();
                defultmodel.setBookingID(reserveID);


                BookingDetailsServiceLayer bookingDetailsSL = new BookingDetailsServiceLayer();
                try {
                	bookingDetailsSL.deleteBooking(defultmodel);
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
			}
		});
		btnDeleteBooking.setBounds(12, 31, 142, 27);
		getContentPane().add(btnDeleteBooking);
		
		model = new DefaultTableModel();
		Object[] columnsName = new Object[11];
		columnsName[0] = "Booking ID";
		columnsName[1] = "Name";
		columnsName[2] = "Corporate Name";
		columnsName[3] = "Corporate Contact";
		columnsName[4] = "Credit Number";
		columnsName[5] = "Prefered Room";
		columnsName[6] = "Country";
		columnsName[7] = "Check In date";
		columnsName[8] = "Check Out date";
		columnsName[9] = "Booking Status";
		columnsName[10] = "Room No";
		
		
		
		
		model.setColumnCount(0);
		
		model.setColumnIdentifiers(columnsName);

	}
	
	public void loadAllbooking() {
		try {
			BookingDetailsServiceLayer bookingSL = new BookingDetailsServiceLayer();
			ArrayList<DefultModel> defultModel = bookingSL.getAllBooking();
			setTableBookingData(defultModel);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}
	
	private void setTableBookingData(ArrayList<DefultModel> defultModel) {
		// Create the object array from arraylist and add to the table row
		Object[] rowData = new Object[11];
		// set the number of rows in table model to zero
		model.setRowCount(0);
		for(int i=0; i<defultModel.size(); i++) {
			rowData[0] = defultModel.get(i).getBookingID();
			rowData[1] = defultModel.get(i).getName();
			rowData[2] = defultModel.get(i).getCorpName();
			rowData[3] = defultModel.get(i).getCorpContact();
			rowData[4] = defultModel.get(i).getCardNumber();
			rowData[5] = defultModel.get(i).getRoomPreference();
			rowData[6] = defultModel.get(i).getCountry();
			rowData[7] = defultModel.get(i).getCheckInDate();
			rowData[8] = defultModel.get(i).getCheckOutDate();
			rowData[9] = defultModel.get(i).getBookingStatus();
			rowData[10] = defultModel.get(i).getRoomNo();
		
			model.addRow(rowData);
		}
		bookingtable.setModel(model);

	}
}
