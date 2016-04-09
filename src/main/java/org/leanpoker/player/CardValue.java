package org.leanpoker.player;

public enum CardValue {
	
	C2(2),C3(3),C4(4),C5(5),C6(6),C7(7),C8(8),C9(9),C10(10),CJ(11),CQ(12),CK(13),CA(14);
	
	private int amount;
	
	CardValue(int amount) {
		this.amount=amount;
	
	}
	public int getAmount() {
		return amount;
	}
	
}
