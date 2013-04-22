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
					new BuyVPRequest(), 
					new CheckInRequest(), 
					new CreateGameRequest(),
					new GetGameListRequest(),
					new GetGameRequest(),
					new GetGamesRequest(),
					new GetPlayerListRequest(),
					new JoinGameRequest(),
					new ResignRequest(),
					new UpgradeBuildingRequest(),
					new LoginRequest()};
		}
		return commandArray;

	}

	/* checkin {parents:[(x),(y)...], id:"___"}
	 *    * This will check the user in. 
	 * create_game {id:"____"}
	 *    * Create a new game with the user as the first player.
	 * join_game {id:"_____",game_id:"______"}
	 *    * User isn't currently in the game. This command will add them to the list of players.
	 * get_current_games {id:"______"}
	 *    * Returns list of games user is playing in.
	 * get_game_list {}
	 *    * Returns list of available games that the user can join.
	 * get_game {id:"______", game_id:"_____"}
	 *    * Sends back resources, building info, VP count, etc. 
	 * upgrade_building {id:"____", game_id:"____", building_id:[0-5]}
	 *    * Checks resource bank for player, and attempts to upgrade a building.
	 * buy_vp {id:"______", game_id:"_____"}
	 *    * Checks resource bank and rewards player if they have sufficient resources.
	 * resign {id:"_____", game_id:"_______"}
	 *    * Removes user from designated game.
	 * get_player_list {game_id:"_______"}
	 *    * Returns list of users to player for a specified game.
	 */
}
