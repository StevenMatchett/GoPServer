package server;

import request.*;
import server.CommandFactory;

public class CommandParser {
	
	public CommandParser() {}
	
	public void matchCommand(String cmdInput){

		IRequest[] commandArray = new CommandFactory().getCommands();                           		

		for(int j = 0; j <= commandArray.length; j++){
			if(j == commandArray.length)
				System.out.println("This is not a correct statement.");
			else{
				try{
					if(commandArray[j].matches(cmdInput)){
						commandArray[j].execute();
						break;
					}
				}catch (StringIndexOutOfBoundsException e){
					System.out.println("Ignoring incoming command...");
				}
			}
		}
	}
}
