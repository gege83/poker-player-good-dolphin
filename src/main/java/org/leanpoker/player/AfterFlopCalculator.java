package org.leanpoker.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AfterFlopCalculator {
	
	List<Card> hole;
	List<Card> comm;
	ArrayList<Card> cards= new ArrayList<>();
	
	public AfterFlopCalculator(List<Card> hole, List<Card> comm) {
		this.hole=hole;
		this.comm=comm;
		cards.addAll(hole);
		cards.addAll(comm);
	}
	
	public int getGuess() {
		int guess=0;
		if(getPairs().size()!=0 || getTwoPairs().size()!=0) {
			guess=1000;
		}
		return guess;
	}
	public Card getHighestCard() {
		Card card =cards.get(0);
		//List<Integer> cardValues = new ArrayList<>();
		for(int i=0;i<cards.size();i++) {
			if(cards.get(i).getValue()>card.getValue()) {
				card=cards.get(i);
			}
			//cardValues.add(CardValue.valueOf("C"+cards.get(i).getRank()).getAmount());
		}
		return card;//Collections.max(cardValues);
	}
	
	private List<List<Card>> getPairs() {
		Map<Integer, List<Card>> cardPairMap = new HashMap<>();
		for(int i=2;i<15;i++) {
			cardPairMap.put(i, Collections.emptyList());
		}
		for(int i=0;i<cards.size();i++) {
			List<Card> list=cardPairMap.get(cards.get(i).getValue());
			list.add(cards.get(i));
			cardPairMap.put(cards.get(i).getValue(), list);
		}
		List<List<Card>> ret = Collections.emptyList();
		for(Integer s : cardPairMap.keySet()) {
			if(cardPairMap.get(s).size()==2) {
				ret.add(cardPairMap.get(s));
			}
		}
		return ret;
		
	}
	
	public List<Card> getPair() {
		List<List<Card>> temp=getPairs();
		if(temp.size()==1) {
			return temp.get(0);
		} else {
			return Collections.emptyList();
		}
	}
	
	public List<Card> getTwoPairs() {
		List<List<Card>> temp=getPairs();
		if(temp.size()==2) {
			List<Card> ret=new ArrayList<>();
			ret.addAll(temp.get(0));
			ret.addAll(temp.get(1));
			return ret;
		} else {
			return Collections.emptyList();
		}
	}
	
	
	
	

}
