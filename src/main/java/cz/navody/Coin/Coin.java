package cz.navody.Coin;

import cz.navody.Item.Item;

public abstract class Coin extends Item {
	private int value;

	public Coin(String name, int value, int count) {
		super(name, 1, count);
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
