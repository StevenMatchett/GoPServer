package request;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import response.RResign;
import response.Response;

public class ResignRequest implements IRequest {

	//GET /action=resign&user_id=null&game_id=value HTTP/1.1 User-Agent: Dalvik/1.6.0 (Linux; U; Android 4.2.2; SCH-I535 Build/JDQ39) Host: 54.225.205.16:46789 Connection: Keep-Alive Accept-Encoding: gzip
		private static final Pattern pattern = Pattern.compile("action=resign&user_id=(.+)&game_id=(.+)",Pattern.CASE_INSENSITIVE);
		private String userID;
		private int gameID;

		@Override
		public boolean matches(String input) {
			Matcher matcher = pattern.matcher(input.trim());
			if(matcher.matches()) {
				userID = matcher.group(1).trim();
				gameID = Integer.parseInt(matcher.group(2).trim());
				return true;
			}
			return false;
		}

		@Override
		public Response execute() {
			System.out.println(userID + " " + gameID);
			return new RResign(userID, gameID);
		}
	}
