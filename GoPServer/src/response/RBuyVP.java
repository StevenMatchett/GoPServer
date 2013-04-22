package response;

import java.io.DataOutputStream;
import java.io.IOException;

import gameResources.Player;

public class RBuyVP extends Response {
	
	private int artifacts;
	private int blueprints;
	private int fuel;
	private int materials;
	private int luxuries;
	private int food;
	
	public RBuyVP(String userID, int gameID) {
		super(userID, gameID);
	}

	public RBuyVP(String userID) {
		super(userID);
	}

	public RBuyVP(int gameID) {
		super(gameID);
	}

	public RBuyVP(String userID, int gameID, int art, int blue, int fl, int mat, int lux, int foo) {
		super(userID, gameID);
		artifacts = art;
		blueprints = blue;
		fuel = fl;
		materials = mat;
		luxuries = lux;
		food = foo;
	}

	public void execute(DataOutputStream out) throws IOException{
		Player player = super.selectPlayer();
		if((artifacts+blueprints+fuel+materials+luxuries+food) >= (15 - player.getStudioLvl())){
			player.setNumArtifacts(player.getNumArtifacts() - artifacts);
			player.setNumBlueprints(player.getNumBlueprints() - blueprints);
			player.setNumFuel(player.getNumFuel() - fuel);
			player.setNumMaterial(player.getNumMaterial() - materials);
			player.setNumLuxuries(player.getNumLuxuries() - luxuries);
			player.setNumProduce(player.getNumProduce() - food);
			player.setConquestPoints(player.getConquestPoints() + 1);
			player.updateDatabaseRecord();
		}
		super.execute(out);
	}
}
