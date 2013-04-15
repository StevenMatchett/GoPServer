package response;

public class RBuyVP extends Response {

	public RBuyVP(String userID, int gameID) {
		super(userID, gameID);
	}

	public RBuyVP(String userID) {
		super(userID);
	}

	public RBuyVP(int gameID) {
		super(gameID);
	}

}
