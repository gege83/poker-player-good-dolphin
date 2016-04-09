package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Player {

	static final String VERSION = "Default Java folding player";

	public static int betRequest(JsonElement request) {
		JsonObject obj = (JsonObject)request;
		JsonArray players = (JsonArray) obj.get("players");
		JsonElement inAction = obj.get("in_action");
		JsonObject player = (JsonObject) players.get(inAction.getAsInt());
		JsonArray holeCards = (JsonArray) player.get("hole_cards");
		int points = 0;
		for (int i=0; i<holeCards.size(); i++) {
			JsonObject card = (JsonObject) holeCards.get(i);
			String rank = card.get("rank").getAsString();
			switch(rank) {
			case "J":
				points += 11;
				break;
			case "Q":
				points += 12;
				break;
			case "K":
				points += 13;
				break;
			case "A":
				points += 14;
				break;
			default:
				points += Integer.parseInt(rank);
				break;
			}
		}
		return points>14 ? 1000 : 0;
	}

	public static void showdown(JsonElement game) {
	}
}
