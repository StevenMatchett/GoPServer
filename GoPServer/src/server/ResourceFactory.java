package server;

import resources.*;

public class ResourceFactory {
	private IResource[] resourceArray;
	
	public IResource[] getResources() {
		
		if (resourceArray == null){
			resourceArray = new IResource[]{
				new Artifact(),
				new Blueprints(),
				new BuildMaterial(),
				new FossilFuel(),
				new Luxuries(),
				new Produce()
			};
		}
		return resourceArray;
	}
}
