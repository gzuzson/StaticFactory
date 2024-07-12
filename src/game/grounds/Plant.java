package game.grounds;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.factories.LargeFruitFactory;
import game.factories.SmallFruitFactory;

import java.util.List;
import java.util.Random;

import static java.lang.Character.*;

/**
 * <h1>Plant Class</h1>
 * The Plant class is a concrete class responsible for the behaviours of bearing
 * SmallFruit items, and bearing LargeFruit items once the plant has grown past a certain age
 *
 * @author Jeremiah Saemo
 */
public class Plant extends Ground {

    /**
     * The name of the plant
     */
    private String name;

    /**
     * How old the plant is
     */
    private int age;
    /**
     * Generates SmallFruit objects
     */
    private final SmallFruitFactory smallFruitFactory;
    /**
     * Generates LargeFruit objects
     */
    private final LargeFruitFactory largeFruitFactory;
    /**
     * A random number used for generating fruit items
     */
    private Random rand = new Random();

    /**
     * Constructor for the Plant class
     * @param name the name of the plant
     * @param displayChar character to display for this type of terrain
     */
    public Plant(String name, char displayChar) {
        super(displayChar);
        age = 0;
        smallFruitFactory = new SmallFruitFactory();
        largeFruitFactory = new LargeFruitFactory();
    }

    @Override
    public void tick(Location location) {
        age++; // increment age for every tick
        if(age >= 5) {
            setDisplayChar(toUpperCase(getDisplayChar())); // set Plant displayChar to uppercase
            bearFruit(location, largeFruitFactory.createFruit(), 20);
        } else {
            bearFruit(location, smallFruitFactory.createFruit(), 30); // drop fruit at 30% chance within plant's surroundings (exits)
        }
    }

    /**
     * Bears fruit at random exit location of the Plant object
     * @param location the location of the Plant object
     * @param item the Item to be placed at the exit points, being a SmallFruit or a LargeFruit
     * @param chance the chance that the Item is borne at one of the Plant's exits
     */
    private void bearFruit(Location location, Item item, int chance) {
        List<Exit> exits = location.getExits();
        Exit randomExit = exits.get(rand.nextInt(exits.size())); // get random exit from exits of Plant
        int randomNumber = rand.nextInt(100) + 1;

        if(randomNumber <= chance) {
            randomExit.getDestination().addItem(item); // add Item at exit destination
        }
    }
}