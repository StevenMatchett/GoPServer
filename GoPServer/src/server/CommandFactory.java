package server;

import request.*;

public class CommandFactory {

	private static IRequest[] commandArray;

	/**
	 * First tests to see if the array is currently initialized, if not it is created.<br>
	 * Returns the array.<br>
	 * @return an array of ICommands.
	 */
	public IRequest[] getCommands() {

		if (commandArray == null) {
			commandArray = new IRequest[] { 
					new GetGamesRequest() };
		}
		return commandArray;

	}

}
