package response;

public class RJoinGame extends Response {

	public RJoinGame(String userID, int gameID, int buildingID) {
		super(userID, gameID, buildingID);
		// TODO Auto-generated constructor stub
	}

	public RJoinGame(String userID, int gameID) {
		super(userID, gameID);
		// TODO Auto-generated constructor stub
	}

	public RJoinGame(String userID) {
		super(userID);
		// TODO Auto-generated constructor stub
	}

	public RJoinGame(int gameID) {
		super(gameID);
		// TODO Auto-generated constructor stub
	}

}
