package response;

public class RGetGamesList extends Response {

	public RGetGamesList(String userID, int gameID) {
		super(userID, gameID);
	}

	public RGetGamesList(String userID) {
		super(userID);
	}

	public RGetGamesList(int gameID) {
		super(gameID);
	}
}
