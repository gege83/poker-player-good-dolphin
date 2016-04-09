package org.leanpoker.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AfterFlopCalculator {

	List<Card> hole;
	List<Card> comm;
	ArrayList<Card> cards = new ArrayList<>();
	private GameState gameState;

	public AfterFlopCalculator(List<Card> hole, List<Card> comm, GameState gameState) {
		this.hole = hole;
		this.comm = comm;
		this.gameState = gameState;
		cards.addAll(hole);
		cards.addAll(comm);
	}

	public int getGuess() {
		int guess = 0;
		if (getThreeOfAKind().size() != 0
				|| getPoker().size() != 0) {
			guess = 10000;
		}
		else if (getFiveSameSuit().size() != 0) {
			guess = 10000;
		}
		else if (getFourSameSuit().size() != 0) {
			guess = gameState.getMinimumBet();
		}
		else if (getPair().size() != 0
				|| getTwoPair().size() != 0) {
			guess = gameState.getMinimumBet();
		}
		return guess;
	}

	public Card getHighestCard() {
		Card card = cards.get(0);
		// List<Integer> cardValues = new ArrayList<>();
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).getValue() > card.getValue()) {
				card = cards.get(i);
			}
			// cardValues.add(CardValue.valueOf("C"+cards.get(i).getRank()).getAmount());
		}
		return card;// Collections.max(cardValues);
	}

	private Map<Integer, List<Card>> getRankFrequencies() {
		Map<Integer, List<Card>> cardRankFrequenciesMap = new HashMap<>();
		for (int i = 2; i < 15; i++) {
			cardRankFrequenciesMap.put(i, new ArrayList<Card>());
		}
		for (int i = 0; i < cards.size(); i++) {
			List<Card> list = cardRankFrequenciesMap.get(cards.get(i).getValue());
			list.add(cards.get(i));
			cardRankFrequenciesMap.put(cards.get(i).getValue(), list);
		}
		return cardRankFrequenciesMap;
	}
	
	private Map<String, List<Card>> getSuitFrequencies() {
		Map<String, List<Card>> cardSuitFrequenciesMap = new HashMap<>();
		for (CardSuits cs : CardSuits.values()) {
			cardSuitFrequenciesMap.put(cs.getName(), new ArrayList<Card>());
		}
		for (int i = 0; i < cards.size(); i++) {
			List<Card> list = cardSuitFrequenciesMap.get(cards.get(i).getSuit());
			list.add(cards.get(i));
			cardSuitFrequenciesMap.put(cards.get(i).getSuit(), list);
		}
		return cardSuitFrequenciesMap;
	}

	public List<Card> getPair() {
		Map<Integer, List<Card>> cardRankFrequenciesMap = getRankFrequencies();

		List<Card> result = new ArrayList<>();
		boolean hasPair = false;
		for (Integer s : cardRankFrequenciesMap.keySet()) {
			List<Card> cardList = cardRankFrequenciesMap.get(s);
			if (cardList.size() == 2 && !hasPair) {
				hasPair = true;
				result.addAll(cardList);
			}
			else if (cardList.size() == 2 && hasPair) {
				result = new ArrayList<>();
			}
		}
				
		if (!hasOwnCard(result)) {
			result.clear();
		}
		
		return result;
	}

	private boolean hasOwnCard(List<Card> result) {
		boolean hasOwnCard = false;
		for (Card card : result) {
			if (hole.contains(card)) {
				hasOwnCard = true;
				break;
			}
		}
		return hasOwnCard;
	}
	
	public List<Card> getThreeOfAKind() {
		Map<Integer, List<Card>> cardRankFrequenciesMap = getRankFrequencies();

		List<Card> result = new ArrayList<>();
		for (Integer s : cardRankFrequenciesMap.keySet()) {
			List<Card> cardList = cardRankFrequenciesMap.get(s);
			if (cardList.size() == 3) {
				result.addAll(cardList);
			}
		}
		
		if (!hasOwnCard(result)) {
			result.clear();
		}

		return result;
	}

	public List<Card> getPoker() {
		Map<Integer, List<Card>> cardRankFrequenciesMap = getRankFrequencies();

		List<Card> result = new ArrayList<>();
		for (Integer s : cardRankFrequenciesMap.keySet()) {
			List<Card> cardList = cardRankFrequenciesMap.get(s);
			if (cardList.size() == 4) {
				result.addAll(cardList);
			}
		}
		
		if (!hasOwnCard(result)) {
			result.clear();
		}

		return result;
	}
	
	public List<Card> getTwoPair() {
		Map<Integer, List<Card>> cardRankFrequenciesMap = getRankFrequencies();

		List<Card> result = new ArrayList<>();
		int cnt = 0;
		for (Integer s : cardRankFrequenciesMap.keySet()) {
			List<Card> cardList = cardRankFrequenciesMap.get(s);
			if (cardList.size() == 2) {
				cnt++;
				result.addAll(cardList);
			}
		}
		
		if (!hasOwnCard(result)) {
			result.clear();
		}

		if (cnt != 2) {
			result.clear();
		}
		return result;
	}
	
	public List<Card> getFourSameSuit() {
		Map<String, List<Card>> cardSutFrequenciesMap = getSuitFrequencies();

		List<Card> result = new ArrayList<>();
		for (String s : cardSutFrequenciesMap.keySet()) {
			List<Card> cardList = cardSutFrequenciesMap.get(s);
			if (cardList.size() == 4) {
				result.addAll(cardList);
			}
		}
		
		if (!hasOwnCard(result)) {
			result.clear();
		}

		return result;
	}
	
	public List<Card> getFiveSameSuit() {
		Map<String, List<Card>> cardSutFrequenciesMap = getSuitFrequencies();

		List<Card> result = new ArrayList<>();
		for (String s : cardSutFrequenciesMap.keySet()) {
			List<Card> cardList = cardSutFrequenciesMap.get(s);
			if (cardList.size() == 5) {
				result.addAll(cardList);
			}
		}
		
		if (!hasOwnCard(result)) {
			result.clear();
		}

		return result;
	}
}
