package cz.navody.Item;

public class Letter extends Item {
	private String text;
	private String sender;

	public Letter(String name, String text, String sender) {
		super(name, 1);
		this.text = text;
		this.sender = sender;
	}

	public String read() {
		return String.format("--------------------\n%s\n\nSincerely,\n%s\n--------------------", text, sender);
	}
}
