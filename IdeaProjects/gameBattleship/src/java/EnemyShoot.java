/**
 * Class that does shoothing for the ai.
 *
 * Extends GeneralStuff to get random generators
 * from there.
 *
 * @author Saku Karvinen <saku.karvinen@cs.tamk.fi
 * @version 07.02.2018
 * @since 1.8
 */
public class EnemyShoot extends GeneralStuff {

    /**
     * Sets values used in method.
     */
    int[] eShoot = new int[2];
    int min = 0;
    int max = 9;

    /**
     * Does shooting for the ai.
     *
     * Completely random shooting
     *
     * @return array with coordinates where shot.
     */
    public int[] getShot() {
        eShoot[0] = random(min, max);
        eShoot[1] = random(min, max);
        return eShoot;
    }
}
