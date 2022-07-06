import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {
    private static final Logger logger = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {

        int alpha = 5;
        int beta = 20;
        int gamma = 20;
        int delta = 0;
        int gameResult;
        int menaceWins = 0;
        int humanWins = 0;
        int draws = 0;
        int NUMBER_OF_TRAINS = 10000;
        float probability = 0.8f;
//        List<Integer> m = new ArrayList<>();
//        List<Integer> h = new ArrayList<>();
//        List<Integer> d = new ArrayList<>();
        MenaceStrategy menaceStrategy = new MenaceStrategy(alpha);
        HumanStrategy humanStrategy = new HumanStrategy();
        logger.info("Train Start");
        for (int i = 0; i<NUMBER_OF_TRAINS; i++) {
            Game game = new Game(menaceStrategy, humanStrategy,probability);
            gameResult = game.run();
//            game.peekCurrentState();
            if (gameResult==0) {
//                d.add(i);
                draws++;
            } else if (gameResult==1) {
//                m.add(i);
                menaceWins++;
            } else  {
//                h.add(i);
                humanWins++;
            }
            menaceStrategy.updateBeads(gameResult, beta, gamma, delta);
            logger.info("Menacewins: "+menaceWins+" || Humanwins: "+humanWins+" || Draws: "+draws+"||alpha: "+Integer.toString(alpha)+"||beta: "+Integer.toString(beta)+"||gamma: "+Integer.toString(gamma)+"||delta: "+Integer.toString(delta)+"||p*: "+Float.toString(probability));
        }
        logger.info("Train End");
//        logger.info(Arrays.toString(m.toArray()));
//        logger.info(Arrays.toString(h.toArray()));
//        logger.info(Arrays.toString(d.toArray()));

//        System.out.println(Arrays.toString(m.toArray()));
//        System.out.println(Arrays.toString(h.toArray()));
//        System.out.println(Arrays.toString(d.toArray()));
//        System.out.println("Menacewins: "+menaceWins+" || Humanwins: "+humanWins+" || Draws: "+draws);
        menaceWins = 0;
        humanWins = 0;
        draws = 0;
        probability = 0.9f;
        logger.info("Run Start");
        for (int i = 0; i<10000; i++) {
            Game game = new Game(menaceStrategy, humanStrategy,probability);
            gameResult = game.run();
//            game.peekCurrentState();
            if (gameResult==0) {
//                d.add(i);
                draws++;
            } else if (gameResult==1) {
//                m.add(i);
                menaceWins++;
            } else  {
//                h.add(i);
                humanWins++;
            }
            game.peekCurrentState();
            logger.info("Menacewins: "+menaceWins+" || Humanwins: "+humanWins+" || Draws: "+draws+"||alpha: "+Integer.toString(alpha)+"||beta: "+Integer.toString(beta)+"||gamma: "+Integer.toString(gamma)+"||delta: "+Integer.toString(delta)+"||p*: "+Float.toString(probability));
        }

//        logger.info(Arrays.toString(m.toArray()));
//        logger.info(Arrays.toString(h.toArray()));
//        logger.info(Arrays.toString(d.toArray()));
        logger.info("Run End");
        System.out.println("completed");

    }

}


