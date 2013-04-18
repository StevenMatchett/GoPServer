package response;

//import jdbc for postgres
import java.io.DataOutputStream;
import java.sql.*;
import java.util.Properties;
import org.json.JSONObject;
import org.json.JSONException;

public abstract class Response {
	
	private String userID;
	private int gameID;
	private final String dbURL = "jdbc:postgresql://54.225.205.16:5432/Gameofphones";
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
		props.setProperty("user","Steven"); //Replace these values with the actual login later.
		props.setProperty("password", "pass");
		dbConn = DriverManager.getConnection(dbURL, props);
	}
	
	public void pushToDatabase(String query){
		/* Delete Example code:
		 * int foovalue = 500;
		 * PreparedStatement st = dbConn.prepareStatement("DELETE FROM mytable WHERE columnfoo = ?");
		 * st.setInt(1, foovalue);
		 * int rowsDeleted = st.executeUpdate();
		 * System.out.println(rowsDeleted + " rows deleted");
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
		//Why won't it commit..
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
	
	public void execute(DataOutputStream out) throws Exception{
		Class.forName("org.json.JSONObject");
		JSONObject baseResponse = new JSONObject(); 
		try {
			baseResponse.accumulate("id_info", userID);
			baseResponse.append("id_info", gameID);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		out.writeBytes(baseResponse.toString());
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
