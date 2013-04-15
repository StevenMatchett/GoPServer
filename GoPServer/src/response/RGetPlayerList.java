package response;

public class RGetPlayerList extends Response {

	public RGetPlayerList(String userID, int gameID) {
		super(userID, gameID);
	}

	public RGetPlayerList(String userID) {
		super(userID);
	}

	public RGetPlayerList(int gameID) {
		super(gameID);
	}
}
