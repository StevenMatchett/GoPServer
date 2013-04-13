package request;

public interface IRequest {
	
	public boolean matches(String input);
	
	public void execute();
}
