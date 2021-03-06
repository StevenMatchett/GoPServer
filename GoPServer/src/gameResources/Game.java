package gameResources;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

public class Game implements GameObject {

	private int gameID;
	private String gameName;
	private int turn;
	private int maxPlayers;
	private String mapName;
	private int maxConquestPoints;
	private ArrayList<Player> players;
	private Connection dbConn;

	public Game() {
		gameID = (int) (Math.random()*Integer.MAX_VALUE);
	}

	public Game(int id, Connection db) {
		gameID = id;
		dbConn = db;
	}

	public Game(int id, String name, int maxp, String map, int maxCP,
			ArrayList<Player> playerList, Connection db) {
		gameID = id;
		gameName = name;
		turn = 0;
		maxPlayers = maxp;
		mapName = map;
		maxConquestPoints = maxCP;
		players = playerList;
		dbConn = db;
	}

	public JSONObject toJSON() {
		// {"games":[
		// {"game_id":123,"name":"name","maxplayers":2,"map":"death rock","conquest_points":7,"players":[]}<--Just this line goes in this method
		// ]}
		JSONObject gameObject = new JSONObject();
		try {
			gameObject.put("game_id", gameID);
			gameObject.put("name", gameName.trim());
			gameObject.put("maxplayers", maxPlayers);
			gameObject.put("map", mapName.trim());
			gameObject.put("conquest_points", maxConquestPoints);

			accumulatePlayers();
			for (Player p : players) {
				gameObject.append("players", p.toJSON());
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return gameObject;
	}

	public void getFromDatabase() {
		try {
			Statement st = dbConn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM game WHERE game_id="
					+ gameID + ";");
			while (rs.next()) {
				turn = Integer.parseInt(rs.getString(2));
				gameName = (rs.getString(3));
				mapName = (rs.getString(4));
				maxPlayers = Integer.parseInt(rs.getString(5));
				maxConquestPoints = Integer.parseInt(rs.getString(6));
			}
			rs.close();
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void accumulatePlayers() {
		try {
			players = new ArrayList<Player>();
			Statement st = dbConn.createStatement();
			ResultSet rs = st
					.executeQuery("SELECT * FROM player WHERE game_id=" + gameID + ";");
			Player player;
			while (rs.next()) {
				player = new Player(rs.getString(1), gameID, dbConn);
				player.getFromDatabase();
				players.add(player);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createGame() {
		try {
			Statement gameStatement = dbConn.createStatement();
			gameStatement
					.executeUpdate("INSERT INTO game(game_id,turn_number,name,map,max_players,conquest_points) VALUES ("
							+ gameID
							+ ","
							+ turn
							+ ",'"
							+ gameName
							+ "','"
							+ mapName
							+ "',"
							+ maxPlayers
							+ ","
							+ maxConquestPoints + ");");
			gameStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateDatabaseRecord() {
		try {
			Statement gameStatement = dbConn.createStatement();
			// playerStatement.executeUpdate("INSERT INTO player(id,game_id,conquest_points,factory_level,studio_level,temple_level,lab_level,agency_level,"
			// +
			// "artifacts, blueprints,fuel,material,luxuries,produce) VALUES ("+userID+","+gameID+",0,0,0,0,0,0,0,0,0,0,0,0);");
			System.out.println(gameID);
			gameStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public Connection getDbConn() {
		return dbConn;
	}

	public void setDbConn(Connection dbConn) {
		this.dbConn = dbConn;
	}

}
