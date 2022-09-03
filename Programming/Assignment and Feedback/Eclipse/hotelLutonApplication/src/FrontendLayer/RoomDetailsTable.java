package FrontendLayer;

import java.awt.event.MouseListener;


import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import Models.Room;

import ServiceLayer.RoomServiceLayer;


import javax.swing.JScrollPane;

public class RoomDetailsTable extends JInternalFrame {
	private JTable roomtable;
	private DefaultTableModel model;
	/**
	 * Create the frame.
	 */
	public RoomDetailsTable() {
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
		
		roomtable = new JTable();
		scrollPane.setViewportView(roomtable);
		
		model = new DefaultTableModel();
		Object[] columnsName = new Object[5];
		columnsName[0] = "Room no";
		columnsName[1] = "Room Type";
		columnsName[2] = "Price Per Night";
		columnsName[3] = "Details";
		columnsName[4] = "Room Status";
		
		
		model.setColumnCount(0);
		
		model.setColumnIdentifiers(columnsName);

	}
	
	public void loadAllRoom() {
		try {
			RoomServiceLayer rSL = new RoomServiceLayer();
			ArrayList<Room> room = rSL.getAllRoom();
			setTableRoomData(room);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}
	
	private void setTableRoomData(ArrayList<Room> room) {
		// Create the object array from arraylist and add to the table row
		Object[] rowData = new Object[5];
		// set the number of rows in table model to zero
		model.setRowCount(0);
		for(int i=0; i<room.size(); i++) {
			rowData[0] = room.get(i).getRoomNo();
			rowData[1] = room.get(i).getRoomType();
			rowData[2] = room.get(i).getPricePerNight();
			rowData[3] = room.get(i).getRoomDetails();
			rowData[4] = room.get(i).getRoomStatus();
			model.addRow(rowData);
		}
		roomtable.setModel(model);

	}
}
