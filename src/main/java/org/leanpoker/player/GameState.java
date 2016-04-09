package org.leanpoker.player;

import java.util.List;

public class GameState {
	int dealer;
	List<PlayerObj> players;
	List<Card> community_cards;
	private final int in_action;

	public int getDealer() {
		return dealer;
	}

	public void setDealer(int dealer) {
		this.dealer = dealer;
	}

	public List<PlayerObj> getPlayers() {
		return players;
	}

	public void setPlayers(List<PlayerObj> players) {
		this.players = players;
	}

	public List<Card> getCommunity_cards() {
		return community_cards;
	}

	public void setCommunity_cards(List<Card> community_cards) {
		this.community_cards = community_cards;
	}

	public int getIn_action() {
		return in_action;
	}

	public GameState(int dealer, List<PlayerObj> players, List<Card> community_cards, int in_action) {
		super();
		this.dealer = dealer;
		this.players = players;
		this.community_cards = community_cards;
		this.in_action = in_action;
	}

	@Override
	public String toString() {
		return "GameState [dealer=" + dealer + ", players=" + players + ", community_cards=" + community_cards
				+ ", in_action=" + in_action + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (community_cards == null ? 0 : community_cards.hashCode());
		result = prime * result + dealer;
		result = prime * result + in_action;
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
		if (in_action != other.in_action) {
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

}
