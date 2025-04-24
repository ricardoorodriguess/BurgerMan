package game;

import collisions.Colisor;
import collisions.Point;

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
public class GameEngine {
    private final ArrayList<GameObject> loadedObjects;

    /**
     * Construtor of game.GameEngine
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

    public void with(Predicate<GameObject> predicate, Consumer<GameObject> consumer) {
        for (GameObject go : loadedObjects)
            if (predicate.test(go))
                consumer.accept(go);
    }

    public void withFirst(Predicate<GameObject> predicate, Consumer<GameObject> consumer) {
        for (GameObject go : loadedObjects)
            if (predicate.test(go)) {
                consumer.accept(go);
                return;
            }
    }

    public void alertScoreboard(Consumer<Scoreboard> consumer) {
        withFirst(GameObject::isScoreboard, go -> consumer.accept((Scoreboard) go));
    }

    public void alertPlayer(Consumer<Player> consumer) {
        withFirst(GameObject::isPlayer, go -> consumer.accept((Player) go));
    }

    public void withRandom(Predicate<GameObject> predicate, Consumer<GameObject> consumer) {
        List<GameObject> matched = loadedObjects
                .stream()
                .filter(predicate)
                .toList();
        if (matched.isEmpty()) return;
        consumer.accept(matched.get(Client.RANDOM.nextInt(matched.size())));
    }

    public boolean placeMeeting(Predicate<GameObject> predicate, Point point) {
        Colisor colisor;
        for (GameObject go : loadedObjects)
            if (predicate.test(go) && (colisor = (Colisor) go.collider()) != null && colisor.contains(point))
                return true;
        return false;
    }
}
