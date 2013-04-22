package response;

import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

public class RLogin extends Response {

	private String userName;
	
	public RLogin(String userID, String uN) {
		super(userID);
		userName = uN;
	}
	
	public void loginAccount(){
		try {
			Statement accountStatement = dbConn.createStatement();
			accountStatement.executeUpdate("INSERT INTO account(id, alias) VALUES ('"+userID+"','"+userName+"');");
			System.out.println("User " + userName + "has been added to the database");
		}catch(SQLException e){
			System.out.println("Account already exists in database. Logging user in.");
		}
	}
	
	public void execute(DataOutputStream out) throws IOException{
		loginAccount();
		System.out.println("User ID " + userID +" with name " + userName + " has logged in.");
		super.execute(out);
	}

}
