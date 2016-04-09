package org.leanpoker.player;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

public class Player {

	static final String VERSION = "Default Java folding player";

	public static int betRequest(JsonElement request) {
		try {
			Gson gson = new GsonBuilder().create();
			GameState gameState = gson.fromJson(request, GameState.class);
			return new Logic().preFlop(gameState);
		} catch (Throwable e) {
			return 1000;
		}
	}

	public static void showdown(JsonElement game) {
	}
}
