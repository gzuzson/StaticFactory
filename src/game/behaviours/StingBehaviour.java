package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.actions.AttackAction;

import java.util.List;

/**
 * <h1>StingBehaviour Class</h1>
 * The StingBehaviour class is a Behaviour class used by enemy-type Actors,
 * such as the HuntsmanSpider, and is responsible for returning an AttackAction
 * if an Actor with the capability HOSTILE_TO_ENEMY is in the enemy-type Actors'
 * vicinity
 *
 * @author Jeremiah Saemo
 */
public class StingBehaviour implements Behaviour {

    /**
     * Returns a new AttackAction if there is an Actor with the status HOSTILE_TO_ENEMY
     * at one of the exits of the Actor's location.
     * @param actor the Actor (enemy-type) that may make a new AttackAction
     * @param map the GameMap containing the Actor
     * @return new AttackAction or return null
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        List<Exit> exits = here.getExits();

        for(Exit exit : exits) {
            Actor target = exit.getDestination().getActor();

            if(target != null && target.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                return new AttackAction(target, exit.toString());
            }
        }
        return null;
    }
}
