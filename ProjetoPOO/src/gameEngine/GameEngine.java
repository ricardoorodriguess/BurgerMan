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

    @Override
    public void addEnabled(IGameObject gameObject) {

    }

    @Override
    public void addDisabled(IGameObject gameObject) {

    }

    @Override
    public void enable(IGameObject gameObject) {

    }

    @Override
    public void disable(IGameObject gameObject) {

    }

    @Override
    public boolean isEnabled(IGameObject gameObject) {
        return false;
    }

    @Override
    public boolean isDisabled(IGameObject gameObject) {
        return false;
    }

    @Override
    public List<IGameObject> getEnabled() {
        return List.of();
    }

    @Override
    public List<IGameObject> getDisabled() {
        return List.of();
    }

    /**
     * Destroy IGameObject gameObject whether it is enabled or disabled
     * pre: gameObject != null
     * pos: gameObject.onDestroy()
     *
     * @param gameObject
     */
    @Override
    public void destroy(IGameObject gameObject) {

    }

    /**
     * Destroy all IGameObjects
     * pos: calls onDesttoy for each IGameObject
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
     * pos: Ul.input() &&
     * calls Behaviour.onUpdate() for all enabled objects && Behaviour.checkCollisions() &&
     * Ul.draw()
     */
    @Override
    public void run() {

    }

    /**
     * Check collisions for all the enabled objects
     * pos: calls Behaviour.onCollision(goI) for all enabled GameObjects passing in the list of all the objects that
     * collided with each IGameObject
     */
    @Override
    public void checkCollisions() {

    }
}
