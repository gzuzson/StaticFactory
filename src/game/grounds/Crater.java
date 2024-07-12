package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.factories.CreatureFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * <h1>Crater Class</h1>
 * The Crater class is a Ground class responsible for spawning creatures such
 * as the HuntsmanSpider at the crater's exit locations.
 *
 * @author Jeremiah Saemo
 */
public class Crater extends Ground {

    /**
     * A map of CreatureFactories to their corresponding creature's displayChar,
     * as craters should be able to spawn multiple creatures
     */

    // TODO:  refactor factories map to a single CreatureFactory class.
    //  CreatureFactory must be passed through as a parameter

    private Map<Character, CreatureFactory> factories;
    /**
     * The chance of a creature spawning
     */
    private int chance;
    /**
     * Random class
     */
    private Random rand;

    /**
     * Constructor.
     *
     * @param _displayChar character to display for this type of terrain
     * @param _chance the chance of a creature spawning
     */
    public Crater(char _displayChar, int _chance) {
        super(_displayChar);
        factories = new HashMap<Character, CreatureFactory>();
        chance = _chance;
        rand = new Random();
    }

    @Override
    public void tick(Location location) {
        Actor actor = createCreature();
        spawnCreature(location, actor, chance);
    }

    /**
     * Registers a creature factory to the crater's factories map
     * @param displayChar the displayChar of the creature to be spawned from the CreatureFactory
     * @param factory a factory for spawning creatures
     */
    public void registerCreatureFactory(Character displayChar, CreatureFactory factory) {
        factories.put(displayChar, factory);
    }

    /**
     * Creates a creature object from one of the CreatureFactories in the factories map
     * @return the created creature
     */
    public Actor createCreature() {
        int randomNumber = rand.nextInt(factories.size());
        int index = 0;
        for(Character key : factories.keySet()) {
            if(index == randomNumber) {
                return factories.get(key).createCreature();
            }
            index++;
        }
        return null;
    }

    /**
     * Spawns a creature onto the map
     * @param location location of crater
     * @param actor actor to be spawned onto the map
     * @param chance chance of creature being spawned onto the map
     */
    public void spawnCreature(Location location, Actor actor, int chance) {
        List<Exit> exits = location.getExits();
        int randomNumber = rand.nextInt(100) + 1;

        for (Exit exit : exits) {
            if(exit.getDestination().containsAnActor()) { // if exit containsAnActor, no actor is spawned
                continue;
            }

            if(randomNumber <= chance) {
                exit.getDestination().addActor(actor); // add Actor at exit destination
                break;
            }
        }
    }
}
