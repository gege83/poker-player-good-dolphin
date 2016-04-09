package org.leanpoker.player;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GameStateTest {
	@Test
	public void testparse() {
		String json = "{\"dealer\":2, " + "\"players\":[{\"id\": 0, " + "\"name\": \"valalki\", "
				+ "\"status\":\"folded\", " + "\"stack\": 532, " + "\"bet\": 43,"
				+ "\"hole_cards\": [{\"rank\": \"A\", \"suit\":\"hearts\"}]}]," + "\"community_cards\": []}";

		Card card = new Card("A", "hearts");
		PlayerObj playerObj = new PlayerObj(0, "valalki", "folded", 532, 43, Arrays.asList(card));
		GameState expected = new GameState(2, Arrays.asList(playerObj), Arrays.asList());

		Gson gson = new GsonBuilder().create();
		GameState acutal = gson.fromJson(json, GameState.class);
		assertEquals(expected, acutal);
	}
}
