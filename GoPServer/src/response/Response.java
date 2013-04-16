package response;

//import jdbc for postgres
import java.io.DataOutputStream;
import java.sql.*;
import java.util.Properties;
import org.json.*;

public abstract class Response {
	
	private String userID;
	private int gameID;
	private final String dbURL = "jdbc:postgresql://host:port/database";
	private Connection dbConn;
	
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
	
	private void initDBConnection() throws Exception{
		Class.forName("org.postgresql.Driver");
		Properties props = new Properties();
		props.setProperty("user","admin"); //Replace these values with the actual login later.
		props.setProperty("password", "pass");
		dbConn = DriverManager.getConnection(dbURL, props);
	}
	
	public void pushToDatabase(){
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
		
		/* Delete Example code:
		 * int foovalue = 500;
		 * PreparedStatement st = dbConn.prepareStatement("DELETE FROM mytable WHERE columnfoo = ?");
		 * st.setInt(1, foovalue);
		 * int rowsDeleted = st.executeUpdate();
		 * System.out.println(rowsDeleted + " rows deleted");
		 * st.close();
		 */
	}
	
	public void execute(DataOutputStream out){
		JSONObject baseResponse = new JSONObject(); 
		try {
			baseResponse.accumulate("userid", userID);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		//out.writeBytes(""); Use this to send a string out of the socket to the client. The output stream already
		//has the socket information.
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
