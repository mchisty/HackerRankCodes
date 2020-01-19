package org.siteminder;

/**
 * The Enum EmailPropEnum.
 */
public enum EmailPropEnum {

	/** The to. */
	TO("to"),

	/** The from. */
	FROM("from"),

	/** The subject. */
	SUBJECT("subject"),

	/** The text. */
	TEXT("text");

	/** The val. */
	String val;
	
	/**
	 * Instantiates a new email prop enum.
	 *
	 * @param value the value
	 */
	private EmailPropEnum(String value) {
		this.val = value;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}
}
