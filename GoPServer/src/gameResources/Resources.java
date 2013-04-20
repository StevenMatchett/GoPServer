package gameResources;

//Implement this resource any time you need resource probabilities or whatevers.
public class Resources {

	//Probability Constants
	private float p_Artifact;
	private float p_Blueprints;
	private float p_Fuel;
	private float p_Materials;
	private float p_Luxuries;
	private float p_Food;
	
	private int artifacts = 0;
	private int blueprints = 0;
	private int fuel = 0;
	private int materials = 0;
	private int luxuries = 0;
	private int food = 0;
	//This is the value you multiply against the resources to get the amount per checkin.
	public final int resourceMultiplier = 100;
	
	public Resources(float art, float blue, float fuel, float mat, float lux, float food){
	    p_Artifact = art;
		p_Blueprints = blue;
		p_Materials = mat;
		p_Fuel = fuel;
		p_Luxuries = lux;
		p_Food = food;
	}

	public int getArtifact() {
		return artifacts;
	}

	public int getBlueprints() {
		return blueprints;
	}

	public int getFuel() {
		return fuel;
	}

	public int getMaterials() {
		return materials;
	}

	public int getLuxuries() {
		return luxuries;
	}

	public int getFood() {
		return food;
	}
	
	public void generateResources(int resourceModifier){
		//Resource Modifier will be the level of the player's factory.
		resourceModifier += Math.round(Math.random()*3);
		
		//Range time!
		int artifactRange = Math.round(p_Artifact*resourceMultiplier);
		int blueprintRange = artifactRange + Math.round(p_Blueprints*resourceMultiplier);
		int fuelRange = blueprintRange + Math.round(p_Fuel*resourceMultiplier);
		int materialRange = fuelRange + Math.round(p_Materials*resourceMultiplier);
		int luxuriesRange = materialRange + Math.round(p_Luxuries*resourceMultiplier);
		int foodRange = luxuriesRange + Math.round(p_Food*resourceMultiplier);
		
		for(int i = 0; i<resourceModifier; i++){
			int randomResourceVariable = (int) Math.round(Math.random()*100);
			if(randomResourceVariable <= artifactRange){
				artifacts++;
			}else if(randomResourceVariable <= blueprintRange){
				blueprints++;
			}else if(randomResourceVariable <= fuelRange){
				fuel++;
			}else if(randomResourceVariable <= materialRange){
				materials++;
			}else if(randomResourceVariable <= luxuriesRange){
				luxuries++;
			}else //Food catch all. ^_^
				food++;
		}
	}
}
