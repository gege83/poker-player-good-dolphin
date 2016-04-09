package org.leanpoker.player;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.junit.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class PlayerTest {

	@Test
	public void testBetRequest() throws Exception {

		JsonElement jsonElement = new JsonParser().parse("{\"key1\": \"value1\", \"key2\": \"value2\"}");

		assertEquals(100, Player.betRequest(jsonElement));

	}
    
    @Test
    public void testSmoke() throws IOException, URISyntaxException {
    	byte[] bytes = Files.readAllBytes(Paths.get(getClass().getResource("test.json").toURI()));
    	String json = new String(bytes);
    	JsonElement request = new JsonParser().parse(json);
    	int result = Player.betRequest(request);
    }
}
