package cz.navody;

import java.util.Random;

import cz.navody.Inventory.Inventory;
import cz.navody.Inventory.Inventory.Type;
import cz.navody.Item.Armor;
import cz.navody.Item.Shield;
import cz.navody.Item.Weapon;

public class Character {
	private String name;
	private int strength;
	private int dexterity;
	private int maxHealth;
	private int currentHealth;

	private Inventory inventory;

	public Character(String name) {
		Random random = new Random();

		this.name = name;
		this.strength = random.nextInt(10) + 1;
		this.dexterity = random.nextInt(10) + 1;
		this.maxHealth = random.nextInt(100) + 1;
		this.currentHealth = this.maxHealth;
		this.inventory = new Inventory(100);
	}

	public String toString() {
		return String.format("%s (strength: %d, dexterity: %d, maxHealth: %d, money: %s), inventory: %s",this.name, this.strength, this.dexterity, this.maxHealth, inventory.getMoney(), this.inventory);
	}

	public Inventory getInventory() {
		return this.inventory;
	}

	public String getName() {
		return this.name;
	}

	public int getHealth() {
		return this.currentHealth;
	}

	public boolean damage(int amount) {
		this.currentHealth -= amount;

		return this.currentHealth <= 0;
	}

	public int getProtectionAmount() {
		Random random = new Random();
		int protection = 0;

		if (!this.inventory.get(Type.BODY).isEmpty()) {
			protection += ((Armor) this.inventory.get(Type.BODY).get(0)).getMaxProtection();
		}

		if (!this.inventory.get(Type.OFF_HAND).isEmpty()) {
			protection += ((Shield) this.inventory.get(Type.OFF_HAND).get(0)).getMaxProtection();
		}

		protection *= this.dexterity;

		return protection / (random.nextInt(5) + 5);
	}

	public int getAttackAmount() {
		Random random = new Random();
		int attack = 0;

		if (!this.inventory.get(Type.HAND).isEmpty()) {
			attack += ((Weapon) this.inventory.get(Type.HAND).get(0)).getMaxDamage();
		}

		attack *= this.strength;

		return attack / (random.nextInt(5) + 5);
	}
}
