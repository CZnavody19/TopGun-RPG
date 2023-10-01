package cz.navody.Inventory;

public class Exceptions {
	public static class InventoryFullException extends Exception {
		public InventoryFullException(String message) {
			super(message);
		}
	}

	public static class WeaponException extends Exception {
		public WeaponException(String message) {
			super(message);
		}
	}
}
