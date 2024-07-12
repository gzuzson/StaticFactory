package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Status;
import game.behaviours.StingBehaviour;
import game.behaviours.WanderBehaviour;
import game.actions.AttackAction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <h1>HuntsmanSpider class</h1>
 * The HuntsmanSpider class is an enemy Actor class that has the primary behaviours of
 * wandering and attacking Actor's which have the status HOSTILE_TO_ENEMY, such as the
 * Intern.
 *
 * @author Jeremiah Saemo
 */
public class HuntsmanSpider extends Actor {
    private Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * Constructor for the HuntsmanSpider class
     */
    public HuntsmanSpider() {
        super("Huntsman Spider", '8', 1);
        this.behaviours.put(999, new WanderBehaviour());
        this.behaviours.put(998, new StingBehaviour());
    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * The huntsman spider can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = super.allowableActions(otherActor, direction, map);
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(1, "stings", 25);
    }
}
