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

    /**
     * Retorna o nome legível do tipo.
     * @return String com o nome do tipo (ex: "Tomato").
     */
    public String getName() {
        return name;
    }

    public Type getType(String name) {
        for (Type type : Type.values()) {
            if (type.getName().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return null; // Retorna null se o tipo não for encontrado
    }
}