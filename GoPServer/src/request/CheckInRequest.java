package request;

public class CheckInRequest implements IRequest {
	
	String elementsFromRequest = "";
	
	@Override
	public boolean matches(String input) {
		boolean result = false;
		
		if (input.substring(input.indexOf('='),input.indexOf('&')).compareTo("checkin") == 0){
			result = true;
			elementsFromRequest = input.substring(input.indexOf('&'),input.length());
		}
		return result;
	}

	@Override
	public void execute() {
		System.out.println(elementsFromRequest);
	}

}
