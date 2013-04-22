package gameResources;

public class Buildings {

	private Player player;
	private String building;

	/*
	 * What each building does Agency - Allows player to view other players
	 * VPs(level 1), buildings(level 2), and resources(level 3) Factory -
	 * Upgrading buildings cost less by 1 per level Lab - Increase resources
	 * gained per check-in by 1 Studio - Reduce the cost of a VP by 1 resource
	 * Temple - SPECIAL - Grants player 1 resource for each of the following
	 * types: Blueprints, Materials, Fuel. This costs the player a Luxury,
	 * Artifact, and Food.
	 */

	// calculates the players resource ammount with their factory amount, since
	// factories effectively give an extra resource
	private int c_Artifacts;
	private int c_Blueprints;
	private int c_Fuel;
	private int c_Materials;
	private int c_Luxuries;
	private int c_Food;

	// Each building upgrade costs additional resources to upgrade, so we factor
	// that in here.
	private int agencyCost;
	private int factoryCost;
	private int labCost;
	private int studioCost;

	public Buildings(Player p, String b) {
		player = p;
		building = b;
		c_Artifacts = player.getNumArtifacts() + player.getFactoryLvl();
		c_Blueprints = player.getNumBlueprints() + player.getFactoryLvl();
		c_Fuel = player.getNumFuel() + player.getFactoryLvl();
		c_Materials = player.getNumMaterial() + player.getFactoryLvl();
		c_Luxuries = player.getNumLuxuries() + player.getFactoryLvl();
		c_Food = player.getNumProduce() + player.getFactoryLvl();
		agencyCost = (int) Math.ceil((0.5 * (double) player.getAgencyLvl()));
		factoryCost = (int) Math.ceil((0.5 * (double) player.getFactoryLvl()));
		labCost = (int) Math.ceil((0.5 * (double) player.getLabLvl()));
		studioCost = (int) Math.ceil((0.5 * (double) player.getStudioLvl()));
	}

	public boolean updatePlayerBuildings() {
		boolean upgradeStatus = false;

		if (building.equalsIgnoreCase("Agency")) {
			if (c_Blueprints >= (2 * agencyCost)
					&& c_Artifacts >= (1 * agencyCost)
					&& c_Materials >= (2 * agencyCost)) {
				player.setAgencyLvl(player.getAgencyLvl() + 1);
				upgradeStatus = true;
			}
		} else if (building.equalsIgnoreCase("Factory")) {
			if (c_Materials >= (2 * factoryCost) && c_Fuel >= (3 * factoryCost)
					&& c_Food >= (3 * factoryCost)) {
				player.setFactoryLvl(player.getFactoryLvl() + 1);
				upgradeStatus = true;
			}
		} else if (building.equalsIgnoreCase("Lab")) {
			if (c_Blueprints >= (2 * labCost) && c_Artifacts >= (1 * labCost)
					&& c_Fuel >= (3 * labCost) && c_Luxuries >= (1 * labCost)) {
				player.setLabLvl(player.getLabLvl() + 1);
				upgradeStatus = true;
			}
		} else if (building.equalsIgnoreCase("Studio")) {
			if (c_Luxuries >= (4 * studioCost)
					&& c_Materials >= (2 * studioCost)) {
				player.setStudioLvl(player.getStudioLvl() + 1);
				upgradeStatus = true;
			}
		} else {
			if (c_Luxuries >= (1) && c_Artifacts >= (1) && c_Food >= (1)) {
				player.setNumMaterial(player.getNumMaterial() + 1);
				player.setNumBlueprints(player.getNumBlueprints() + 1);
				player.setNumFuel(player.getNumFuel() + 1);
				upgradeStatus = true;
			}
		}
		player.updateDatabaseRecord();
		return upgradeStatus;
	}

}
