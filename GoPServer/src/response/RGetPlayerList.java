package response;

import gameResources.Game;

import java.io.DataOutputStream;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

public class RGetPlayerList extends Response {

	public RGetPlayerList(String userID, int gameID) {
		super(userID, gameID);
	}

	public RGetPlayerList(String userID) {
		super(userID);
	}

	public RGetPlayerList(int gameID) {
		super(gameID);
	}
	
	public void execute(DataOutputStream out) throws IOException {
		Game game = super.selectGame();
		game.getFromDatabase();
		try {
			JSONObject returnJSON = new JSONObject("{\"games\":[" + game.toString() + "]}");
			out.writeBytes(returnJSON.toString());
		} catch (JSONException e) {
			e.printStackTrace();
			super.execute(out);
		}
	}
}
