package org.leanpoker.player;

import java.util.List;

public class PlayerObj {
	int id;
	String name;
	State status;
	int stack;
	int bet;

	List<Card> hole_cards;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getStatus() {
		return status;
	}

	public void setStatus(State status) {
		this.status = status;
	}

	public int getStack() {
		return stack;
	}

	public void setStack(int stack) {
		this.stack = stack;
	}

	public int getBet() {
		return bet;
	}

	public void setBet(int bet) {
		this.bet = bet;
	}

	public List<Card> getHole_cards() {
		return hole_cards;
	}

	public void setHole_cards(List<Card> hole_cards) {
		this.hole_cards = hole_cards;
	}

	@Override
	public String toString() {
		return "PlayerObj [id=" + id + ", name=" + name + ", status=" + status + ", stack=" + stack + ", bet=" + bet
				+ ", hole_cards=" + hole_cards + "]";
	}

	public PlayerObj(int id, String name, String status, int stack, int bet, List<Card> hole_cards) {
		super();
		this.id = id;
		this.name = name;
		this.status = State.valueOf(status);
		this.stack = stack;
		this.bet = bet;
		this.hole_cards = hole_cards;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bet;
		result = prime * result + (hole_cards == null ? 0 : hole_cards.hashCode());
		result = prime * result + id;
		result = prime * result + (name == null ? 0 : name.hashCode());
		result = prime * result + stack;
		result = prime * result + (status == null ? 0 : status.hashCode());
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
		PlayerObj other = (PlayerObj) obj;
		if (bet != other.bet) {
			return false;
		}
		if (hole_cards == null) {
			if (other.hole_cards != null) {
				return false;
			}
		} else if (!hole_cards.equals(other.hole_cards)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (stack != other.stack) {
			return false;
		}
		if (status != other.status) {
			return false;
		}
		return true;
	}

}
