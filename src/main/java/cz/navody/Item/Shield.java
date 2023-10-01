package cz.navody.Item;

public class Shield extends Item {
	public int maxProtection;

	public Shield(String name, int weight, int maxProtection) {
		super(name, weight);
		this.maxProtection = maxProtection;
	}

	public int getMaxProtection() {
		return this.maxProtection;
	}
}
