package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.HuntsmanSpider;
import game.factories.HuntsmanSpiderFactory;
import game.actors.Player;
import game.grounds.*;
import game.items.*;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Jeremiah Saemo
 *
 */
public class Application {

    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(),
                new Wall(), new Floor(), new Puddle(), new Door());

        List<String> map = Arrays.asList(
                        "...~~~~.........~~~...........",
                        "...~~~~.......................",
                        "...~~~........................",
                        "..............................",
                        ".............#####............",
                        ".............#___#...........~",
                        ".............#___#..........~~",
                        ".............##|##.........~~~",
                        ".................~~........~~~",
                        "................~~~~.......~~~",
                        ".............~~~~~~~........~~",
                        "......~.....~~~~~~~~.........~",
                        ".....~~~...~~~~~~~~~..........",
                        ".....~~~~~~~~~~~~~~~~........~",
                        ".....~~~~~~~~~~~~~~~~~~~....~~");

        GameMap gameMap = new GameMap(groundFactory, map);
        world.addGameMap(gameMap);

        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        Player player = new Player("Intern", '@', 4);
        world.addPlayer(player, gameMap.at(15, 6));

        LargeBolt largeBolt = new LargeBolt();
        MetalSheet metalSheet = new MetalSheet();
        gameMap.at(15, 8).addItem(largeBolt);
        gameMap.at(14, 8).addItem(metalSheet);

        Plant inheritree = new Inheritree();
        gameMap.at(9, 3).setGround(inheritree);

        HuntsmanSpider huntsmanSpider = new HuntsmanSpider();
        Crater crater = new Crater('u', 5);
        crater.registerCreatureFactory(huntsmanSpider.getDisplayChar(), new HuntsmanSpiderFactory());
        gameMap.at(9, 8).setGround(crater);

        MetalPipe metalPipe = new MetalPipe();
        gameMap.at(13, 8).addItem(metalPipe);

        world.run();
    }
}
