package game;

/**
 * <h1>Ability enum</h1>
 * The Ability class is an enumeration class that outlines various abilities that an Actor may perform.
 * Example #1: if the player is capable jumping over walls, you can attach Ability.WALL_JUMP to the player class
 *
 * @author Jeremiah Saemo
 */
public enum Ability {
    /**
     * Provides capability of allowing actors to pickup Scrap items
     */
    CAN_PICKUP_SCRAP,
    /**
     * Provides capability of allowing actors to enter doors
     */
    ENTER_DOOR;
}
