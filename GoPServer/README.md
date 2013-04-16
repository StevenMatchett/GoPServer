This is the format of a request from the client.

GET /action=login&user_id=null&user_name=null HTTP/1.1
User-Agent: Dalvik/1.6.0 (Linux; U; Android 4.2.2; SCH-I535 Build/JDQ39)
Host: 54.225.205.16:46789
Connection: Keep-Alive
Accept-Encoding: gzip
Incoming connection.
Starting thread.

GET /action=login&user_id=39091967&user_name=Steven_Matchett HTTP/1.1
User-Agent: Dalvik/1.6.0 (Linux; U; Android 4.2.2; SCH-I535 Build/JDQ39)
Host: 54.225.205.16:46789
Connection: Keep-Alive
Accept-Encoding: gzip

Resource Allocation
--------------------------------------
Whenever a player checks in to a location they are given resources based on the resource weights of that location type. 
For example if a player checked into a University they would receive a blueprints resource more often than any other kind.  
The weights of the resources based on location are given as follows: 
 	
 	ARTS & ENTERTAINMENT
 	Emphasis on Artifacts and Luxuries
¥	Artifacts - 65%
¥	Blueprints - 2.5%
¥	Fossil Fuels - 2.5%
¥	Build Material - 2.5%
¥	Luxuries - 25%
¥	Produce - 2.5%

 	COLLEGE & UNIVERSITY
 	Emphasis on Blueprints
¥	Artifacts - 5%
¥	Blueprints - 75%
¥	Fossil Fuels - 5%
¥	Build Material - 5%
¥	Luxuries - 5%
¥	Produce - 5%

 	FOOD
 	Emphasis on Produce
¥	Artifacts - 2%
¥	Blueprints - 2%
¥	Fossil Fuels - 2%
¥	Build Material - 2%
¥	Luxuries - 2%
¥	Produce - 90%

 	PROFESSIONAL & OTHER PLACES
 	Emphasis on Blueprints
¥	Artifacts - 13.2%
¥	Blueprints - 33%
¥	Fossil Fuels - 13.2%
¥	Build Material - 13.2%
¥	Luxuries - 13.2%
¥	Produce - 13.3%






 	NIGHTLIFE SPOTS
 	Emphasis on Artifacts, Luxuries, and Produce
¥	Artifacts - 33%
¥	Blueprints - 7.667%
¥	Fossil Fuels - 7.667%
¥	Build Material - 7.667%
¥	Luxuries - 33%
¥	Produce - 10%

 	RESIDENCES
 	Even Emphasis
¥	Artifacts - 16.667%
¥	Blueprints - 16.667%
¥	Fossil Fuels - 16.667%
¥	Build Material - 16.667%
¥	Luxuries - 16.667%
¥	Produce - 16.667%

 	GREAT OUTDOORS
 	Emphasis on Build Material, Fossil Fuels, and Produce
¥	Artifacts - 8.333%
¥	Blueprints - 8.333%
¥	Fossil Fuels - 15%
¥	Build Material - 45%
¥	Luxuries - 8.333%
¥	Produce - 15%

 	SHOPS & SERVICES
 	Emphasis on Artifacts, Blueprints, and Produce
¥	Artifacts - 10%
¥	Blueprints - 20%
¥	Fossil Fuels - 6.667%
¥	Build Material - 6.667%
¥	Luxuries - 6.667%
¥	Produce - 50%






 	TRAVEL & TRANSPORT
 	Emphasis on Fossil Fuels and Luxuries
¥	Artifacts - 2.5%
¥	Blueprints - 2.5%
¥	Fossil Fuels - 85%
¥	Build Material - 2.5%
¥	Luxuries - 5%
¥	Produce - 2.5%
