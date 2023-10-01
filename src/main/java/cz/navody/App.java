package cz.navody;

import cz.navody.Coin.Copper;
import cz.navody.Coin.Gold;
import cz.navody.Coin.Silver;
import cz.navody.Inventory.Inventory;
import cz.navody.Item.Armor;
import cz.navody.Item.Item;
import cz.navody.Item.Letter;
import cz.navody.Item.Shield;
import cz.navody.Item.Weapon;

public class App {
    public static void main( String[] args )
    {
        printDelayed( "Creating characters..." );
        Character character1 = new Character("Dio");
        Character character2 = new Character("Jotaro");

        printDelayed( "Equipping weapons..." );
        try {
            character1.getInventory().add(new Weapon("Sword", 10, 15, Weapon.Type.ONE_HAND), Inventory.Type.HAND);
            character1.getInventory().add(new Shield("Shield", 10, 10), Inventory.Type.OFF_HAND);

            character2.getInventory().add(new Weapon("Sword", 20, 30, Weapon.Type.BOTH_HANDS), Inventory.Type.HAND);
            character2.getInventory().add(new Shield("Shield", 10, 10), Inventory.Type.OFF_HAND);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        printDelayed( "Equipping armor..." );
        try {
            character1.getInventory().add(new Armor("Armor", 20, 25), Inventory.Type.BODY);
            character2.getInventory().add(new Armor("Armor", 15, 15), Inventory.Type.BODY);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        printDelayed( "Grabbing random garbage..." );
        try {
            character1.getInventory().add(new Item("Paper", 1));
            character1.getInventory().add(new Letter("Letter", "You need to return!\nWe need you!", "Your mother"));
            character1.getInventory().add(new Item("Rock", 5, 3));

            character2.getInventory().add(new Item("Lead ingot", 20));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        printDelayed( "Getting rich..." );
        try {
            character1.getInventory().add(new Copper(5));
            character1.getInventory().add(new Silver(10));
            character1.getInventory().add(new Gold(3));

            character2.getInventory().add(new Copper(10));
            character2.getInventory().add(new Silver(5));
            character2.getInventory().add(new Gold(1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        printDelayed("");
        System.out.println(character1.getName());
        character1.getInventory().display();

        System.out.println();
        System.out.println(character2.getName());
        character2.getInventory().display();

        printDelayed("");

        while (true) {
            if (attack(character1, character2)) {
                printDelayed(String.format("%s is dead!", character2.getName()));
                break;
            }
            if (attack(character2, character1)) {
                printDelayed(String.format("%s is dead!", character1.getName()));
                break;
            }
        }
    }

    static boolean attack(Character attacker, Character defender) {
        int attackAmount = attacker.getAttackAmount();
        int protectionAmount = defender.getProtectionAmount();
        int damage = getPositive(attackAmount - protectionAmount);

        System.out.println(String.format("%s is attacking %s!", attacker.getName(), defender.getName()));
        System.out.println(String.format("%s's health: %s", defender.getName(), defender.getHealth()));
        System.out.println(String.format("%s attacks with %d damage", attacker.getName(), attackAmount));
        System.out.println(String.format("%s defends with %d protection", defender.getName(), protectionAmount));
        System.out.println(String.format("%s's final damage is: %d", defender.getName(), damage));

        boolean isDead = defender.damage(damage);

        if (!isDead) {
            System.out.println(String.format("%s's health: %s", defender.getName(), defender.getHealth()));
        }

        System.out.println();

        return isDead;
    }

    static void printDelayed(String message) {
        try {
            Thread.sleep(1000);
            System.out.println(message);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    static int getPositive(int input) {
        if (input < 0) {
            return 0;
        }
        return input;
    }
}
