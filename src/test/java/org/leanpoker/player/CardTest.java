package org.leanpoker.player;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CardTest {

	@Test
	public void testGetValueNumber() {
		String rank = "2";
		Card card = new Card(rank, "");
		int actual = card.getValue();
		assertEquals(2, actual);
	}

	@Test
	public void testGetValue10() {
		String rank = "10";
		Card card = new Card(rank, "");
		int actual = card.getValue();
		assertEquals(10, actual);
	}

	@Test
	public void testGetValueKing() {
		String rank = "K";
		Card card = new Card(rank, "");
		int actual = card.getValue();
		assertEquals(13, actual);
	}

	@Test
	public void testGetValueJumbo() {
		String rank = "J";
		Card card = new Card(rank, "");
		int actual = card.getValue();
		assertEquals(11, actual);
	}

	@Test
	public void testGetValueAs() {
		String rank = "A";
		Card card = new Card(rank, "");
		int actual = card.getValue();
		assertEquals(14, actual);
	}

	@Test
	public void testGetValueQu() {
		String rank = "Q";
		Card card = new Card(rank, "");
		int actual = card.getValue();
		assertEquals(12, actual);
	}
}
