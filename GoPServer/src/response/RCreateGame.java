package response;

public class RCreateGame extends Response {
	
	public RCreateGame(int gameID) {
		super(gameID);
	}
	
	public RCreateGame(String userID, int gameID) {
		super(userID, gameID);
	}
	
	public RCreateGame(String userID) {
		super(userID);
	}		
}
