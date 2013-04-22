package response;

import gameResources.Buildings;
import gameResources.Player;

import java.io.DataOutputStream;
import java.io.IOException;

public class RUpgradeBuilding extends Response {

	private String building;

	public RUpgradeBuilding(String userID, int gameID, String buildingID) {
		super(userID, gameID);
		this.building = buildingID;
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

	public void execute(DataOutputStream out) throws IOException {
		Player player = super.selectPlayer();
		Buildings buildingsHandler = new Buildings(player, building);
		buildingsHandler.updatePlayerBuildings();
		super.execute(out);
	}
}
