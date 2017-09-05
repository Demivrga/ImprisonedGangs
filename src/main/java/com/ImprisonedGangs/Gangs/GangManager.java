package com.ImprisonedGangs.Gangs;

import java.util.List;
import java.util.UUID;

import com.ImprisonedMongo.database.MongoManager;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class GangManager {

	/*
	 * 
	 * Since we're inside of the GangManager, we're going to ALWAYS be pushing data into the
	 * "Gangs" database for Mongo! If it goes anywhere else, it'll mess a LOT of things up!
	 * 
	 */
	
	public static DBCollection db = MongoManager.getDB().getCollection("Gangs");

	public static void storeGang(UUID uuid, String gangname, String gangowner, List<String> gangmods, String gangsymbol, List<String> members, int money) {
		// Gang Creation
		// This is complicated, we're going to create the entirety of the gang here.
		// From their name, symbol, money, everything. It'll go through this database push.
		DBObject obj = new BasicDBObject("uuid", uuid);
		obj.put("name", gangname);
		obj.put("gangsymbol", gangsymbol);
		obj.put("gangowner", gangowner);
		obj.put("gangmods", gangmods);
		obj.put("members", members);
		obj.put("money", money);

		// Lets insert it in our collection:
		db.insert(obj);
	}

	public static DBObject findGang(UUID uuid) {

		DBObject search = new BasicDBObject("uuid", uuid);
		DBObject found = db.findOne(search);

		if (found == null) {
			return null;
		}
		return found;

	}


}
