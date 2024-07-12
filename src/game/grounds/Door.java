package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.Ability;

/**
 * <h1>Door class</h1>
 * The Door class is a Ground class built for the purpose of allowing
 * only specific Actors into certain areas of the Map. Only Actors who have
 * the Ability of ENTER_DOOR will be allowed to walk on this Ground.
 *
 * @author Jeremiah Saemo
 */
public class Door extends Ground {
    /**
     * Constructor for the Door class
     */
    public Door() {
        super('|');
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Ability.ENTER_DOOR);
    }
}
