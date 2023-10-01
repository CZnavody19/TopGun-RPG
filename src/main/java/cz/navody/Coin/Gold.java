package cz.navody.Coin;

public class Gold extends Coin {
	public Gold() {
		super("Golden coin", 100, 1);
	}

	public Gold(int count) {
		super("Golden coin", 100, count);
	}
}
