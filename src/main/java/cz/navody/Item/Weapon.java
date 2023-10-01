package cz.navody.Item;

public class Weapon extends Item {
	private int maxDamage;
	private Type type;

	public Weapon(String name, int weight, int maxDamage, Type type) {
		super(name, weight);
		this.maxDamage = maxDamage;
		this.type = type;
	}

	public Type getType() {
		return this.type;
	}

	public int getMaxDamage() {
		return this.maxDamage;
	}

	public enum Type {
		BOTH_HANDS,
		ONE_HAND,
	}
}