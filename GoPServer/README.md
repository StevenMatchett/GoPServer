Request Format
-----------------------------------
action=login&user_id=null&user_name=null HTTP/1.1  

action=login&user_id=39091967&user_name=Steven_Matchett HTTP/1.1  

Using regular expressions, we can parse the request, take the data they give us, do stuff with it, then return some JSON.
Just like one of them, API's! Well be working with Postgresql for the database stuff.


JSON Object Formats
--------------------------------------
We will be formatting the JSON objects with the following scheme:

	 {"games":[{"game_id":123,"name":"this is the game name","maxplayers":2,"map":"death rock","conquest_points":7,"players":[{"player_id":"23324234","player_name":"Steven","conquest_points":2,"factory_level":3,"studio_level":4,"temple_level":5,"lab_level":8,"agency_level":4,"artifacts":34,"blueprints":33,"fuel":800,"material":23,"luxuries":23,"produce":234},{"player_id":"23324234","player_name":"Adam","conquest_points":2,"factory_level":3,"studio_level":4,"temple_level":5,"lab_level":8,"agency_level":4,"artifacts":34,"blueprints":33,"fuel":800,"material":23,"luxuries":23,"produce":234}]}]}
	 
In theory, this should allow us to build an object that is more robust for client side to read.

Resource Allocation
--------------------------------------
Whenever a player checks in to a location they are given resources based on the resource weights of that location type. 
For example if a player checked into a University they would receive a blueprints resource more often than any other kind.  
The weights of the resources based on location are given as follows: 
 
	
ARTS & ENTERTAINMENT  
Emphasis on Artifacts and Luxuries  
	*   Artifacts - 65%  
	*	Blueprints - 2.5%  
	*	Fossil Fuels - 2.5%  
	*	Build Material - 2.5%  
	*	Luxuries - 25%  
	*	Produce - 2.5%  

COLLEGE & UNIVERSITY  
Emphasis on Blueprints  
	*	Artifacts - 5%  
	*	Blueprints - 75%  
	*	Fossil Fuels - 5%  
	*	Build Material - 5%  
	*	Luxuries - 5%  
	*	Produce - 5%  

FOOD  
Emphasis on Produce  
	*	Artifacts - 2%  
	*	Blueprints - 2%  
	*	Fossil Fuels - 2%  
	*	Build Material - 2%  
	*	Luxuries - 2%  
	*	Produce - 90%  

PROFESSIONAL & OTHER PLACES  
Emphasis on Blueprints  
	*	Artifacts - 13.2%  
	*	Blueprints - 33%  
	*	Fossil Fuels - 13.2%  
	*	Build Material - 13.2%  
	*	Luxuries - 13.2%  
	*	Produce - 13.2%s  

NIGHTLIFE SPOTS  
Emphasis on Artifacts, Luxuries, and Produce  
	*	Artifacts - 33%  
	*	Blueprints - 7.667%  
	*	Fossil Fuels - 7.667%  
	*	Build Material - 7.667%  
	*	Luxuries - 33%  
	*	Produce - 10%  

RESIDENCES  
Even Emphasis  
	*	Artifacts - 16.667%  
	*	Blueprints - 16.667%  
	*	Fossil Fuels - 16.667%  
	*	Build Material - 16.667%  
	*	Luxuries - 16.667%  
	*	Produce - 16.667%  

GREAT OUTDOORS  
Emphasis on Build Material, Fossil Fuels, and Produce  
	*	Artifacts - 8.333%  
	*	Blueprints - 8.333%  
	*	Fossil Fuels - 15%  
	*	Build Material - 45%  
	*	Luxuries - 8.333%  
	*	Produce - 15%  

SHOPS & SERVICES  
Emphasis on Artifacts, Blueprints, and Produce  
	*	Artifacts - 10%  
	*	Blueprints - 20%  
	*	Fossil Fuels - 6.667%  
	*	Build Material - 6.667%  
	*	Luxuries - 6.667%  
	*	Produce - 50%  

TRAVEL & TRANSPORT  
Emphasis on Fossil Fuels and Luxuries  
	*	Artifacts - 2.5%  
	*	Blueprints - 2.5%  
	*	Fossil Fuels - 85%  
	*	Build Material - 2.5%  
	*	Luxuries - 5%  
	*	Produce - 2.5%  
