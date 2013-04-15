package response;

public class RUpgradeBuilding extends Response {

	private int buildingID;
	
	public RUpgradeBuilding(String userID, int gameID, int buildingID) {
		super(userID, gameID);
		this.buildingID = buildingID;
	}

	public RUpgradeBuilding(String userID, int gameID) {
		super(userID, gameID);
	}

	public RUpgradeBuilding(String userID) {
		super(userID);
	}

	public RUpgradeBuilding(int gameID) {
		super(gameID);
	}

}
