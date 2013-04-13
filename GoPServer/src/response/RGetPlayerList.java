package response;

public class RGetPlayerList extends Response {

	public RGetPlayerList(String userID, int gameID, int buildingID) {
		super(userID, gameID, buildingID);
		// TODO Auto-generated constructor stub
	}

	public RGetPlayerList(String userID, int gameID) {
		super(userID, gameID);
		// TODO Auto-generated constructor stub
	}

	public RGetPlayerList(String userID) {
		super(userID);
		// TODO Auto-generated constructor stub
	}

	public RGetPlayerList(int gameID) {
		super(gameID);
		// TODO Auto-generated constructor stub
	}

}
