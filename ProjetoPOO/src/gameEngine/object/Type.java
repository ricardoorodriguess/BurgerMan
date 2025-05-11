package gameEngine.object;

public enum Type {
    //Tipos genericos pré-definidos
    POINT("Point"),
    TOMATO("Tomato"),
    ONION("Onion"),
    CHEESE("Cheese"),
    PICKLE("Pickle");

    final String name;

    /**
     * Construtor do tipo.
     * @param name Nome legível do tipo (usado para identificação e exibição).
     */
    Type(String name) {
        this.name = name;
    }

}