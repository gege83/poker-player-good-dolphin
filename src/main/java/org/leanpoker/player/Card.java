package org.leanpoker.player;

public class Card {
	String rank;
	String suit;
	
	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	
	public int getValue() {
		return CardValue.valueOf("C"+getRank()).getAmount();
	}

	public Card(String rank, String suit) {
		super();
		this.rank = rank;
		this.suit = suit;
	}

	public int getRank() {
		int current = 0;
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
		return current;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (rank == null ? 0 : rank.hashCode());
		result = prime * result + (suit == null ? 0 : suit.hashCode());
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
		Card other = (Card) obj;
		if (rank == null) {
			if (other.rank != null) {
				return false;
			}
		} else if (!rank.equals(other.rank)) {
			return false;
		}
		if (suit == null) {
			if (other.suit != null) {
				return false;
			}
		} else if (!suit.equals(other.suit)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Card [rank=" + rank + ", suit=" + suit + "]";
	}

	public int getRankInt() {
		int current;
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
		return current;
	}

}
