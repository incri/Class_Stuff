

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
import ServiceLayer.BillGenerateServiceLayer;
import ServiceLayer.RoomAssignServiceLayer;
import ServiceLayer.RoomServiceLayer;
import ServiceLayer.UserServiceLayer;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class CreateBillBox extends JInternalFrame {
	private JTextField customerTextBox;
	private JTextField discountPerTextField;
	private DatabaseConnector db;
	private Connection connection;
	private DefultModel defultModel;


	
	/**
	 * Create the frame.
	 */
	public CreateBillBox() {
		setBounds(0, 0, 405,372);
		getContentPane().setLayout(null);
		
		BasicInternalFrameUI basicInternalFrameUI = ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI());
		for(MouseListener listener: basicInternalFrameUI.getNorthPane().getMouseListeners()){
			basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
			
		}
		
		JLabel addRoomtitle = new JLabel("Generate Bill");
		addRoomtitle.setFont(new Font("Dialog", Font.BOLD, 24));
		addRoomtitle.setBounds(111, 12, 232, 33);
		getContentPane().add(addRoomtitle);
		
		JLabel pricePerNightLabel = new JLabel("Booking ID");
		pricePerNightLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		pricePerNightLabel.setBounds(12, 72, 159, 27);
		getContentPane().add(pricePerNightLabel);
		
		customerTextBox = new JTextField();
		customerTextBox.setColumns(10);
		customerTextBox.setBounds(12, 112, 159, 31);
		getContentPane().add(customerTextBox);
		
		JLabel discountPerLabel = new JLabel("Discount Percent");
		discountPerLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		discountPerLabel.setBounds(12, 155, 159, 17);
		getContentPane().add(discountPerLabel);
		
		discountPerTextField = new JTextField();
		discountPerTextField.setColumns(10);
		discountPerTextField.setBounds(12, 184, 159, 31);
		getContentPane().add(discountPerTextField);
		
		JButton generateButton = new JButton("Generate Bill");
		generateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				generateBill();
			}
		});
		generateButton.setBounds(12, 259, 147, 27);
		getContentPane().add(generateButton);

	}
	
	private void generateBill() {
	
		try {
			 defultModel = new DefultModel();
			 defultModel.setBookingID(Integer.parseInt(customerTextBox.getText()));
			 defultModel.setDiscountPer(discountPerTextField.getText());
			 
			
			
			BillGenerateServiceLayer generateBillSL = new BillGenerateServiceLayer();
			
			generateBillSL.generateBill(defultModel);
			
			
		}
		catch(InputException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
			
	}
	
}

