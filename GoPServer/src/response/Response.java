package response;

//import jdbc for postgres
import java.io.DataOutputStream;
import java.sql.*;
import java.util.Properties;
import org.json.JSONObject;
import org.json.JSONException;
import java.util.UUID;

public abstract class Response {
	
	protected String userID;
	//lelelelelelelelelelelelelelelele ^_^
	protected int gameID = (int) (Math.random() * (double)Integer.MAX_VALUE);
	protected String gameName;
	protected int maxPlayerCount;
	protected String mapName;
	protected int conquestPointWinCondition;
	
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
	
	public void pushNewPlayer() {
		PreparedStatement playerStatement = null;
		
		try{
			initDBConnection();
			playerStatement = dbConn.prepareStatement("INSERT INTO player(id,game_id,conquest_points,factory_level,studio_level,temple_level,lab_level,agency_level,"
					+ "artifacts, blueprints,fuel,material,luxuries,produce) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
			System.out.println(userID);
			playerStatement.setString(1, userID);
			playerStatement.setInt(2, gameID);
			playerStatement.setInt(3, 0);
			playerStatement.setInt(4, 0);
			playerStatement.setInt(5, 0);
			playerStatement.setInt(6, 0);
			playerStatement.setInt(7, 0);
			playerStatement.setInt(8, 0);
			playerStatement.setInt(9, 0);
			playerStatement.setInt(10, 0);
			playerStatement.setInt(11, 0);
			playerStatement.setInt(12, 0);
			playerStatement.setInt(13, 0);
			playerStatement.setInt(14, 0);
			playerStatement.executeUpdate();
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try{
				if (playerStatement != null)
					playerStatement.close();
				if (dbConn != null)
					dbConn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
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
			baseResponse.accumulate("games", userID);
			out.writeChars(baseResponse.toString());
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
