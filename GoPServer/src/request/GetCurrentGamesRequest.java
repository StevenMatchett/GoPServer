package request;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import response.RGetCurrentGames;
import response.Response;

public class GetCurrentGamesRequest implements IRequest {

	private static final Pattern pattern = Pattern.compile("GET /action=get_current_games&user_id=(.+)",Pattern.CASE_INSENSITIVE);;
	private String userID;
	
	@Override
	public boolean matches(String input) {
		Matcher matcher = pattern.matcher(input.trim());
		if(matcher.matches()) {
			userID = matcher.group(1).trim();
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
