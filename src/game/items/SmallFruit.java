package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.HealingAction;

/**
 * <h1>SmallFruit class</h1>
 * The SmallFruit class is an Item class responsible for setting out the attributes and
 * behaviours of SmallFruit objects. A SmallFruit can be picked up and consumed,
 * providing Actors a HealingAction of 1 health point
 *
 * @author Jeremiah Saemo
 */
public class SmallFruit extends Fruit {
    /***
     * Constructor for the SmallFruit class
     */
    public SmallFruit() {
        super("Small Fruit", 'o', true, 1);
    }
}