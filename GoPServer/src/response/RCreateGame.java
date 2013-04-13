package response;

public class RCreateGame extends Response {
	
	public RCreateGame(int gameID) {
		super(gameID);
	}
	
	public RCreateGame(String userID, int gameID, int buildingID) {
		super(userID, gameID, buildingID);
	}
	
	public RCreateGame(String userID, int gameID) {
		super(userID, gameID);
	}
	
	public RCreateGame(String userID) {
		super(userID);
	}		
}
