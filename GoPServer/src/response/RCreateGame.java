package response;

import java.io.DataOutputStream;
import server.*;

public class RCreateGame extends Response {

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
		super.gameName = lobbyName;
		super.mapName = map;
		super.conquestPointWinCondition = pointsCount;
		super.maxPlayerCount = playerCount;
	}

	public void execute(DataOutputStream out) throws Exception {
		initDBConnection();
		System.out.println("Creating a game for user " + super.userID
				+ " with gameID ");
		pushToDatabase("INSERT INTO game(game_id,turn_number,name,map,max_players,conquest_points) VALUES ((SELECT count(*) from game)+1,0,'"
				+ super.gameName
				+ "','"
				+ super.mapName
				+ "',"
				+ super.maxPlayerCount
				+ ","
				+ super.conquestPointWinCondition
				+ ");");
		pushToDatabase("INSERT INTO player(id,game_id,conquest_points,factory_level,studio_level,temple_level,lab_level,agency_level,"
				+ "artifacts, blueprints,fuel,material,luxuries,produce) VALUES ('"
				+ super.userID
				+ "',(SELECT count(*) from game),"
				+ "0,0,0,0,0,0,0,0,0,0,0,0);");
		super.execute(out);
	}
}
