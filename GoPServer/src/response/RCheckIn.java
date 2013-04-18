package response;

import java.io.DataOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import resources.*;

import org.json.JSONException;
import org.json.JSONObject;

public class RCheckIn extends Response {
	
	private String location;
	private Map<String,Resources> resourceMap = new HashMap<String,Resources>();

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
	public void execute(DataOutputStream out) throws Exception{
		super.execute(out);
		JSONObject resourceResponse = new JSONObject();
		try{
			resourceResponse.accumulate("game_info", location);
		}catch (JSONException e){
			e.printStackTrace();
		}
	}
	
	
	/* Will more than likely need to change the values of each key, as they may not match exactly what we get from 
	 * Foursquare on the client side. For now, they are fine the way they are...
	 */
	public void generateResourcesMap(){
		resourceMap.put("Arts & Entertainment", new Resources(0.65f, 0.025f, 0.025f, 0.025f, 0.25f, 0.025f));
		resourceMap.put("College $ University", new Resources(0.05f, 0.75f, 0.05f, 0.05f, 0.05f, 0.05f));
		resourceMap.put("Food", new Resources(0.02f, 0.02f, 0.02f, 0.02f, 0.02f, 0.9f));
		resourceMap.put("Professional & Other Places", new Resources(0.132f, 0.33f, 0.132f, 0.132f, 0.132f, 0.132f));
		resourceMap.put("Nightlife Spots", new Resources(0.33f, 0.07667f, 0.07667f, 0.07667f, 0.33f, 0.1f));
		resourceMap.put("Residences", new Resources(0.16667f, 0.16667f, 0.16667f, 0.16667f, 0.16667f, 0.16667f));
		resourceMap.put("Great Outdoors", new Resources(0.08333f, 0.08333f, 0.15f, 0.45f, 0.08333f, 0.15f));
		resourceMap.put("Shops & Services", new Resources(0.1f, 0.2f, 0.06667f, 0.06667f, 0.06667f, 0.5f));
		resourceMap.put("Travel & Transport", new Resources(0.025f, 0.025f, 0.85f, 0.025f, 0.05f, 0.025f));
	}
	
	public Resources getResourcesForCheck(){
		return null;
	}
}
