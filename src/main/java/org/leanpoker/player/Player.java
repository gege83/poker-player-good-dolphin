package org.leanpoker.player;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

public class Player {

	static final String VERSION = "Default Java folding player";

	public static int betRequest(JsonElement request) {
		try {
			Logic logic = new Logic();
			Gson gson = new GsonBuilder().create();
			GameState gameState = gson.fromJson(request, GameState.class);
			if (logic.isPreflop(gameState)) {
				return logic.preFlop(gameState);
			} else {
				return logic.postFlop(gameState);
			}
		} catch (Throwable e) {
			e.printStackTrace();
			return 1000;
		}
	}

	public static void showdown(JsonElement game) {
	}
}
