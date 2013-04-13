package request;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetGamesRequest implements IRequest {

	private static final Pattern pattern = Pattern.compile("RegexStringGoesHere",Pattern.CASE_INSENSITIVE);
	
	@Override
	public boolean matches(String input) {
		Matcher matcher = pattern.matcher(input.trim());
		
		if(matcher.matches()) {
			//If a request class has any Regex groups, set those variables = Group# here.
			return true;
		}
		
		return false;
	}

	@Override
	public void execute() {
		//Create a SendGamesResponse, execute that.
	}
}
