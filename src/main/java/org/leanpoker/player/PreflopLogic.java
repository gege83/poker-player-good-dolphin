package org.leanpoker.player;

import java.util.List;

public class PreflopLogic {
	public int getBet(GameState gameState) {
		PlayerObj player = gameState.getPlayers().get(gameState.getIn_action());
		List<Card> holeCards = player.getHole_cards();
		int points = 0;
		int current = 0;
		int betCall = gameState.getCurrent_buy_in() - player.getBet();
		int raise = betCall + gameState.getMinimumRaise();
		for (Card card : holeCards) {
			current = card.getValue();
			if (current > 9) {
				return betCall;
			}
			if (current == points) {
				return raise;
			} else {
				points += current;
			}
		}
		int current_buy_in = gameState.getCurrent_buy_in();
		if (current_buy_in < gameState.getSmallBlind() * 3 && player.getBet() > 0) {
			return betCall;
		}
		return points >= 20 ? betCall : 0;
	}

}
