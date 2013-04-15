package response;

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
}
