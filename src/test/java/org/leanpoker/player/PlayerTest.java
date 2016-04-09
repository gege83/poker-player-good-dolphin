package org.leanpoker.player;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class PlayerTest {

	@Test
	public void testBetRequest() throws Exception {

		JsonElement jsonElement = new JsonParser().parse("{\"key1\": \"value1\", \"key2\": \"value2\"}");

		assertEquals(100, Player.betRequest(jsonElement));

	}
}
