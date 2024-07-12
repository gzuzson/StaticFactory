package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.HealingAction;

/**
 * <h1>LargeFruit class</h1>
 * The LargeFruit class is a Fruit class responsible for setting out the attributes and
 * behaviours of LargeFruit objects. The LargeFruit Item can be picked up and consumed,
 * providing Actors a HealingAction of 2 health points
 *
 * @author Jeremiah Saemo
 */
public class LargeFruit extends Fruit {
    /***
     * Constructor for the LargeFruit class
     */
    public LargeFruit() {
        super("Large Fruit", 'O', true, 2);
    }
}
