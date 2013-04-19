package gameResources;

//Implement this resource any time you need resource probabilities or whatevers.
public class Resources {

	//Probability Constants
	public float p_Artifact;
	public float p_Blueprints;
	public float p_Fuel;
	public float p_Materials;
	public float p_Luxuries;
	public float p_Food;
	
	public Resources(float art, float blue, float fuel, float mat, float lux, float food){
		p_Artifact = art;
		p_Blueprints = blue;
		p_Materials = mat;
		p_Fuel = fuel;
		p_Luxuries = lux;
		p_Food = food;
	}
	
	
}
