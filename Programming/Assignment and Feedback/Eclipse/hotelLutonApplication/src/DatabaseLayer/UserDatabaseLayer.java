package DatabaseLayer;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.swing.JOptionPane;

import Helper.DatabaseConnector;
import Models.Users;
import FrontendLayer.AdminPage;
import FrontendLayer.LogInBox;

import FrontendLayer.UserHomePage;

public class UserDatabaseLayer {

	public static int primkey = 0;
	private Users user;
	private DatabaseConnector db;
	private Connection connection;
	
	public UserDatabaseLayer() {
		this.user = new Users();
	}
	
	public UserDatabaseLayer(Users user) throws Exception {
		this.user = user;
		try{
		this.db = DatabaseConnector.getInstance();
		this.connection = this.db.getConnection();
		}catch (Exception ex) {
			throw ex;
		}
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	
	//user login method
	
	public Users userLogIn() throws Exception {
		
		PreparedStatement customerStatement;
		PreparedStatement adminStatement;
		ResultSet crs;
		ResultSet ars;
		
		
		//getting email and password from the login page
		
		// query to check if the username and password exist in data base or not
		
		String customerQuery = "SELECT * FROM Users WHERE userName = ? AND password = ? AND userType is NULL  ";
		String adminQuery = "SELECT * FROM Users WHERE userName = ? AND password = ? AND userType = 'receptionist' ";
		
		try {
			
			customerStatement = this.connection.prepareStatement(customerQuery);
			customerStatement.setString(1, this.user.getUserName());
			customerStatement.setString(2, this.user.getPassword());
			
			
			adminStatement = this.connection.prepareStatement(adminQuery);
			adminStatement.setString(1, this.user.getUserName());
			adminStatement.setString(2, this.user.getPassword());
			
			
			
			crs = customerStatement.executeQuery();
			ars = adminStatement.executeQuery();
			
			//condition if the username and password match
			if (crs.next())
			{
				//take user to user home page
				UserHomePage homePage = new UserHomePage();
				homePage.setVisible(true);
				homePage.pack();
				homePage.setLocationRelativeTo(null);
			}
			
			else if (ars.next())
			{
				//take user to user home page
				AdminPage adminPage = new AdminPage();
				adminPage.setVisible(true);
				adminPage.pack();
				adminPage.setLocationRelativeTo(null);
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid User name password", "Log In Error", 2);
			}
			
			
		}catch(Exception ex) {
			throw ex;
		}
		
		
		return user;
	}
	
	//to check if the user name is already exists
	
	public boolean checkUsername(String username, String email) throws Exception {
		PreparedStatement statement;
		ResultSet rs;
		boolean username_exist = false;
		boolean email_exist = false;
		
		String query = "SELECT * FROM Users WHERE username = ? AND email = ? ";
		
		try {
			statement = this.connection.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, email);
			rs = statement.executeQuery();
			
			if (rs.next()) {
				username_exist = true;
				JOptionPane.showMessageDialog(null, "This username is already taken, Choose another username","Username Invalid",2);
			}
			if (rs.next()) {
				email_exist = true;
				JOptionPane.showMessageDialog(null, "Account already created , Please LogIn","Email already used",2);
			}
		}catch(Exception ex) {
			throw ex;
		}
		return username_exist;
	}
	
	public Users userSave() throws Exception {
		
		if((!checkUsername(user.getUserName(), user.getEmail()))) {
			PreparedStatement statement;
			ResultSet rs;
			String registerUserQuery = "INSERT INTO Users (email, userName, password) VALUES (?,?,?)";
		try {
			
				String[] userID = new String[] { "id" };
				
				statement = this.connection.prepareStatement(registerUserQuery, userID);
				statement.setString(1, this.user.getEmail());
				statement.setString(2, this.user.getUserName());
				statement.setString(3, this.user.getPassword());
				
				try {
					
					if (statement.executeUpdate() !=0) {
						
						ResultSet generatedKeys = statement.getGeneratedKeys();
						 if ( generatedKeys.next() ) {
				                primkey = generatedKeys.getInt(1);
				            }
						JOptionPane.showMessageDialog(null, "Your Account has been created ");
					}
					else {
						JOptionPane.showInternalMessageDialog(null, "Please Check Your Information");
					}
			
				} catch (Exception ex) {
					throw ex;
				}
		
		
		} catch (Exception ex) {
			throw ex;
		}
	}
		return user;
}

	
}