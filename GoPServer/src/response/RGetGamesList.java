package response;

public class RGetGamesList extends Response {

	public RGetGamesList(String userID, int gameID, int buildingID) {
		super(userID, gameID, buildingID);
		// TODO Auto-generated constructor stub
	}

	public RGetGamesList(String userID, int gameID) {
		super(userID, gameID);
		// TODO Auto-generated constructor stub
	}

	public RGetGamesList(String userID) {
		super(userID);
		// TODO Auto-generated constructor stub
	}

	public RGetGamesList(int gameID) {
		super(gameID);
		// TODO Auto-generated constructor stub
	}

}
