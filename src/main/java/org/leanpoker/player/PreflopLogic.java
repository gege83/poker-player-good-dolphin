package org.leanpoker.player;

import java.util.List;

public class PreflopLogic {
	public int getBet(GameState gameState) {
		PlayerObj player = gameState.getPlayers().get(gameState.getIn_action());
		List<Card> holeCards = player.getHole_cards();
		int points = 0;
		for (Card card : holeCards) {
			String rank = card.getRank();
			switch (rank) {
			case "J":
				points += 11;
				break;
			case "Q":
				points += 12;
				break;
			case "K":
				points += 13;
				break;
			case "A":
				points += 14;
				break;
			default:
				points += Integer.parseInt(rank);
				break;
			}
		}
		return points > 14 ? 1000 : 0;
	}
}
