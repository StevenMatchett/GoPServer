package response;

//import jdbc for postgres
import java.io.DataOutputStream;
import java.sql.*;
import java.util.Properties;

public abstract class Response {
	
	private String userID;
	private int gameID;
	private int buildingID;
	private final String dbURL = "jdbc:postgresql://localhost/test";
	private Connection dbConn;
	
	public Response(String userID, int gameID, int buildingID) {
		this.userID = userID;
		this.gameID = gameID;
		this.buildingID = buildingID;
		
		try {
			initDBConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
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

	public int getBuildingID() {
		return buildingID;
	}

	public void setBuildingID(int buildingID) {
		this.buildingID = buildingID;
	}
}
