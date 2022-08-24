package SinglePage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SinglePage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7893839535797907740L;
	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SinglePage frame = new SinglePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SinglePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 64));
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("Name");
		panel.add(lblNewLabel);

		tfName = new JTextField();
		tfName.setText("");
		panel.add(tfName);
		tfName.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Address");
		panel.add(lblNewLabel_1);

		tfAddress = new JTextField();
		panel.add(tfAddress);
		tfAddress.setColumns(10);

		JTextArea taData = new JTextArea();

		JButton btnSave = new JButton("Save Data");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Load the class
					Class.forName("com.mysql.cj.jdbc.Driver");
					// Create the connection
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_test",
							"root","mysql");
					// In case of insert statement this is done to read the inserted id
					String generatedColumns[] = { "id" };
					// create the query
					String query = "INSERT INTO user(name, address) VALUES(?,?)";
					// create the statement
					PreparedStatement statement = conn.prepareStatement(query, generatedColumns);
					// set the parameters
					statement.setString(1, tfName.getText());
					statement.setString(2, tfAddress.getText());
					// execute the query
					int noOfUpdate = statement.executeUpdate();
					// if data is inserted it returns 1
					if (noOfUpdate > 0) {
						// Read the result of returned data
						ResultSet rs = statement.getGeneratedKeys();
						// data is read one row at a time
						if (rs.next()) {
							rs.getInt(1);
							// Display the data
							String detail = tfName.getText() + " living at " + tfAddress.getText() + " data stored";
							taData.setText(detail);
						}
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		panel.add(btnSave);

		taData.setRows(5);
		taData.setColumns(40);
		panel.add(taData);
	}

}
