package gameResources;

import java.util.ArrayList;

public class Game {
	
	private int gameID;
	private String gameName;
	private int maxPlayers;
	private String mapName;
	private int maxConquestPoints;
	private ArrayList<Player> players;
	
	public Game(){}
	
	public Game(int id, String name, int maxp, String map, int maxCP, ArrayList<Player> playerList){
		gameID = id;
		gameName = name;
		maxPlayers = maxp;
		mapName = map;
		maxConquestPoints = maxCP;
		players = playerList;
	}
	
	public String toString() {
		//{"games":[
		//{"game_id":123,"name":"name","maxplayers":2,"map":"death rock","conquest_points":7,"players":[]} <--Just this line goes in this method
		//]}
		StringBuffer result = new StringBuffer();
		result.append("{\"game_id\":"+gameID+",\"name\":\""+gameName+"\",\"maxplayers\":"+maxPlayers+",\"map\":\""+mapName+"\",\"conquest_points\":"+maxConquestPoints+",\"players\":[");
		for(Player p : players){
			result.append(p.toString());
		}
		result.append("]}");
		
		return result.toString();
	}

	public int getGameID() {
		return gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	public String getMapName() {
		return mapName;
	}

	public void setMapName(String mapName) {
		this.mapName = mapName;
	}

	public int getMaxConquestPoints() {
		return maxConquestPoints;
	}

	public void setMaxConquestPoints(int maxConquestPoints) {
		this.maxConquestPoints = maxConquestPoints;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

}
