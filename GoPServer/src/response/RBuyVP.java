package response;

import java.io.DataOutputStream;
import java.io.IOException;

import gameResources.Player;

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

	public void execute(DataOutputStream out) throws IOException{
		Player player = super.selectPlayer();
		player.setConquestPoints(player.getConquestPoints()+1);
		//I don't know what we're using to purchase the conquest points, so fix this Adam.
		player.setNumLuxuries(player.getNumLuxuries()-3);
		player.updateDatabaseRecord();
		super.execute(out);
	}
}
