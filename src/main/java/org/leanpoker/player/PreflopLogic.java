package org.leanpoker.player;

import java.util.List;

public class PreflopLogic {
	public int getBet(GameState gameState) {
		PlayerObj player = gameState.getPlayers().get(gameState.getIn_action());
		List<Card> holeCards = player.getHole_cards();
		int points = 0;
		int current = 0;
		int current_buy_in = gameState.getCurrent_buy_in();
		int minbet = gameState.getMinimumBet();
		int raise = minbet + gameState.getMinimumRaise();
		String previousSuit = "";
		String currentSuit = "";
		for (Card card : holeCards) {
			current = card.getValue();
			currentSuit = card.getSuit();
			if (current > 10) {
				return minbet;
			}
			if (current == points) {
				return raise;
			} else {
				points += current;
			}
			previousSuit = currentSuit;
		}
		if (current_buy_in < gameState.getSmallBlind() * 3 && stay(player, currentSuit, previousSuit)) {
			return current_buy_in;
		}
		return points >= 20 ? current_buy_in : 0;
	}

	private boolean stay(PlayerObj player, String current, String previous) {
		return player.getBet() > 0;
	}

}
