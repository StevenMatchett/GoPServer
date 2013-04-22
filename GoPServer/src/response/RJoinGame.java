package response;

import gameResources.Player;

import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		if(checkForMaxPlayers()){
			Player newPlayerForGame = new Player(userID, gameID, dbConn);
			newPlayerForGame.createPlayer();
			System.out.println(userID + " has been added to game " + gameID);
		}
		super.execute(out);	
	}
	
	public boolean checkForMaxPlayers(){
		try{
			Statement checkForMaxPlayers = dbConn.createStatement();
			ResultSet rs = checkForMaxPlayers.executeQuery("SELECT maxplayers,count(*) FROM game a JOIN player b ON (a.game_id = b.game_id) WHERE (game_id = " + gameID + ");");
			while(rs.next()){
				if(rs.getInt(1) > rs.getInt(2)){
					return true;
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
}
