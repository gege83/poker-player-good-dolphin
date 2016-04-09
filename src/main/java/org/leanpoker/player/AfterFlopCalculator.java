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
		int guess = gameState.getCurrent_buy_in();
		if (getPairs().size() != 0 || getThreeOfAKind().size() != 0
				|| getPoker().size() != 0) {
			guess = 1000;
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

	private List<List<Card>> getPairs() {
		Map<Integer, List<Card>> cardPairMap = new HashMap<>();
		for (int i = 2; i < 15; i++) {
			cardPairMap.put(i, new ArrayList<Card>());
		}
		for (int i = 0; i < cards.size(); i++) {
			List<Card> list = cardPairMap.get(cards.get(i).getValue());
			list.add(cards.get(i));
			cardPairMap.put(cards.get(i).getValue(), list);
		}
		List<List<Card>> ret = new ArrayList<>();
		for (Integer s : cardPairMap.keySet()) {
			if (cardPairMap.get(s).size() == 2) {
				ret.add(cardPairMap.get(s));
			}
		}
		return ret;

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
		return result;
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
		return result;
	}
}
