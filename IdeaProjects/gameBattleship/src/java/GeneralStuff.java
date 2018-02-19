/**
 * Class made for holding random generators.
 *
 * Creates random boolean and random int from given numbers.
 *
 * @author Saku Karvinen <saku.karvinen@cs.tamk.fi
 * @version 07.02.2018
 * @since 1.8
 *
 */
public class GeneralStuff {

    /**
     * Does method random.
     *
     * Returns random value between given whole numbers.
     * Will be used in many tasks like setting ships.
     *
     * @param min is minimum value for random.
     * @param max is max value for random.
     * @return result random int
     */
    public static int random(int min, int max) {
        int result = (int) (Math.random() * (max - min) + min);
        return result;
    }

    /**
     * Creates random boolean for the use of Ai shooting.
     *
     * @return randomboolean.
     */
    public static boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }
}
