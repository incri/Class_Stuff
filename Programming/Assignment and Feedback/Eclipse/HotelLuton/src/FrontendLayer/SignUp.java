package FrontendLayer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import BusinessLayer.BLUser;
import Helper.InputException;
import Models.User;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;

public class SignUp extends JInternalFrame {
	private JTextField siFirstTextField;
	private JTextField siLastTextField;
	private JTextField siEmailTextField;
	private JTextField siUserNameTextField;
	private JPasswordField siPasswordPassField;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public SignUp() {
		setTitle("SignUp");
		setClosable(true);
		setBounds(0, 0, 560, 571);
		getContentPane().setLayout(null);
		
		JLabel signTitle = new JLabel("REGISTER TO LUTON");
		signTitle.setFont(new Font("Dialog", Font.BOLD, 28));
		signTitle.setBounds(145, 26, 292, 31);
		getContentPane().add(signTitle);
		
		JLabel siLogoLabel = new JLabel("");
		Image logo = new ImageIcon(this.getClass().getResource("/LOGO2.png")).getImage();
		siLogoLabel.setIcon(new ImageIcon(logo));
		siLogoLabel.setBounds(31, 12, 90, 80);
		getContentPane().add(siLogoLabel);
		
		JLabel signInMess = new JLabel("Welcome to Luton Family");
		signInMess.setFont(new Font("Dialog", Font.BOLD, 18));
		signInMess.setBounds(166, 79, 228, 17);
		getContentPane().add(signInMess);
		
		JPanel signInPanel = new JPanel();
		signInPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		signInPanel.setBounds(12, 130, 526, 407);
		getContentPane().add(signInPanel);
		signInPanel.setLayout(null);
		
		JLabel siFirstLabel = new JLabel("First Name");
		siFirstLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		siFirstLabel.setBounds(12, 28, 179, 17);
		signInPanel.add(siFirstLabel);
		
		JLabel siLastLabel = new JLabel("Last Name");
		siLastLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		siLastLabel.setBounds(299, 28, 198, 17);
		signInPanel.add(siLastLabel);
		
		siFirstTextField = new JTextField();
		siFirstTextField.setColumns(10);
		siFirstTextField.setBounds(12, 57, 215, 31);
		signInPanel.add(siFirstTextField);
		
		siLastTextField = new JTextField();
		siLastTextField.setColumns(10);
		siLastTextField.setBounds(299, 57, 215, 31);
		signInPanel.add(siLastTextField);
		
		JLabel siEmailAddreessLabel = new JLabel("Email");
		siEmailAddreessLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		siEmailAddreessLabel.setBounds(12, 113, 179, 17);
		signInPanel.add(siEmailAddreessLabel);
		
		JLabel siUserNameLabel_3 = new JLabel("User Name");
		siUserNameLabel_3.setFont(new Font("Dialog", Font.BOLD, 18));
		siUserNameLabel_3.setBounds(299, 115, 179, 17);
		signInPanel.add(siUserNameLabel_3);
		
		siEmailTextField = new JTextField();
		siEmailTextField.setColumns(10);
		siEmailTextField.setBounds(12, 143, 215, 31);
		signInPanel.add(siEmailTextField);
		
		siUserNameTextField = new JTextField();
		siUserNameTextField.setColumns(10);
		siUserNameTextField.setBounds(299, 143, 215, 31);
		signInPanel.add(siUserNameTextField);
		
		JLabel siPasswordLabel = new JLabel("Password");
		siPasswordLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		siPasswordLabel.setBounds(12, 195, 179, 17);
		signInPanel.add(siPasswordLabel);
		
		siPasswordPassField = new JPasswordField();
		siPasswordPassField.setColumns(10);
		siPasswordPassField.setBounds(12, 225, 215, 31);
		signInPanel.add(siPasswordPassField);
		
		
		JButton btnSignup = new JButton("SIGNUP");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveUser();
			}
		});
		btnSignup.setBounds(36, 329, 115, 39);
		signInPanel.add(btnSignup);
		
		
		JDesktopPane codesktopPane = new JDesktopPane();
		codesktopPane.setBackground(SystemColor.scrollbar);
		codesktopPane.setBounds(185, 278, 329, 117);
		signInPanel.add(codesktopPane);
		
		JButton btnNewButton = new JButton("As corporate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Corporate cosignUp = new Corporate();
				codesktopPane.add(cosignUp);
				cosignUp.setVisible(true);
			}
			
		});
		btnNewButton.setBounds(272, 227, 132, 27);
		signInPanel.add(btnNewButton);
		
		// Set column for the default table model;
				model = new DefaultTableModel();
				Object[] columnsName = new Object[3];
				columnsName[0] = "Id";
				columnsName[1] = "FirstName";
				columnsName[2] = "LastNAme";
				columnsName[3] = "Email";
				columnsName[4] = "UserName";
				columnsName[6] = "Password";
				columnsName[7] = "UserType";
				columnsName[8] = "CompanyName";
				columnsName[9] = "CompanyContact";
				model.setColumnIdentifiers(columnsName);
				}
				
				private void saveUser() {
					// On click of the save button
					// Read data from the fields and store it in the model
					// Create an object of Business Layer and pass the model to business layer
					// Perform the required action from the business layer.
					try {
						User user = new User();
						user.setFirstName(siFirstTextField.getText());
						user.setLastName(siLastTextField.getText());
						user.setEmail(siEmailTextField.getText());
						user.setUserName(siUserNameTextField.getText());
						
						
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
				
				void loadAllUser() {
					try {
						BLUser bl = new BLUser();
						ArrayList<User> users = bl.getAllUser();
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
						ArrayList<User> users;
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
				
				private void setTableData(ArrayList<User> users) {
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

				
		
	}
}