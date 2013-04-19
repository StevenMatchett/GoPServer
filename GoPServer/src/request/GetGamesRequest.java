package request;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import response.RGetCurrentGames;
import response.Response;

public class GetGamesRequest implements IRequest {

	//GET /action=get_games&user_id=null HTTP/1.1 User-Agent: Dalvik/1.6.0 (Linux; U; Android 4.2.2; SCH-I535 Build/JDQ39) Host: 54.225.205.16:46789 Connection: Keep-Alive Accept-Encoding: gzip
	private static final Pattern pattern = Pattern.compile("action=get_games&user_id=(.+)",Pattern.CASE_INSENSITIVE);
	private String userID;

	@Override
	public boolean matches(String input) {
		Matcher matcher = pattern.matcher(input.trim());
		if(matcher.matches()) {
			userID = matcher.group(1).trim();
			//gameID = Integer.parseInt(matcher.group(2).trim());
			return true;
		}
		return false;
	}

	@Override
	public Response execute() {
		System.out.println(userID);
		return new RGetCurrentGames(userID);
	}
}
