package org.leanpoker.player;

public enum CardSuits {
	CLUBS("clubs"),
	SPADES("spades"),
	HEARTS("hearts"),
	DIAMOND("diamond");
	
	private String name;

	public String getName() {
		return name;
	}

	private CardSuits(String name) {
		this.name = name;
	}
}
