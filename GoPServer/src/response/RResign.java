package response;

import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

public class RResign extends Response {

	public RResign(String userID, int gameID) {
		super(userID, gameID);
	}

	public RResign(String userID) {
		super(userID);
	}

	public RResign(int gameID) {
		super(gameID);
	}
	
	public void execute(DataOutputStream out) throws IOException {
		try {
			Statement st = dbConn.createStatement();
			st.execute("DELETE FROM player WHERE (id ="+ userID +") AND (game_id = " + gameID + ");");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.execute(out);
	}
}
