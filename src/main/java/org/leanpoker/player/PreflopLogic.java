package org.leanpoker.player;

import java.util.List;

public class PreflopLogic {
	public int getBet(GameState gameState) {
		PlayerObj player = gameState.getPlayers().get(gameState.getIn_action());
		List<Card> holeCards = player.getHole_cards();
		int points = 0;
		int current = 0;
		for (Card card : holeCards) {
			String rank = card.getRank();
			switch (rank) {
			case "J":
				current = 11;
				break;
			case "Q":
				current = 12;
				break;
			case "K":
				current = 13;
				break;
			case "A":
				current = 14;
				break;
			default:
				current = Integer.parseInt(rank);
				break;
			}
			if (current == points) {
				return 1000;
			} else {
				points += current;
			}
		}
		return points > 20 ? 1000 : 0;
	}
}
