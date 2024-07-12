package game.factories;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * <h1>CreatureFactory Interface</h1>
 * The CreatureFactory Interface represents a factory for creating new creature-type Actors,
 * such as the HuntsmanSpider.
 * Implementations of this interface should provide a way to create different types of Creature Actors.
 *
 * @author Jeremiah Saemo
 */

public interface CreatureFactory {
    /**
     * Creates a new Actor
     * @return a new Actor created by the factory.
     */
    public Actor createCreature();
}
