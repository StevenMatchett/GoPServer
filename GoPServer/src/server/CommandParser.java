package server;

import request.*;
import response.Response;
import server.CommandFactory;

public class CommandParser {

	public CommandParser() {}

	public Response matchCommand(String cmdInput){

		IRequest[] commandArray = new CommandFactory().getCommands();                           		

		for(int j = 0; j <= commandArray.length; j++){
			if(commandArray[j].matches(cmdInput))
				return commandArray[j].execute();
		}

		return null;
	}
}

