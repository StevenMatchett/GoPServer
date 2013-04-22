package request;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import response.RBuyVP;
import response.Response;

public class BuyVPRequest implements IRequest {
	
	//GET /action=buy_vp&user_id=null&game_id=value HTTP/1.1 User-Agent: Dalvik/1.6.0 (Linux; U; Android 4.2.2; SCH-I535 Build/JDQ39) Host: 54.225.205.16:46789 Connection: Keep-Alive Accept-Encoding: gzip
	private static final Pattern pattern = Pattern.compile("action=buy_vp&user_id=(.+)&game_id=(.+)&artifacts=(.+)&blueprints=(.+)&fuel=(.+)&materials=(.+)&luxuries=(.+)&food=(.+)",Pattern.CASE_INSENSITIVE);
	private int gameID;
	private String userID;
	private int artifacts;
	private int blueprints;
	private int fuel;
	private int materials;
	private int luxuries;
	private int food;

	@Override
	public boolean matches(String input) {
		Matcher matcher = pattern.matcher(input.trim());
		if(matcher.matches()) {
			userID = matcher.group(1).trim();
			gameID = Integer.parseInt(matcher.group(2).trim());
			artifacts = Integer.parseInt(matcher.group(3));
			blueprints = Integer.parseInt(matcher.group(4));
			fuel = Integer.parseInt(matcher.group(5));
			materials = Integer.parseInt(matcher.group(6));
			luxuries = Integer.parseInt(matcher.group(7));
			food = Integer.parseInt(matcher.group(8));
			return true;
		}
		return false;
	}

	@Override
	public Response execute() {
		System.out.println(userID + " " + gameID);
		return new RBuyVP(userID, gameID, artifacts, blueprints, fuel, materials, luxuries, food);
	}
}
