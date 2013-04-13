package server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class GameRequest implements Runnable
{
	Socket socket;


	public GameRequest(Socket socket) throws Exception
	{
		this.socket = socket;
	}

	public void run()
	{
		try {
			processRequest();
		} catch (Exception e) {e.printStackTrace();}
	}

	private void processRequest() throws Exception
	{
		DataOutputStream os = new DataOutputStream(socket.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String requestLine = br.readLine(); 
		
		//Echo the input for debugging.
		System.out.println("\n" + requestLine);

//		String contentBody = null;
//		while ((contentBody = br.readLine()).length() != 0)
//		{
//			//Debug for now.
//			System.out.println(contentBody);
//		}
		
		CommandParser parseString = new CommandParser();
		
		//This will create the proper request & execute it. The execution will make a response and run *that*.
		parseString.matchCommand(requestLine);		
				
		//Echoes request back to client. This will be encapsulated into the Response Classes later.
		os.writeBytes(requestLine);
		os.close();
		br.close();
		socket.close();
	}
}
