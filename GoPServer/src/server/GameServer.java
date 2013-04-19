package server;

import java.net.*;

public final class GameServer
{	
	public static void main(String argv[]) throws Exception
	{
		int port = 6789;
		@SuppressWarnings("resource")
		ServerSocket listenSocket = new ServerSocket(port);

		while (true)
		{
			
			Socket connectionSocket = listenSocket.accept();
			System.out.println("Incoming connection.");
			GameRequest request = new GameRequest(connectionSocket);
			Thread thread = new Thread(request);
			System.out.println("Starting thread.");
			thread.start();
		}
	}
}
