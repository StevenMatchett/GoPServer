package gameResources;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Player implements GameObject {

	private String playerID;
	private String playerName;
	private int gameID;
	private int conquestPoints;
	private int factoryLvl;
	private int studioLvl;
	private int templeLvl;
	private int labLvl;
	private int agencyLvl;
	private int numArtifacts;
	private int numBlueprints;
	private int numFuel;
	private int numMaterial;
	private int numLuxuries;
	private int numProduce;
	private Connection dbConn;

	public Player(){}

	public Player(String pID, int gID, Connection db){
		playerID = pID;
		gameID = gID;
		dbConn = db;
		getFromDatabase();
	}

	public Player(String pID, String pName, int gID, int cp, int fl, int sl, int tl, int ll, int al, int a, int b, int f, int m, int l, int p, Connection db){
		playerID = pID;
		playerName = pName;
		gameID = gID;
		conquestPoints = cp;
		factoryLvl = fl;
		studioLvl = sl;
		templeLvl = tl;
		labLvl = ll;
		agencyLvl = al;
		numArtifacts = a;
		numBlueprints = b;
		numFuel = f;
		numMaterial = m;
		numLuxuries = l;
		numProduce = p;
		dbConn = db;
	}

	public String toString(){
		//{"player_id":"23324234","player_name":"Steven","conquest_points":2,"factory_level":3,"studio_level":4,"temple_level":5,"lab_level":8,"agency_level":4,
		//"artifacts":34,"blueprints":33,"fuel":800,"material":23,"luxuries":23,"produce":234}
		String result = new String();
		result = "{\"player_id\":"+playerID+"\",\"player_name\":\""+playerName+
				"\",\"conquest_points\":"+conquestPoints+",\"factory_level\":"+factoryLvl+",\"studio_level\":"+
				studioLvl+",\"temple_level\":"+templeLvl+",\"lab_level\":"+labLvl+",\"agency_level\":"+agencyLvl+
				",\"artifacts\":"+numArtifacts+",\"blueprints\":"+numBlueprints+",\"fuel\":"+numFuel+
				",\"material\":"+numMaterial+",\"luxuries\":"+numLuxuries+",\"produce\":"+numProduce+"}";

		return result;
	}

	public void getFromDatabase(){
		try {
			Statement st = dbConn.createStatement();
			ResultSet rs = st.executeQuery("SELECT " +
					"conquest_points,factory_level,studio_level,temple_level,lab_level,agency_level" +
					"artifacts,blueprints,fuel,material,luxuries,produce FROM player " +
					"WHERE player.id = "+playerID+" AND player.game_id = "+gameID+";");
			int i = 1;
			
			while (rs.next()) {
				System.out.println("Getting Column: "+i);
				rs.getString(i);
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateDatabaseRecord(){
		try{
			Statement playerStatement = dbConn.createStatement();
			playerStatement.executeUpdate("UPDATE player(id,game_id,conquest_points," +
					"factory_level,studio_level,temple_level,lab_level,agency_level,"
					+ "artifacts,blueprints,fuel,material,luxuries,produce) " 
					+ "VALUES ("+playerID+","+gameID+","+conquestPoints+","
					+factoryLvl+","+studioLvl+","+templeLvl+","+labLvl+","+agencyLvl+","
					+numArtifacts+","+numBlueprints+","+numFuel+","+numMaterial+","+numLuxuries+","+numProduce+");");
			System.out.println("Updated player: "+playerID);
			playerStatement.close();
		} catch (Exception e){
			e.printStackTrace();
		} 
	}

	public String getPlayerID() {
		return playerID;
	}

	public void setPlayerID(String playerID) {
		this.playerID = playerID;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getGameID() {
		return gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

	public int getConquestPoints() {
		return conquestPoints;
	}

	public void setConquestPoints(int conquestPoints) {
		this.conquestPoints = conquestPoints;
	}

	public int getFactoryLvl() {
		return factoryLvl;
	}

	public void setFactoryLvl(int factoryLvl) {
		this.factoryLvl = factoryLvl;
	}

	public int getStudioLvl() {
		return studioLvl;
	}

	public void setStudioLvl(int studioLvl) {
		this.studioLvl = studioLvl;
	}

	public int getTempleLvl() {
		return templeLvl;
	}

	public void setTempleLvl(int templeLvl) {
		this.templeLvl = templeLvl;
	}

	public int getLabLvl() {
		return labLvl;
	}

	public void setLabLvl(int labLvl) {
		this.labLvl = labLvl;
	}

	public int getAgencyLvl() {
		return agencyLvl;
	}

	public void setAgencyLvl(int agencyLvl) {
		this.agencyLvl = agencyLvl;
	}

	public int getNumArtifacts() {
		return numArtifacts;
	}

	public void setNumArtifacts(int numArtifacts) {
		this.numArtifacts = numArtifacts;
	}

	public int getNumBlueprints() {
		return numBlueprints;
	}

	public void setNumBlueprints(int numBlueprints) {
		this.numBlueprints = numBlueprints;
	}

	public int getNumFuel() {
		return numFuel;
	}

	public void setNumFuel(int numFuel) {
		this.numFuel = numFuel;
	}

	public int getNumMaterial() {
		return numMaterial;
	}

	public void setNumMaterial(int numMaterial) {
		this.numMaterial = numMaterial;
	}

	public int getNumLuxuries() {
		return numLuxuries;
	}

	public void setNumLuxuries(int numLuxuries) {
		this.numLuxuries = numLuxuries;
	}

	public int getNumProduce() {
		return numProduce;
	}

	public void setNumProduce(int numProduce) {
		this.numProduce = numProduce;
	}

	public Connection getDbConn() {
		return dbConn;
	}

	public void setDbConn(Connection dbConn) {
		this.dbConn = dbConn;
	}

}
