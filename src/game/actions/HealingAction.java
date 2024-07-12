package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * <h1>HealingAction class</h1>
 * The HealingAction class outlines the Action of an Item that heals its owner by a
 * specified number of health points.
 *
 * @author Jeremiah Saemo
 */
public class HealingAction extends Action {

    /**
     * The Item that will provide the HealingAction
     */
    private final Item item;

    /**
     * The amount of health that the HealingAction will provide once taken
     */
    private final int healthPoints;

    /**
     * Constructor for the HealingAction class
     * @param _item the item that will provide the HealingAction
     * @param _healthPoints the amount of health that the HealingAction will provide once taken
     */
    public HealingAction(Item _item, int _healthPoints) {
        this.item = _item;
        this.healthPoints = _healthPoints;
    }

    /**
     * execute method which heals actor by healthPoints, then removes Item that provided the health
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return confirmation that actor has been healed
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        actor.heal(healthPoints);
        actor.removeItemFromInventory(item);
        return actor + " has been healed " + healthPoints + " points";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Consume " + item.toString() + " to heal " + healthPoints + " points";
    }
}