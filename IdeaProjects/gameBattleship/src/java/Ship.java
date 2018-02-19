/**
 * Class for ship objects.
 *
 * @author Saku Karvinen <saku.karvinen@cs.tamk.fi
 * @version 07.02.2018
 * @since 1.8
 */
public class Ship {

    /**
     * Sets parameters for ship class.
     */
    int lenght;
    String type;
    String callsign;
    int life;

    /**
     * Is constructor for ship class.
     *
     * Defines parameters for object Ship.
     *
     * @param lenght of ship given in other method
     * @param name of ship given in another method.
     * @param callsign of the ship. used to show ship on gameboard.
     */
    public Ship(int lenght, String name, String callsign) {
        this.lenght = lenght;
        this.type = name;
        this.callsign = callsign;
        this.life = lenght;
    }

    /**
     * Acts as getter for Ship length.
     *
     * Will be used to get ship length value.
     *
     * @return Returns ships length.
     */
    public int getLength() {
        return lenght;
    }

    /**
     * Acts as getter for getting the ships number.
     *
     * Used in displaying ships on board.
     *
     * @return Ships number.
     */
    public String getCallsign() {
        return callsign;
    }

    /**
     * Acts as Getter for ship hp.
     *
     * Hp will be used to determine if ship has been destroyed.
     *
     * @return Ships current hp.
     */
    public int getLife() {
        return life;
    }

    /**
     * Acts as setter for ship hp.
     *
     * Hp will be used to determine if ship
     * has been destroyed.
     *
     * @param hp given ship hp
     */
    public void setLife(int hp) {
        this.life = hp;
    }

    /**
     * Acts as getter method for shiptype.
     *
     * Used to give feedback on what ship you destroyed.
     *
     * @return shiptype
     */
    public String getType() {
        return type;
    }
}
