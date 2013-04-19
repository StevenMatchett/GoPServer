package request;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import response.RCreateGame;
import response.Response;

public class CreateGameRequest implements IRequest {
	
	//GET /action=create_game&user_id=null HTTP/1.1 User-Agent: Dalvik/1.6.0 (Linux; U; Android 4.2.2; SCH-I535 Build/JDQ39) Host: 54.225.205.16:46789 Connection: Keep-Alive Accept-Encoding: gzip
	private static final Pattern pattern = Pattern.compile("GET /action=new_game&user_id=(.+)&lobby_name=(.+)&map=(.+)&points=(.+)&players=(.+)",Pattern.CASE_INSENSITIVE);
	//private int gameID;
	private String userID;
	private String lobbyName;
	private String map;
	private int pointsCount;
	private int playerCount;

	@Override
	public boolean matches(String input) {
		Matcher matcher = pattern.matcher(input.trim());
		if(matcher.matches()) {
			userID = matcher.group(1).trim();
			lobbyName = matcher.group(2).trim();
			map = matcher.group(3).trim();
			pointsCount = Integer.parseInt(matcher.group(4));
			playerCount = Integer.parseInt(matcher.group(5));
			//gameID = Integer.parseInt(matcher.group(2).trim());
			return true;
		}
		return false;
	}

	@Override
	public Response execute() {
		return new RCreateGame(userID, lobbyName, map, pointsCount, playerCount);
	}
}
