package gameEngine.object;

public enum Type {
    POINT("Point"),
    TOMATO("Tomato"),
    ONION("Onion"),
    CHEESE("Cheese"),
    PICKLE("Pickle");

    final String name;

    Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}