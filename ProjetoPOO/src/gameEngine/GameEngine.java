package gameEngine;

import gameEngine.object.GameObject;
import gameEngine.object.IGameObject;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * This class represent a various gameObjects in an arrayList
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version March 27, 2025
 */
public class GameEngine implements IGameEngine {
    private final ArrayList<GameObject> loadedObjects;
    private static int TOTAL_SCORE = 0, TOTAL_LIVES = 3;

    /**
     * Construtor of GameEngine
     */
    public GameEngine() {
        this.loadedObjects = new ArrayList<>();
    }

    /**
     * Method do add gameObjects to arrayList
     * @param gameObject
     */
    public void add(GameObject gameObject) {
        loadedObjects.add(gameObject);
    }

    /**
     * Method do remove gameObjects from arrayList
     * @param gameObject
     */
    public void destroy(GameObject gameObject) {
        if (gameObject == null) return;
        loadedObjects.remove(gameObject);
    }

    /**
     * Response method to give the ArrayList of gameObjects.
     * @return the List of gameObjets in engine
     */
    public ArrayList<GameObject> getLoadedObjects() {return loadedObjects;}

    /**
     * Adiciona um GameObject à lista de objetos habilitados (ativos no jogo).
     * @param gameObject GameObject a ser ativado.
     * @pre gameObject != null
     * @post GameObject é atualizado e verifica colisões.
     */
    @Override
    public void addEnabled(IGameObject gameObject) {

    }

    /**
     * Adiciona um GameObject à lista de objetos desabilitados (inativos).
     * @param gameObject GameObject a ser desativado.
     * @pre gameObject != null
     * @post GameObject não é mais atualizado.
     */
    @Override
    public void addDisabled(IGameObject gameObject) {

    }

    /**
     * Habilita um GameObject previamente desabilitado.
     * @param gameObject GameObject a ser reativado.
     * @pre gameObject está em disabledObjects
     * @post GameObject é movido para enabledObjects
     */
    @Override
    public void enable(IGameObject gameObject) {

    }

    /**
     * Desabilita um GameObject ativo.
     * @param gameObject GameObject a ser desativado.
     * @pre gameObject está em enabledObjects
     * @post GameObject é movido para disabledObjects
     */
    @Override
    public void disable(IGameObject gameObject) {

    }

    /**
     * Verifica se um GameObject está ativo.
     * @param gameObject GameObject a ser verificado.
     * @return true se o objeto está em enabledObjects.
     */
    @Override
    public boolean isEnabled(IGameObject gameObject) {
        return false;
    }

    /**
     * Verifica se um GameObject está inativo.
     * @param gameObject GameObject a ser verificado.
     * @return true se o objeto está em disabledObjects.
     */
    @Override
    public boolean isDisabled(IGameObject gameObject) {
        return false;
    }

    /**
     * Retorna todos os GameObjects ativos.
     * @return Lista de objetos em enabledObjects.
     */
    @Override
    public List<IGameObject> getEnabled() {
        return List.of();
    }

    /**
     * Retorna todos os GameObjects inativos.
     * @return Lista de objetos em disabledObjects.
     */
    @Override
    public List<IGameObject> getDisabled() {
        return List.of();
    }

    /**
     * Destroy IGameObject gameObject whether it is enabled or disabled
     * @pre: gameObject != null
     * @pos: gameObject.onDestroy()
     *
     * @param gameObject
     */
    @Override
    public void destroy(IGameObject gameObject) {
        destroy((GameObject) gameObject);
    }

    /**
     * Destroy all IGameObjects
     * @pos: calls onDesttoy for each IGameObject
     */
    @Override
    public void destroyAll() {
        loadedObjects.clear();
    }
    /**
     * Manipula a transform
     * Generates a new frame:
     * Get user input from Ul
     * update all the enabled GameObjects
     * check collisions and send info to GameObjects
     * update Ul
     * @pos: Ul.input() &&
     * calls Behaviour.onUpdate() for all enabled objects && Behaviour.checkCollisions() &&
     * Ul.draw()
     */
    @Override
    public void run() {

    }

    /**
     * Check collisions for all the enabled objects
     * @pos: calls Behaviour.onCollision(goI) for all enabled GameObjects passing in the list of all the objects that
     * collided with each IGameObject
     */
    @Override
    public void checkCollisions() {

    }

    /**
     * Retorna um GameObject aleatório que satisfaz um predicado.
     * @param predicate Condição para filtrar objetos.
     * @return GameObject aleatório ou null se nenhum for encontrado.
     */
    public @Nullable GameObject randomObject(Predicate<GameObject> predicate) {
        List<GameObject> list = loadedObjects.stream().filter(predicate).toList();
        if (list.isEmpty()) return null;
        return list.get(Client.RANDOM.nextInt(list.size()));
    }

    /**
     * Incrementa a pontuação total do jogador.
     * @param points Pontos a serem adicionados.
     */
    public void incrementScore(int points) {
        TOTAL_SCORE += points;
    }

    /**
     * Atualiza o número de vidas do jogador.
     * @param lives Novo número de vidas.
     */
    public void updateLives(int lives) {
        TOTAL_LIVES = lives;
    }

    /**
     * Retorna a pontuação atual do jogador.
     * @return Pontuação total.
     */
    public int getScore() { return TOTAL_SCORE; }

    /**
     * Retorna o número de vidas restantes do jogador.
     * @return Número de vidas.
     */
    public int getLives() { return TOTAL_LIVES; }

    /**
     * Reinicia a pontuação do jogador para zero.
     */
    public void resetScore() { TOTAL_SCORE = 0; }

    /**
     * Reinicia o número de vidas do jogador para zero.
     */
    public void resetLives() { TOTAL_LIVES = 0; }

    /**
     * Verifica se um GameObject foi destruído.
     * @param iGameObject Objeto a ser verificado.
     * @return true se o objeto foi destruído (implementação temporária).
     */
    public boolean isDestroyed(IGameObject iGameObject) {
        return true; //FAZER
    }
}
