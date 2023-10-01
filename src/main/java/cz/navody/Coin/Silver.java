package cz.navody.Coin;

public class Silver extends Coin {
	public Silver() {
		super("Silver coin", 10, 1);
	}

	public Silver(int count) {
		super("Silver coin", 10, count);
	}
}
