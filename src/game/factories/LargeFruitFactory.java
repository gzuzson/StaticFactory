package game.factories;

import edu.monash.fit2099.engine.items.Item;
import game.items.LargeFruit;

/**
 * <h1>LargeFruitFactory Class</h1>
 * The LargeFruitFactory class is an implementation of a FruitFactory
 * which provides a way to create new LargeFruit items
 *
 * @author Jeremiah Saemo
 */
public class LargeFruitFactory implements FruitFactory {
    @Override
    public Item createFruit() {
        return new LargeFruit();
    }
}
