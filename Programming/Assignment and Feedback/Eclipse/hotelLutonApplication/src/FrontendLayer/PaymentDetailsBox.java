package FrontendLayer;

import java.awt.event.MouseListener;

import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import Models.DefultModel;
import ServiceLayer.BookingDetailsServiceLayer;
import ServiceLayer.PaymentDetailsServiceLayer;
import ServiceLayer.RoomServiceLayer;


import javax.swing.JScrollPane;

public class PaymentDetailsBox extends JInternalFrame {
	private JTable paymentTable;
	private DefaultTableModel model;
	/**
	 * Create the frame.
	 */
	public PaymentDetailsBox() {
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
		
		paymentTable = new JTable();
		scrollPane.setViewportView(paymentTable);
		
		model = new DefaultTableModel();
		Object[] columnsName = new Object[7];
		columnsName[0] = "Booking ID";
		columnsName[1] = "Guest Name";
		columnsName[2] = "Guest Contact";
		columnsName[3] = "Room No";
		columnsName[4] = "Room Price";
		columnsName[5] = "Total Bill";
		columnsName[6] = "Payment Status";
		
		
		
		
		model.setColumnCount(0);
		
		model.setColumnIdentifiers(columnsName);

	}
	
	public void loadAllPayment() {
		try {
			PaymentDetailsServiceLayer paymentSL = new PaymentDetailsServiceLayer();
			ArrayList<DefultModel> defultModel = paymentSL.getAllPayment();
			setTableBookingData(defultModel);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}
	
	private void setTableBookingData(ArrayList<DefultModel> defultModel) {
		// Create the object array from arraylist and add to the table row
		Object[] rowData = new Object[8];
		// set the number of rows in table model to zero
		model.setRowCount(0);
		for(int i=0; i<defultModel.size(); i++) {
			rowData[0] = defultModel.get(i).getBookingID();
			rowData[1] = defultModel.get(i).getGuestName();
			rowData[2] = defultModel.get(i).getContact();
			rowData[3] = defultModel.get(i).getRoomNo();
			rowData[4] = defultModel.get(i).getPricePerNight();
			rowData[5] = defultModel.get(i).getTotalBill();
			rowData[6] = defultModel.get(i).getPaymentStatus();
			
		
			model.addRow(rowData);
		}
		paymentTable.setModel(model);

	}
}
