package game.factories;

import edu.monash.fit2099.engine.items.Item;

/**
 * <h1>FruitFactory Interface</h1>
 * The FruitFactory Interface represents a factory for creating Fruit Items.
 * Implementations of this interface should provide a way to create different types of fruit items.
 *
 * @author Jeremiah Saemo
 */
public interface FruitFactory {
    /**
     * Creates a new Fruit item
     * @return a new Fruit item created by the factory.
     */
    public Item createFruit();
}
