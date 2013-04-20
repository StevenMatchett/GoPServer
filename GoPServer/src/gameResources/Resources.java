package gameResources;

//Implement this resource any time you need resource probabilities or whatevers.
public class Resources {

	//Probability Constants
	public float Artifact;
	public float Blueprints;
	public float Fuel;
	public float Materials;
	public float Luxuries;
	public float Food;
	//This is the value you multiply against the resources to get the amount per checkin.
	public final int resourceMultiplier = 100;
	
	public Resources(float art, float blue, float fuel, float mat, float lux, float food){
	    Artifact = art;
		Blueprints = blue;
		Materials = mat;
		Fuel = fuel;
		Luxuries = lux;
		Food = food;
	}

	public int getArtifact() {
		return Math.round(Artifact*resourceMultiplier);
	}

	public int getBlueprints() {
		return Math.round(Blueprints*resourceMultiplier);
	}

	public int getFuel() {
		return Math.round(Fuel*resourceMultiplier);
	}

	public int getMaterials() {
		return Math.round(Materials*resourceMultiplier);
	}

	public int getLuxuries() {
		return Math.round(Luxuries*resourceMultiplier);
	}

	public int getFood() {
		return Math.round(Food*resourceMultiplier);
	}	
}
