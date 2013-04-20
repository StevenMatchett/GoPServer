package response;

import java.io.DataOutputStream;
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
	public void execute(DataOutputStream out) {
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
