package org.leanpoker.player;

public class Logic {
	public boolean isPreflop(GameState gameState) {
		return gameState.getCommunity_cards().size() > 0;
	}

	public int preFlop(GameState gameState) {
		return new PreflopLogic().getBet(gameState);
	}

	public int postFlop(GameState gameState) {
		return 1000;
	}
}
