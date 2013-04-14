package response;

import java.io.DataOutputStream;

public class RCheckIn extends Response {
	
	private String location;

	public RCheckIn(String userID, int gameID, int buildingID) {
		super(userID, gameID, buildingID);
	}

	public RCheckIn(String userID, int gameID) {
		super(userID, gameID);
	}

	public RCheckIn(String userID) {
		super(userID);
	}

	public RCheckIn(int gameID) {
		super(gameID);
	}
	
	public RCheckIn(String userID, String location){
		super(userID);
		this.location = location;
	}
	
	@Override
	public void execute(DataOutputStream out){
		
	}

}
