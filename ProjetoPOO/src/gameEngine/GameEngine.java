package gameEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represent a various gameObjects in an arrayList
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version March 27, 2025
 */
public class GameEngine implements IGameEngine {
    private final ArrayList<GameObject> loadedObjects;

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

    }

    /**
     * Destroy all IGameObjects
     * @pos: calls onDesttoy for each IGameObject
     */
    @Override
    public void destroyAll() {

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
}
