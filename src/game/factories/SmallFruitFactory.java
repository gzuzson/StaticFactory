package game.factories;

import edu.monash.fit2099.engine.items.Item;
import game.items.SmallFruit;

/**
 * <h1>SmallFruitFactory Class</h1>
 * The SmallFruitFactory class is an implementation of a FruitFactory
 * which provides a way to create new SmallFruit items
 *
 * @author Jeremiah Saemo
 */
public class SmallFruitFactory implements FruitFactory {
    @Override
    public Item createFruit() {
        return new SmallFruit();
    }
}
