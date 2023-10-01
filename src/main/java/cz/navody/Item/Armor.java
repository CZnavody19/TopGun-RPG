package cz.navody.Item;

public class Armor extends Item {
	public int maxProtection;

	public Armor(String name, int weight, int maxProtection) {
		super(name, weight);
		this.maxProtection = maxProtection;
	}

	public int getMaxProtection() {
		return this.maxProtection;
	}
}
