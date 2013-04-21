package response;

import gameResources.Game;

import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.json.JSONObject;

public class RGetCurrentGames extends Response {

	public RGetCurrentGames(String userID, int gameID) {
		super(userID, gameID);
	}

	public RGetCurrentGames(String userID) {
		super(userID);
	}

	public RGetCurrentGames(int gameID) {
		super(gameID);
	}
	
	//This will have to be tested; specifically the JSON.
	public void execute(DataOutputStream out) throws IOException {
		ArrayList<Game> gameList = new ArrayList<Game>();
		try {
			JSONObject returnJSON = new JSONObject();
			Statement st = dbConn.createStatement();
			ResultSet rs = st.executeQuery("SELECT game_id FROM player WHERE player.id = '"+userID+"';");
			while(rs.next()){
				gameList.add(new Game(rs.getInt(1), dbConn));
				game.getFromDatabase();
				returnJSON.accumulate("games", game.toString());
			}
			//Send JSON to phone.
			out.writeBytes(returnJSON.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			super.execute(out);
		}
	}
}
