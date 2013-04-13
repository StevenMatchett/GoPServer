package server;

import request.*;
import server.CommandFactory;

public class CommandParser {
	
	public CommandParser() {}
	
	public void matchCommand(String cmdInput){

		IRequest[] commandArray = new CommandFactory().getCommands();                           		

		for(int j = 0; j <= 18; j++){
			if(j == 18)
				System.out.println("This is not a correct statement.");
			else{
				if(commandArray[j].matches(cmdInput)){
					commandArray[j].execute();
				}
			}
		}
	}
}
