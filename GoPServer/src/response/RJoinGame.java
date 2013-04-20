package response;

import gameResources.Player;

import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.Statement;

public class RJoinGame extends Response {

	public RJoinGame(String userID, int gameID) {
		super(userID, gameID);
	}

	public RJoinGame(String userID) {
		super(userID);
	}

	public RJoinGame(int gameID) {
		super(gameID);
	}
	
	@Override
	public void execute(DataOutputStream out) throws IOException {
		Player newPlayerForGame = new Player(userID, gameID, dbConn);
		newPlayerForGame.createPlayer();
		System.out.println(userID + " has been added to game " + gameID);
		super.execute(out);
	}
}
