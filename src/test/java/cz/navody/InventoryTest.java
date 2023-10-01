package cz.navody;

import org.junit.Test;

import cz.navody.Inventory.Inventory;
import cz.navody.Item.Armor;
import cz.navody.Coin.Copper;
import cz.navody.Coin.Gold;
import cz.navody.Coin.Silver;
import cz.navody.Item.Item;
import cz.navody.Item.Letter;
import cz.navody.Item.Shield;
import cz.navody.Item.Weapon;

public class InventoryTest {
	public Inventory generateDummy() {
		Inventory inventory = new Inventory(100);

		try {
			inventory.add(new Armor("Leather armor", 1, 10), Inventory.Type.BODY);
			inventory.add(new Weapon("Sword", 1, 10, Weapon.Type.ONE_HAND), Inventory.Type.HAND);
			inventory.add(new Shield("Shield", 1, 10), Inventory.Type.OFF_HAND);
			inventory.add(new Item("Paper", 1));
			inventory.add(new Letter("Letter", "You need to return!\nWe need you!", "Your mother"));
			inventory.add(new Item("Rock", 1, 3));
			inventory.add(new Copper(5));
			inventory.add(new Silver(4));
			inventory.add(new Gold(3));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return inventory;
	}

	@Test
	public void inventoryTest() {
		Inventory inventory = generateDummy();

		assert inventory.get(Inventory.Type.BODY).size() == 1;
		assert inventory.get(Inventory.Type.HAND).size() == 1;
		assert inventory.get(Inventory.Type.OFF_HAND).size() == 1;
		assert inventory.get(Inventory.Type.INVENTORY).size() == 6;
	}

	@Test
	public void inventoryWeightTest() {
		Inventory inventory = generateDummy();

		try {
			inventory.add(new Item("Rock", 20, 3));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		assert inventory.get(Inventory.Type.INVENTORY).size() == 6;
	}

	@Test
	public void inventoryMoneyTest() {
		Inventory inventory = generateDummy();

		assert inventory.getMoney() == 345;
	}

	@Test
	public void inventoryAddGetTest() {
		Inventory inventory = generateDummy();

		try {
			inventory.add(new Item("Rock", 20, 3));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		assert inventory.get(Inventory.Type.INVENTORY).size() == 6;
		assert inventory.getMoney() == 345;
	}
}
