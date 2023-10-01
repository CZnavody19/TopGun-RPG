package cz.navody;

import org.junit.Test;

import cz.navody.Coin.Copper;
import cz.navody.Coin.Silver;
import cz.navody.Coin.Gold;

public class CoinTest {
	@Test
	public void copperCoinTest() {
		Copper coin = new Copper(10);

		assert coin.getValue() == 10;
		assert coin.toString().equals("Copper coin [10] (10)");
	}

	@Test
	public void silverCoinTest() {
		Silver coin = new Silver(10);

		assert coin.getValue() == 100;
		assert coin.toString().equals("Silver coin [10] (10)");
	}

	@Test
	public void goldCoinTest() {
		Gold coin = new Gold(10);

		assert coin.getValue() == 1000;
		assert coin.toString().equals("Golden coin [10] (10)");
	}
}
