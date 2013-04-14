package request;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import response.RCheckIn;
import response.Response;

public class CheckInRequest implements IRequest {
	
	//Make sure that a checkin request sends action=checkin, and not action=login.
	private static final Pattern pattern = Pattern.compile("GET /action=checkin&user_id=(.+)&.*",Pattern.CASE_INSENSITIVE);
	private String location = "test"; //Checkin request needs to send in the category of the location it's checked into.
	private String userID;
	
	@Override
	public boolean matches(String input) {
		Matcher matcher = pattern.matcher(input.trim());
		if(matcher.matches()) {
			userID = matcher.group(1).trim();
			location = matcher.group(2).trim();
			return true;
		}
		return false;
	}

	@Override
	public Response execute() {
		System.out.println(userID + " " + location);
		return new RCheckIn(userID, location);
	}

}
