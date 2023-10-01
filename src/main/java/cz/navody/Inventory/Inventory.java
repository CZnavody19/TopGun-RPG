package cz.navody.Inventory;

import java.util.ArrayList;

import cz.navody.Coin.Coin;
import cz.navody.Inventory.Exceptions.InventoryFullException;
import cz.navody.Inventory.Exceptions.WeaponException;
import cz.navody.Item.Armor;
import cz.navody.Item.Item;
import cz.navody.Item.Shield;
import cz.navody.Item.Weapon;

public class Inventory {
	private ArrayList<Item> items;
	private Armor body;
	private Weapon hand;
	private Shield offHand;

	private int loadCapacity;
	private int load;

	public Inventory(int loadCapacity) {
		this.loadCapacity = loadCapacity;
		this.items = new ArrayList<Item>();
		this.load = 0;
	}

	public String toString() {
		return String.format("%d/%d (%s)", load, loadCapacity, items);
	}

	public void add(Item item, Type type) throws InventoryFullException, WeaponException {
		if (load + item.getWeight() <= loadCapacity) {
			switch (type) {
				case INVENTORY:
					this.items.add(item);
					this.load += item.getWeight() * item.getCount();
					break;

				case BODY:
					this.body = (Armor) item;
					this.load += item.getWeight() * item.getCount();
					break;

				case HAND:
					Weapon weapon = (Weapon) item;
					if (weapon.getType() == Weapon.Type.BOTH_HANDS && this.offHand != null) {
						throw new WeaponException("You can't hold a two-hand weapon with a shield!");
					}
					this.hand = weapon;
					this.load += item.getWeight() * item.getCount();
					break;

				case OFF_HAND:
					if (this.hand != null && this.hand.getType() == Weapon.Type.BOTH_HANDS) {
						throw new WeaponException("You can't hold a shield with a two-hand weapon!");
					}
					this.offHand = (Shield) item;
					this.load += item.getWeight() * item.getCount();
					break;
			}
		} else {
			throw new InventoryFullException("Item is too heavy!");
		}
	}

	public void add(Item item) throws InventoryFullException, WeaponException {
		this.add(item, Type.INVENTORY);
	}

	public int getMoney() {
		int money = 0;
		for (Item item : items) {
			if (item instanceof Coin) {
				Coin coin = (Coin) item;
				money += coin.getValue() * coin.getCount();
			}
		}
		return money;
	}

	public ArrayList<Item> get(Type type) {
		switch (type) {
			case INVENTORY:
				return this.items;

			case BODY:
				ArrayList<Item> body = new ArrayList<Item>();
				if (this.body != null) {
					body.add(this.body);
				}
				return body;

			case HAND:
				ArrayList<Item> hand = new ArrayList<Item>();
				if (this.hand != null) {
					hand.add(this.hand);
				}
				return hand;

			case OFF_HAND:
				ArrayList<Item> offHand = new ArrayList<Item>();
				if (this.offHand != null) {
					offHand.add(this.offHand);
				}
				return offHand;

			default:
				return new ArrayList<Item>();
		}
	}

	public void display() {
		int nameMax = 0;
		int weightMax = 0;
		int countMax = 0;
		for (Item item : items) {
			if (item.getName().length() > nameMax) {
				nameMax = item.getName().length();
			}

			if (String.valueOf(item.getWeight()).length() > weightMax) {
				weightMax = String.valueOf(item.getWeight()).length();
			}

			if (String.valueOf(item.getCount()).length() > countMax) {
				countMax = String.valueOf(item.getCount()).length();
			}
		}
		countMax += 1;

		System.out.println(centerString("Inventory", nameMax + weightMax + countMax + 4));

		System.out.print("+");
		for (int i = 0; i < nameMax; i++) {
			System.out.print("-");
		}
		System.out.print("+");
		for (int i = 0; i < weightMax; i++) {
			System.out.print("-");
		}
		System.out.print("+");
		for (int i = 0; i < countMax; i++) {
			System.out.print("-");
		}
		System.out.println("+");

		for (Item item : items) {
			System.out.println(String.format("|%s|%s|%s|", centerString(item.getName(), nameMax),
					centerString(String.valueOf(item.getWeight()), weightMax),
					centerString(String.valueOf(item.getCount()) + "x", countMax)));

			System.out.print("+");
			for (int i = 0; i < nameMax; i++) {
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < weightMax; i++) {
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < countMax; i++) {
				System.out.print("-");
			}
			System.out.println("+");
		}

		System.out.println(
				centerString(String.format("Load: %d/%d", load, loadCapacity), nameMax + weightMax + countMax + 4));
	}

	private String centerString(String input, int length) {
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < (length - input.length()) / 2; i++) {
			sb.append(" ");
		}
		sb.append(input);
		while (sb.length() < length) {
			sb.append(" ");
		}
		return sb.toString();
	}

	public enum Type {
		INVENTORY, BODY, HAND, OFF_HAND
	}
}