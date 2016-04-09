package org.leanpoker.player;

public class Logic {
	public boolean isPreflop(GameState gameState) {
		return gameState.getCommunity_cards().isEmpty();
	}

	public int preFlop(GameState gameState) {
		return new PreflopLogic().getBet(gameState);
	}

	public int postFlop(GameState gameState) {
		PlayerObj player = gameState.getPlayers().get(gameState.getIn_action());
		AfterFlopCalculator postfolp = new AfterFlopCalculator(player.getHole_cards(), gameState.getCommunity_cards(), gameState);
		return postfolp.getGuess();
	}
}
