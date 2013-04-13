package response;

public class RGetCurrentGames extends Response {

	public RGetCurrentGames(String userID, int gameID, int buildingID) {
		super(userID, gameID, buildingID);
		// TODO Auto-generated constructor stub
	}

	public RGetCurrentGames(String userID, int gameID) {
		super(userID, gameID);
		// TODO Auto-generated constructor stub
	}

	public RGetCurrentGames(String userID) {
		super(userID);
		// TODO Auto-generated constructor stub
	}

	public RGetCurrentGames(int gameID) {
		super(gameID);
		// TODO Auto-generated constructor stub
	}

}
