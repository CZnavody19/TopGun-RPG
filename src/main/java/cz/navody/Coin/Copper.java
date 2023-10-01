package cz.navody.Coin;

public class Copper extends Coin {
	public Copper() {
		super("Copper coin", 1, 1);
	}

	public Copper(int count) {
		super("Copper coin", 1, count);
	}
}
