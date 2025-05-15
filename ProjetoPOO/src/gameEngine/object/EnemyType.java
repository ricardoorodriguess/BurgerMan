package gameEngine.object;

public enum EnemyType {
    GREEN_TRASH("Green Trash"),
    GRAY_TRASH("Gray Trash");

    final String name;

    /**
     * Construtor do tipo.
     * @param name Nome legível do tipo (usado para identificação e exibição).
     */
    EnemyType(String name) {
        this.name = name;
    }

    /**
     * Retorna o nome legível do tipo.
     * @return Nome do tipo.
     */
    public String getName() {
        return name;
    }
}