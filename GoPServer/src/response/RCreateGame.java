package response;

import java.io.DataOutputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
		pushNewGame();
		pushNewPlayer();
		System.out.println("Creating a game for user " + super.userID + " with game number " + super.gameID);
		super.execute(out);
	}

	private  void pushNewGame() {
		PreparedStatement gameStatement = null;
		
		try{
			initDBConnection();
			gameStatement = dbConn.prepareStatement("INSERT INTO game(game_id,turn_number,name,map,max_players,conquest_points) VALUES (?,?,?,?,?,?);");
			gameStatement.setInt(1, gameID);
			gameStatement.setInt(2, 0);
			gameStatement.setString(3, gameName);
			gameStatement.setString(4, mapName);
			gameStatement.setInt(5, maxPlayerCount);
			gameStatement.setInt(6, conquestPointWinCondition);
			gameStatement.executeUpdate();
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try{
				if (gameStatement != null)
					gameStatement.close();
				if (dbConn != null)
					dbConn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}
