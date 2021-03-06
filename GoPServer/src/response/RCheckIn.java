package response;

import gameResources.*;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class RCheckIn extends Response {

	private String location;
	private ArrayList<Player> playerObjects = new ArrayList<Player>();
	private Resources resourceSet;

	public RCheckIn(String userID, int gameID) {
		super(userID, gameID);
	}

	public RCheckIn(String userID) {
		super(userID);
	}

	public RCheckIn(int gameID) {
		super(gameID);
	}

	public RCheckIn(String userID, String location){
		super(userID);
		this.location = location;
	}

	@Override
	public void execute(DataOutputStream out) throws IOException{
		//Select all Players for a userid.
		//"SELECT player_id FROM players WHERE players.user_id = "+userID+";"
		playerObjects = super.selectPlayers();
		setResources();
		//Generate resources based on location & update Player Objects
		for(Player p : playerObjects){
			p.getFromDatabase();
			resourceSet.generateResources(p.getLabLvl());
			p.setNumArtifacts(p.getNumArtifacts() + resourceSet.getArtifact());
			p.setNumBlueprints(p.getNumBlueprints() + resourceSet.getBlueprints());
			p.setNumFuel(p.getNumFuel() + resourceSet.getFood());
			p.setNumLuxuries(p.getNumLuxuries() + resourceSet.getLuxuries());
			p.setNumMaterial(p.getNumMaterial() + resourceSet.getMaterials());
			p.setNumProduce(p.getNumProduce() + resourceSet.getFood());

			//update db entries
			p.updateDatabaseRecord();
		}
		super.execute(out);
	}


	/* Will more than likely need to change the values of each key, as they may not match exactly what we get from 
	 * Foursquare on the client side. For now, they are fine the way they are...
	 */
	public void setResources(){
		if(location.equalsIgnoreCase("Arts & Entertainment"))
			resourceSet = new Resources(0.65f, 0.025f, 0.025f, 0.025f, 0.25f, 0.025f);
		else if(location.equalsIgnoreCase("College & University"))
			resourceSet = new Resources(0.05f, 0.75f, 0.05f, 0.05f, 0.05f, 0.05f);
		else if(location.equalsIgnoreCase("Food"))
			resourceSet = new Resources(0.02f, 0.02f, 0.02f, 0.02f, 0.02f, 0.9f);
		else if(location.equalsIgnoreCase("Professional & Other Places"))
			resourceSet = new Resources(0.132f, 0.33f, 0.132f, 0.132f, 0.132f, 0.132f);
		else if(location.equalsIgnoreCase("Nightlife Spot"))
			resourceSet = new Resources(0.33f, 0.07667f, 0.07667f, 0.07667f, 0.33f, 0.1f);
		else if(location.equalsIgnoreCase("Residences"))
			resourceSet = new Resources(0.16667f, 0.16667f, 0.16667f, 0.16667f, 0.16667f, 0.16667f);
		else if(location.equalsIgnoreCase("Great Outdoors"))
			resourceSet = new Resources(0.08333f, 0.08333f, 0.15f, 0.45f, 0.08333f, 0.15f);
		else if(location.equalsIgnoreCase("Shops & Services"))
			resourceSet = new Resources(0.1f, 0.2f, 0.06667f, 0.06667f, 0.06667f, 0.5f);
		else if(location.equalsIgnoreCase("Travel & Transport"))
			resourceSet = new Resources(0.025f, 0.025f, 0.85f, 0.025f, 0.05f, 0.025f);
		else
			resourceSet = new Resources(0, 0, 0, 0, 0, 0);
	}
}
