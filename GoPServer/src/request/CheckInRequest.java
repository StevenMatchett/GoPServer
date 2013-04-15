package request;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import response.RCheckIn;
import response.Response;

public class CheckInRequest implements IRequest {
	
	//GET /action=checkin&user_id=null&location_category=null HTTP/1.1 User-Agent: Dalvik/1.6.0 (Linux; U; Android 4.2.2; SCH-I535 Build/JDQ39) Host: 54.225.205.16:46789 Connection: Keep-Alive Accept-Encoding: gzip
	//Make sure that a checkin request sends action=checkin, and not action=login.
	private static final Pattern pattern = Pattern.compile("GET /action=checkin&user_id=(.+)&location_category=(.+) HTTP.*",Pattern.CASE_INSENSITIVE);
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
