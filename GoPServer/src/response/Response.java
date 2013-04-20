package response;

//import jdbc for postgres
import gameResources.Game;
import gameResources.Player;

import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import org.json.JSONObject;
import org.json.JSONException;

public abstract class Response {
	
	protected String userID;
	protected int gameID = (int) (Math.random() * Double.MAX_VALUE);
	protected Game game;
	protected Player player;
	
	protected final String dbURL = "jdbc:postgresql://localhost:5432/gameofphones";
	protected Connection dbConn;
	
	public Response(String userID, int gameID){
		this.userID = userID;
		this.gameID = gameID;
		
		try {
			initDBConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Response(String userID){
		this.userID = userID;
		
		try {
			initDBConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Response(int gameID){
		this.gameID = gameID;
		
		try {
			initDBConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void initDBConnection() throws Exception{
		Class.forName("org.postgresql.Driver");
		Properties props = new Properties();
		props.setProperty("user","stevenmatchett"); //Replace these values with the actual login later.
		props.setProperty("password", "pass");
		dbConn = DriverManager.getConnection(dbURL, props);
	}
	
	public Game getGame(){
		Game result = new Game(gameID, dbConn);
		result.getFromDatabase();
		return result;
	}
	
	public void pullFromDatabase(String query){
		/* Select Example code:
		 * Statement st = dbConn.createStatement();
		 * ResultSet rs = st.executeQuery("SELECT * FROM mytable WHERE column = 500");
		 * while (rs.next()) { //Must call rs.next() before using 'rs.getString(#)'
		 * System.out.print("Column 1 returned ");
		 * System.out.println(rs.getString(1));
		 * }
		 * rs.close();
		 * st.close();
		 */
		
		try {
			Statement st = dbConn.createStatement();
			ResultSet rs = st.executeQuery(query); 
			int i = 1;
			while (rs.next()) {
				System.out.println("Column: "+i);
				System.out.println(rs.getString(i));
				i++;
			}
			rs.close();
			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void execute(DataOutputStream out) throws IOException{
		try {
			Class.forName("org.json.JSONObject");
			JSONObject baseResponse;
			baseResponse = new JSONObject("{}");
			out.writeBytes(baseResponse.toString());
		} catch (Exception e) {
			e.printStackTrace();
			out.writeBytes(("{}"));
		} 
	}
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getGameID() {
		return gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}
}
