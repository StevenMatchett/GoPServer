package response;

public class RCheckIn extends Response {

	public RCheckIn(String userID, int gameID, int buildingID) {
		super(userID, gameID, buildingID);
		// TODO Auto-generated constructor stub
	}

	public RCheckIn(String userID, int gameID) {
		super(userID, gameID);
		// TODO Auto-generated constructor stub
	}

	public RCheckIn(String userID) {
		super(userID);
		// TODO Auto-generated constructor stub
	}

	public RCheckIn(int gameID) {
		super(gameID);
		// TODO Auto-generated constructor stub
	}

}
