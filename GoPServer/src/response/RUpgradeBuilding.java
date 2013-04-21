package response;

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
		//Adam you should fix the resource amounts, so I'm not pulling shit out of my ass.
		if(building.equalsIgnoreCase("Agency")){	
			player.setAgencyLvl(player.getAgencyLvl()+1);
			player.setNumBlueprints(player.getNumBlueprints()-1);
			player.setNumMaterial(player.getNumMaterial()-1);
			player.setNumProduce(player.getNumProduce()-1);
		}else if(building.equalsIgnoreCase("Factory")){
			player.setFactoryLvl(player.getFactoryLvl()+1);
			player.setNumBlueprints(player.getNumBlueprints()-1);
			player.setNumMaterial(player.getNumMaterial()-1);
			player.setNumFuel(player.getNumFuel()-1);
		}else if(building.equalsIgnoreCase("Lab")){
			player.setLabLvl(player.getLabLvl()+1);
			player.setNumBlueprints(player.getNumBlueprints()-2);
			player.setNumMaterial(player.getNumMaterial()-1);
		}else if(building.equalsIgnoreCase("Studio")){
			player.setStudioLvl(player.getStudioLvl()+1);
			player.setNumBlueprints(player.getNumBlueprints()-1);
			player.setNumMaterial(player.getNumMaterial()-2);
		}else{
			player.setTempleLvl(player.getTempleLvl()+1);
			player.setNumBlueprints(player.getNumBlueprints()-1);
			player.setNumArtifacts(player.getNumArtifacts()-2);
		}
		
		player.updateDatabaseRecord();
		super.execute(out);
	}
}
