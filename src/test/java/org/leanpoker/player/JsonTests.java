package org.leanpoker.player;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JsonTests {

	private Gson gson;
	
	@Before
	public void setUp() {
		gson = new GsonBuilder().create();
	}
	
	@Test
	public void testMinimumRaise() throws Exception {
		JsonElement request = new JsonParser().parse(getTestJson("test.json"));
		GameState gameState = gson.fromJson(request, GameState.class);
		Assert.assertEquals(240, gameState.getMinimumRaise());
	}
	
	private String getTestJson(String file) throws Exception {
        URL resource = getClass().getResource(file);
        System.out.print("res: " + resource);
        byte[] bytes = Files.readAllBytes(Paths.get(resource.toURI()));
		String json = new String(bytes);
		return json;
	}

	
}
