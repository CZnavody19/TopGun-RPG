package cz.navody;

import org.junit.Test;

import cz.navody.Item.Armor;
import cz.navody.Item.Item;
import cz.navody.Item.Letter;
import cz.navody.Item.Shield;
import cz.navody.Item.Weapon;

public class ItemTest {
	@Test
	public void itemTest() {
		Item item = new Item("Rock", 1, 3);

		assert item.getName().equals("Rock");
		assert item.getWeight() == 3;
	}

	@Test
	public void letterTest() {
		Letter letter = new Letter("Letter", "You need to return!\nWe need you!", "Your mother");

		assert letter.getName().equals("Letter");
		assert letter.getWeight() == 1;
		assert letter.read().equals("--------------------\nYou need to return!\nWe need you!\n\nSincerely,\nYour mother\n--------------------");
	}

	@Test
	public void weaponTest() {
		Weapon weapon = new Weapon("Sword", 1, 10, Weapon.Type.ONE_HAND);

		assert weapon.getName().equals("Sword");
		assert weapon.getWeight() == 1;
		assert weapon.getType() == Weapon.Type.ONE_HAND;
		assert weapon.getMaxDamage() == 10;
	}

	@Test
	public void armorTest() {
		Armor armor = new Armor("Leather armor", 1, 10);

		assert armor.getName().equals("Leather armor");
		assert armor.getWeight() == 1;
		assert armor.getMaxProtection() == 10;
	}

	@Test
	public void shieldTest() {
		Shield shield = new Shield("Shield", 1, 10);

		assert shield.getName().equals("Shield");
		assert shield.getWeight() == 1;
		assert shield.getMaxProtection() == 10;
	}
}
