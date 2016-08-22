package org.hackerrank.customclass;

public class Card {
    private String name;

    public Card() {
	name = "unknown";
    }

    // @Override
    public String getName() {
	return "Test";
    }

    @Override
    public String toString() {
	return getName();
    }
}
