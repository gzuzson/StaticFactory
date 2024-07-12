package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;

/**
 * <h1>MetalPipe class</h1>
 * The MetalPipe class is a SpecialScrap and WeaponItem that can be
 * picked up just as any Item and provide its owner the ability to deal
 * 1 damage at a hitrate of 20 per cent accuracy.
 *
 * @author Jeremiah Saemo
 */
public class MetalPipe extends WeaponItem implements SpecialScrap {

    /**
     * Constructor for the MetalPipe class
     */
    public MetalPipe() {
        super("Metal Pipe", '!', 1, "strikes", 20);
    }

    /**
     * MetalPipe provides AttackAction to its owner to attack other Actors
     * @param otherActor the other actor being attacked
     * @param location the location of the other actor to attack in
     * @return actions list with new AttackAction
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = super.allowableActions(otherActor, location);
        actions.add(new AttackAction(otherActor, location.toString(), this));
        return actions;
    }
}
