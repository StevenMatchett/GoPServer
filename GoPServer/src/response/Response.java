package response;

//import jdbc for postgres

public abstract class Response {
	
	private String userID;
	private int gameID;
	private int buildingID;
	
	public Response(String userID, int gameID, int buildingID){
		this.userID = userID;
		this.gameID = gameID;
		this.buildingID = buildingID;
	}
	
	public Response(String userID, int gameID){
		this.userID = userID;
		this.gameID = gameID;
	}
	
	public Response(String userID){
		this.userID = userID;
	}
	
	public Response(int gameID){
		this.gameID = gameID;
	}
	
	public void pushToDatabase(){
		
	}
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getGameID() {
		return gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

	public int getBuildingID() {
		return buildingID;
	}

	public void setBuildingID(int buildingID) {
		this.buildingID = buildingID;
	}
}
