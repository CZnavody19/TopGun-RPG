package cz.navody;

import org.junit.Test;

import cz.navody.Inventory.Inventory;
import cz.navody.Item.Armor;
import cz.navody.Item.Shield;
import cz.navody.Item.Weapon;

public class CharacterTest {
	@Test
	public void characterTest() {
		Character character = new Character("Dio");

		assert character.getName().equals("Dio");
		assert character.getHealth() > 0;
	}

	@Test
	public void characterInventoryTest() {
		Character character = new Character("Dio");

		assert character.getInventory().get(Inventory.Type.BODY).isEmpty();
		assert character.getInventory().get(Inventory.Type.HAND).isEmpty();
		assert character.getInventory().get(Inventory.Type.OFF_HAND).isEmpty();
		assert character.getInventory().get(Inventory.Type.INVENTORY).isEmpty();
	}

	@Test
	public void characterDamageTest() {
		Character character = new Character("Dio");

		assert !character.damage(0);
		assert character.damage(100);
		assert character.getHealth() <= 0;
	}

	@Test
	public void characterProtectionTest() {
		Character character = new Character("Dio");

		assert character.getProtectionAmount() == 0;
	}

	@Test
	public void characterMoneyTest() {
		Character character = new Character("Dio");

		assert character.getInventory().getMoney() == 0;
	}

	@Test
	public void characterEquipTest() {
		Character character = new Character("Dio");

		try {
			character.getInventory().add(new Weapon("Sword", 10, 15, Weapon.Type.ONE_HAND), Inventory.Type.HAND);
			character.getInventory().add(new Shield("Shield", 10, 10), Inventory.Type.OFF_HAND);
			character.getInventory().add(new Weapon("Sword", 20, 30, Weapon.Type.BOTH_HANDS), Inventory.Type.HAND);
			character.getInventory().add(new Shield("Shield", 10, 10), Inventory.Type.OFF_HAND);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		assert character.getInventory().get(Inventory.Type.HAND).size() == 1;
		assert character.getInventory().get(Inventory.Type.OFF_HAND).size() == 1;
	}

	@Test
	public void characterEquipArmorTest() {
		Character character = new Character("Dio");

		try {
			character.getInventory().add(new Armor("Armor", 20, 25), Inventory.Type.BODY);
			character.getInventory().add(new Armor("Armor", 15, 15), Inventory.Type.BODY);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		assert character.getInventory().get(Inventory.Type.BODY).size() == 1;
	}
}
