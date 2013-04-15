package response;

public class RResign extends Response {

	public RResign(String userID, int gameID) {
		super(userID, gameID);
	}

	public RResign(String userID) {
		super(userID);
	}

	public RResign(int gameID) {
		super(gameID);
	}
}
