package response;

public class RGetCurrentGames extends Response {

	public RGetCurrentGames(String userID, int gameID) {
		super(userID, gameID);
	}

	public RGetCurrentGames(String userID) {
		super(userID);
	}

	public RGetCurrentGames(int gameID) {
		super(gameID);
	}
}
