package cz.navody.Item;

public class Item {
	private String name;
	private int weight;
	private int count;

	public Item(String name, int weight) {
		this.name = name;
		this.weight = weight;
		this.count = 1;
	}

	public Item(String name, int weight, int count) {
		this.name = name;
		this.weight = weight * count;
		this.count = count;
	}

	public String toString() {
		return String.format("%s [%d] (%d)", name, count, weight);
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public int getCount() {
		return count;
	}
}