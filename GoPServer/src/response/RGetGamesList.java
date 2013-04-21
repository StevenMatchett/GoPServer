package response;

import gameResources.Game;

import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONObject;

public class RGetGamesList extends Response {

	public RGetGamesList(String userID, int gameID) {
		super(userID, gameID);
	}

	public RGetGamesList(String userID) {
		super(userID);
	}

	public RGetGamesList(int gameID) {
		super(gameID);
	}
	
	//It probably works. Will have to be tested; specifically the JSON.
	public void execute(DataOutputStream out) throws IOException {
		ArrayList<Game> gameList = new ArrayList<Game>();
		try {
			JSONObject returnJSON = new JSONObject();
			Statement st = dbConn.createStatement();
			ResultSet rs = st.executeQuery("SELECT game_id FROM game EXCEPT SELECT game_id FROM player WHERE player.id = '"+userID+"';");
			while(rs.next()){
				game = new Game(rs.getInt(1), dbConn);
				game.getFromDatabase();
				gameList.add(game);
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
