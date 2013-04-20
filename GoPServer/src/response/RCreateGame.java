package response;

import gameResources.Game;
import gameResources.Player;

import java.io.DataOutputStream;
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

	public void execute(DataOutputStream out) throws Exception {
		ArrayList<Player> playerList = new ArrayList<Player>();
		playerList.add(new Player(userID, gameID, dbConn));
		playerList.get(0).createPlayer();
		Game newGame = new Game(gameID, gameName, maxPlayerCount, mapName, conquestPoints, playerList, dbConn);

		
		System.out.println("Creating a game for user " + super.userID + " with game number " + super.gameID);
		super.execute(out);
	}

	private void pushNewGame() {

		try{
			Statement gameStatement = dbConn.createStatement();
			gameStatement.executeUpdate("INSERT INTO game(game_id,turn_number,name,map,max_players,conquest_points) VALUES ("+gameID+",0,"+gameName+","+mapName+","+maxPlayerCount+","+conquestPoints+");");
			gameStatement.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public void pushNewPlayer() {
		try{
			Statement playerStatement = dbConn.createStatement();
			playerStatement.executeUpdate("INSERT INTO player(id,game_id,conquest_points,factory_level,studio_level,temple_level,lab_level,agency_level,"
					+ "artifacts, blueprints,fuel,material,luxuries,produce) VALUES ("+userID+","+gameID+",0,0,0,0,0,0,0,0,0,0,0,0);");
			System.out.println(userID);
			playerStatement.close();
		} catch (Exception e){
			e.printStackTrace();
		} 
	}
}
