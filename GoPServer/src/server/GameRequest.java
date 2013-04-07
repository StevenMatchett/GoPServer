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

		System.out.println("\n" + requestLine);

		String headerline = null;
		while ((headerline = br.readLine()).length() != 0)
		{
			System.out.println(headerline);
		}
		

		//Construct the response message.
		String entityBody;

		entityBody = requestLine;
		//Echoes request back to client.
		os.writeBytes(entityBody);
		


		os.close();
		br.close();
		socket.close();
	}
}
