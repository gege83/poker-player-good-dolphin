package org.leanpoker.player;

import java.util.List;

public class PreflopLogic {
	public int getBet(GameState gameState) {
		PlayerObj player = gameState.getPlayers().get(gameState.getIn_action());
		List<Card> holeCards = player.getHole_cards();
		int points = 0;
		int current = 0;
		String previousSuit = "";
		for (Card card : holeCards) {
			current = card.getRankInt();
			String currentSuit = card.getSuit();
			if (current == points) {
				return 1000;
			} else if (isNeighbours(points, current) || sameSuit(currentSuit, previousSuit)) {
				return gameState.getCurrent_buy_in();
			} else {
				points += current;
			}
			previousSuit = currentSuit;
		}
		return points > 20 ? 1000 : 0;
	}

	private boolean sameSuit(String currentSuit, String previousSuit) {
		return currentSuit.equals(previousSuit);
	}

	private boolean isNeighbours(int points, int current) {
		return Math.abs(current - points) <= 1;
	}
}
