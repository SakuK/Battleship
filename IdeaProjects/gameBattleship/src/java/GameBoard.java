/**
 * Class that holds all gameBoard objects.
 *
 * In the current game holds 3 different gameBoards.
 * @author Saku Karvinen <saku.karvinen@cs.tamk.fi
 * @version 07.02.2018
 * @since 1.8
 */
public class GameBoard extends GeneralStuff {
    final static int boardSize = 10;
    int validY;
    int validX;
    int min = 0;
    int max = 9;
    int counter;
    boolean endOne;
    boolean isvalid;
    String[][] bBoard;

    /**
     * Is constructor for gameboard object.
     *
     * Creates new gameBoard when asked.
     */
    public GameBoard() {
        bBoard = new String[boardSize][boardSize];

        for (int i = 0; i < bBoard.length; i++) {
            for (int k = 0; k < bBoard[i].length; k++) {
                bBoard[i][k] = " ";
            }
        }
    }

    /**
     * Acts as setter for board values.
     *
     * Will be used comparing seeIt and eBoard gameboards.
     *
     * @param x coordinate of given value
     * @param y coordinate of given value
     * @param u value you want to insert to gameboard.
     */
    public void setValue(int x, int y, String u) {
        bBoard[x][y] = u;
    }

    /**
     * Acts as a getter for gameboard values.
     *
     * @param x coordinate of wanted value.
     * @param y coordinate of wanted value
     * @return the wanted value
     */
    public String getValue(int x, int y) {
        return bBoard[x][y];
    }

    /**
     * Places ships one by one.
     *
     * Creates random coordinates where ship will be placed.
     * Creates random boolean to check if ship will be
     * placed vertically or horizontally. Checks if the ship fits the array,
     * if not, creates new values.
     * After this is done it places the ship on the array on the given spot.
     *
     * @param k is the ship sent to method.
     */
    public void placeShip(Ship k) {
        isvalid = false;
        boolean placeShip = false;
        counter = k.getLength();
        int reset = counter;
        int savedK = k.getLength();
        int u = bBoard.length;

        while (!isvalid) {
            int x = random(min, max);
            int y = random(min, max);
            int savedX = x;
            int savedY = y;
            boolean directionUP = getRandomBoolean();

            if (directionUP) {
                int f = y + savedK;

                if (f <= u) {
                    int t = 0;

                    for (int i = 0; i < counter; i++) {
                        if (getValue(x, y).equals(" ")) {
                            y++;
                            t++;

                            if (counter == t) {
                                isvalid = true;
                                validX = savedX;
                                validY = savedY;
                                endOne = true;
                                break;
                            }
                        }
                    }
                }
            }

            if (!directionUP) {
                int f = x + savedK;

                if (f <= u) {
                    int t = 0;

                    for (int i = 0; i < counter; i++) {
                        if (getValue(x, y).equals(" ")) {
                            x++;
                            t++;

                            if (counter == t) {
                                isvalid = true;
                                validX = savedX;
                                validY = savedY;
                                endOne = false;
                                break;
                            }
                        }
                    }
                }
            }

            counter = reset;
        }

        if (isvalid) {
            String shipL = k.getCallsign();
            setValue(validX, validY, shipL);
            placeShip = true;
            int midValue = k.getLength() - 1;

            while (midValue > 0) {
                if (endOne) {
                    validY++;
                    setValue(validX, validY, shipL);
                } else if (!endOne) {
                    validX++;
                    setValue(validX, validY, shipL);
                }

                midValue--;
            }
        }
    }
}
