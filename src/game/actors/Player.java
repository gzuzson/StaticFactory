package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Ability;
import game.FancyMessage;
import game.Status;

/**
 * <h1>Player class</h1>
 * The Player class is a concrete Actor class that is responsible for outlining the
 * behaviours and attributes of Player object.
 *
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Jeremiah Saemo
 *
 */
public class Player extends Actor {
    /**
     * Constructor for the Player class
     * Player is given Status capability of being hostile to enemy, and Ability to pick up scraps
     * and enter doors by default.
     *
     * @param name        Name to call the player in the UI
     * @param displayChar Character to represent the player in the UI
     * @param hitPoints   Player's starting number of hitpoints
     */
    public Player(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.HOSTILE_TO_ENEMY);
        this.addCapability(Ability.CAN_PICKUP_SCRAP);
        this.addCapability(Ability.ENTER_DOOR);
    }

    /**
     * Select and return an action to perform on the current turn.
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the Action to be performed
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // Handle multi-turn Actions
        if (lastAction.getNextAction() != null)
            return lastAction.getNextAction();

        // return/print the console menu
        Menu menu = new Menu(actions);
        return menu.showMenu(this, display);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(1, "punches", 5);
    }

    /**
     * Unconscious method for Player which returns FancyMessage if called upon.
     * @param actor the perpetrator
     * @param map where the actor fell unconscious
     * @return confirmation that actor is unconscious with FancyMessage
     */
    @Override
    public String unconscious(Actor actor, GameMap map) {
        map.removeActor(this);
        return this + " met their demise at the hand of " + actor + "\n" + FancyMessage.YOU_ARE_FIRED;
    }
}
