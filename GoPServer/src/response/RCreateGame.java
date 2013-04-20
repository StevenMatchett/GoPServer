package response;

import gameResources.Game;
import gameResources.Player;

import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.Statement;
import java.util.ArrayList;

public class RCreateGame extends Response {

	private String gameName;
	private int maxPlayerCount;
	private String mapName;
	private int conquestPoints;

	public RCreateGame(int gameID) {
		super(gameID);
	}

	public RCreateGame(String userID, int gameID) {
		super(userID, gameID);
	}

	public RCreateGame(String userID) {
		super(userID);
	}

	public RCreateGame(String userID, String lobbyName, String map,
			int pointsCount, int playerCount) {
		super(userID);
		gameName = lobbyName;
		mapName = map;
		conquestPoints = pointsCount;
		maxPlayerCount = playerCount;
	}

	public void execute(DataOutputStream out) throws IOException {
		ArrayList<Player> playerList = new ArrayList<Player>();
		playerList.add(new Player(userID, gameID, dbConn));
		playerList.get(0).createPlayer();
		Game newGame = new Game(gameID, gameName, maxPlayerCount, mapName, conquestPoints, playerList, dbConn);
		newGame.createGame();
		
		System.out.println("Creating a game for user " + super.userID + " with game number " + super.gameID);
		super.execute(out);
	}
}
