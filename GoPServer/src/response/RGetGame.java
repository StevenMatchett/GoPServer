package response;

public class RGetGame extends Response {

	public RGetGame(String userID, int gameID, int buildingID) {
		super(userID, gameID, buildingID);
		// TODO Auto-generated constructor stub
	}

	public RGetGame(String userID, int gameID) {
		super(userID, gameID);
		// TODO Auto-generated constructor stub
	}

	public RGetGame(String userID) {
		super(userID);
		// TODO Auto-generated constructor stub
	}

	public RGetGame(int gameID) {
		super(gameID);
		// TODO Auto-generated constructor stub
	}

}
