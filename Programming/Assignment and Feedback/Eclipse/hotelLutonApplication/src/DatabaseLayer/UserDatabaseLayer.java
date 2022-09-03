package DatabaseLayer;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Helper.DatabaseConnector;
import Models.Room;
import Models.Users;
import FrontendLayer.AdminPage;
import FrontendLayer.LogInBox;

import FrontendLayer.UserHomePage;

public class UserDatabaseLayer {

	private Users user;
	private DatabaseConnector db;
	private Connection connection;
	public static int userPrimeKey;
	public static int cusPrimeKey;
	public static int adminPrimeKey;
	public static int PrimKey;
	public static String uName;
	
	
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
		
		String customerQuery = "SELECT u.userID, c.cusID, u.userName FROM Users u INNER JOIN Customer c  ON u.userID  = c.userID WHERE u.userName = ? AND u.password = ? AND u.userType is NULL ";
		String adminQuery = "SELECT u.userID, a.adminID FROM Users u INNER JOIN Administration a  ON u.userID = a.userID WHERE u.userName = ? AND u.password = ? AND u.userType = 'receptionist'";
		
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
				
				userPrimeKey = crs.getInt(2);
				cusPrimeKey = crs.getInt(2);
				uName = crs.getString("userName");
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
				
				adminPrimeKey = ars.getInt(1);
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid User name / password", "Log In Error", 2);
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
			String registerUserQuery = "INSERT INTO Users (email, userName, password, userID) VALUES (?,?,?,?)";
		try {
			
			String generatedID[] = {"id"};
				
				statement = this.connection.prepareStatement(registerUserQuery, generatedID);
				statement.setString(1, this.user.getEmail());
				statement.setString(2, this.user.getUserName());
				statement.setString(3, this.user.getPassword());
				statement.setInt(4,UserDatabaseLayer.userPrimeKey);
				
				try {
					
					if (statement.executeUpdate() !=0) {
						
						ResultSet generatedKeys = statement.getGeneratedKeys();
						if ( generatedKeys.next() ) {
			                PrimKey = generatedKeys.getInt(1);
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