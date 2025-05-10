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

    /**
     * Converte uma string (nome legível) em um tipo enum.
     * @param name Nome legível do tipo.
     * @return Valor enum correspondente ou null se não encontrado.
     */
    public static Type fromName(String name) {
        for (Type type : Type.values()) {
            if (type.name.equalsIgnoreCase(name)) {
                return type;
            }
        }
        return null;
    }
}