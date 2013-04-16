package server;

import request.*;
import response.Response;
import server.CommandFactory;

public class CommandParser {

	public CommandParser() {}

	public Response matchCommand(String cmdInput){

		IRequest[] commandArray = new CommandFactory().getCommands();                           		
		Response response = null;
		
		try { 
			for(int j = 0; j < commandArray.length; j++){
				if(commandArray[j].matches(cmdInput)){
					response = commandArray[j].execute();
					break;
				}
			}
		} catch(NullPointerException e){
			System.out.println("Command sent found.");
		}

		return response;
	}
}

