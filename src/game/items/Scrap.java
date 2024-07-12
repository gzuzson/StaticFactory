package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.Location;
import game.Ability;

/**
 * <h1>Scrap class</h1>
 * The Scrap class is an Item class responsible for outlining the attributes and behaviours
 * of Scrap objects.
 *
 * @author Jeremiah Saemo
 */

public class Scrap extends Item {
    /***
     * Constructor for the Scrap class
     * @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * portable is set to false by default for Scrap objects
     */
    public Scrap(String name, char displayChar) {
        super(name, displayChar, false);
    }

    /**
     * List of allowable actions that can be performed on the item when it is on the ground
     * Will add a new PickUpAction to the actions list if actor on location has ability CAN_PICKUP_SCRAP
     *
     * @param location the location of the ground on which the item lies
     * @return an unmodifiable list of Actions
     */
    @Override
    public ActionList allowableActions(Location location) {
        ActionList actions = super.allowableActions(location);

        if(location.getActor().hasCapability(Ability.CAN_PICKUP_SCRAP)) {
            actions.add(new PickUpAction(this));
        }
        return actions;
    }

    /**
     * List of allowable actions that the item can perform to the current actor
     * Will add a new DropAction to the actions list if actor on location has ability CAN_PICKUP_SCRAP
     *
     * @param owner the actor that owns the item
     * @return an unmodifiable list of Actions
     */
    @Override
    public ActionList allowableActions(Actor owner){
        ActionList actions = super.allowableActions(owner);

        if(owner.hasCapability(Ability.CAN_PICKUP_SCRAP)) {
            actions.add(new DropAction(this));
        }
        return actions;
    }
}
