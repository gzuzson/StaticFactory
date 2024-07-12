package game.factories;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.HuntsmanSpider;
/**
 * <h1>HuntsmanSpiderFactory Class</h1>
 * The HuntsmanSpiderFactory class is an implementation of a CreatureFactory
 * which provides a way to create new HuntsmanSpider actors
 *
 * @author Jeremiah Saemo
 */
public class HuntsmanSpiderFactory implements CreatureFactory {
    @Override
    public Actor createCreature() {
        return new HuntsmanSpider();
    }
}