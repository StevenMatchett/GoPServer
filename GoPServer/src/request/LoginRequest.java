package request;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import response.RLogin;
import response.Response;

public class LoginRequest implements IRequest {

	private static final Pattern pattern = Pattern.compile("action=login&user_id=(.+)&user_name=(.+)",Pattern.CASE_INSENSITIVE);
	private String userID;
	private String userName;
	
	@Override
	public boolean matches(String input) {
		Matcher matcher = pattern.matcher(input.trim());
		if(matcher.matches()){
			userID = matcher.group(1).trim();
			userName = matcher.group(2).trim();
			return true;
		}
		return false;
	}

	@Override
	public Response execute() {
		return new RLogin(userID, userName);
	}

}
