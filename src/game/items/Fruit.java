package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.HealingAction;

/**
 * <h1>Fruit class</h1>
 * The Fruit class is an Item class responsible for setting out the attributes and
 * behaviours of SmallFruit objects. A SmallFruit can be picked up and consumed,
 * providing Actors a HealingAction of a specified number of health points
 *
 * @author Jeremiah Saemo
 */
public class Fruit extends Item implements SpecialScrap {

    /**
     * The amount of health points that a Fruit provides when consumed
     */
    private int health;
    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public Fruit(String name, char displayChar, boolean portable, int health) {
        super(name, displayChar, portable);
        this.health = health;
    }

    /**
     * Fruit provides HealingAction to its owner to heal by a number of health points
     * @param owner the actor that owns the item
     * @return actions list with new HealingAction
     */
    @Override
    public ActionList allowableActions(Actor owner){
        ActionList actions = super.allowableActions(owner);
        actions.add(new HealingAction(this, health));
        return actions;
    }
}
