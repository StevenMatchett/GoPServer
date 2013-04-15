package response;

public class RGetGame extends Response {

	public RGetGame(String userID, int gameID) {
		super(userID, gameID);
	}

	public RGetGame(String userID) {
		super(userID);
	}

	public RGetGame(int gameID) {
		super(gameID);
	}
}
