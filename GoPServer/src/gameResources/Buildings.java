package gameResources;

public class Buildings {
	
	private Player player;
	private String building;
	
	//calculates the players resource ammount with their factory amount, since factories effectively give an extra resource
	private int c_Artifacts = player.getNumArtifacts()+player.getFactoryLvl();
	private int c_Blueprints = player.getNumBlueprints()+player.getFactoryLvl();
	private int c_Fuel = player.getNumFuel()+player.getFactoryLvl();
	private int c_Materials = player.getNumMaterial()+player.getFactoryLvl();
	private int c_Luxuries = player.getNumLuxuries()+player.getFactoryLvl();
	private int c_Food = player.getNumProduce()+player.getFactoryLvl();
	
	//Each building upgrade costs additional resources to upgrade, so we factor that in here.
	private int agencyCost = (int) (0.5 * player.getAgencyLvl());
	private int factoryCost = (int) (0.5 * player.getFactoryLvl());
	private int labCost = (int) (0.5 * player.getLabLvl());
	private int farmCost = (int) (0.5 * player.getStudioLvl()); 
	private int templeCost = (int) (0.5 * player.getTempleLvl());
	
	/*
	 * What each building does
	 * Agency - Reduce cost of VPs by 10%
	 * Factory - Upgrade buildings cost less by 1 per level
	 * Lab - Increase resources gained per check-in by 1
	 * Farm - Reduce city upkeep 40% per level
	 * Temple - 25% chance to get and extra resource per level
	 */
	
	public Buildings(Player p, String b){
		player = p;
		building = b;
	}
	
	public void updatePlayerBuildings(){
		//Adam you should fix the resource amounts, so I'm not pulling shit out of my ass.
		if(building.equalsIgnoreCase("Agency")){
			if(c_Blueprints > (2*agencyCost) && c_Artifacts > (1*agencyCost) && c_Materials > (2*agencyCost)){
				player.setAgencyLvl(player.getAgencyLvl()+1);
			}
		}else if(building.equalsIgnoreCase("Factory")){
			if(c_Blueprints > (2*agencyCost) && c_Artifacts > (1*agencyCost) && c_Materials > (2*agencyCost)){
				player.setFactoryLvl(player.getFactoryLvl()+1);
			}
		}else if(building.equalsIgnoreCase("Lab")){
			if(c_Blueprints > (2*agencyCost) && c_Artifacts > (1*agencyCost) && c_Materials > (2*agencyCost)){
				player.setLabLvl(player.getLabLvl()+1);
			}
		}else if(building.equalsIgnoreCase("Studio")){
			if(c_Blueprints > (2*agencyCost) && c_Artifacts > (1*agencyCost) && c_Materials > (2*agencyCost)){
				player.setStudioLvl(player.getStudioLvl()+1);
			}
		}
		else {
			if(c_Blueprints > (2*agencyCost) && c_Artifacts > (1*agencyCost) && c_Materials > (2*agencyCost)){
				player.setTempleLvl(player.getTempleLvl()+1);
			}
		}
		player.updateDatabaseRecord();
	}
	
}
