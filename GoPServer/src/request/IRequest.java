package request;

import response.Response;

public interface IRequest {
	
	public boolean matches(String input);
	
	public Response execute();
}
