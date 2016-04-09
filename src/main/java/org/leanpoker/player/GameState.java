package org.leanpoker.player;

import java.util.List;

public class GameState {
	int dealer;
	List<PlayerObj> players;
	List<Card> community_cards;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (community_cards == null ? 0 : community_cards.hashCode());
		result = prime * result + dealer;
		result = prime * result + (players == null ? 0 : players.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		GameState other = (GameState) obj;
		if (community_cards == null) {
			if (other.community_cards != null) {
				return false;
			}
		} else if (!community_cards.equals(other.community_cards)) {
			return false;
		}
		if (dealer != other.dealer) {
			return false;
		}
		if (players == null) {
			if (other.players != null) {
				return false;
			}
		} else if (!players.equals(other.players)) {
			return false;
		}
		return true;
	}

	public GameState(int dealer, List<PlayerObj> players, List<Card> community_cards) {
		super();
		this.dealer = dealer;
		this.players = players;
		this.community_cards = community_cards;
	}

	@Override
	public String toString() {
		return "GameState [dealer=" + dealer + ", players=" + players + ", community_cards=" + community_cards + "]";
	}

}
