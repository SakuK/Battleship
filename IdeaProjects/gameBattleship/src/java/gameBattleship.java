/**
 * @author Saku Karvinen <saku.karvinen@cs.tamk.fi
 * @version 07.02.2018
 * @since 1.8
 */
import java.util.Scanner;

/**
 * Games main class.
 *
 * Extends adapter for linking purposes.
 * Holds main method that starts the game that is run in
 * void method.
 */
public class gameBattleship extends Adapter {

    static gameBattleship g = new gameBattleship();

    /**
     * Creates new gameBattleship and String array.
     *
     * String array will contain enemy shoot coordinates.
     */
    public String[] eShoots = new String[2];

    /**
     * Creating gameboards for yourself, enemy and what you see.
     *
     *
     * Seeit array will be compared to eBoard to see if you hit enemy
     */
    GameBoard myBoard = new GameBoard();
    GameBoard eBoard = new GameBoard();
    GameBoard seeIt = new GameBoard();

    /**
     * Create new print.
     */
    Print u = new Print();

    /**
     * Create 3scanners. One for String one for int.
     *
     */
    Scanner stringScan = new Scanner(System.in);
    Scanner intScan = new Scanner(System.in);

    /**
     * Setting up ships.
     *
     * Creating ships for both players.
     */
    Ship a = new Ship(5, "Aicraft Carrier", "A");
    Ship b = new Ship(4, "Battleship", "B");
    Ship c = new Ship(3, "Cruiser", "C");
    Ship d = new Ship(3, "Submarine", "S");
    Ship e = new Ship(2, "Row Boat", "R");
    Ship eA = new Ship(5, "Aircraft Carrier", "A");
    Ship eB = new Ship(4, "Battleship", "B");
    Ship eC = new Ship(3, "Cruiser", "C");
    Ship eD = new Ship(3, "Submarine", "S");
    Ship eE = new Ship(2, "Row Boat", "R");

    /**
     * Starts the game.
     *
     * Nothing else is done in main.
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
        Scanner menuSc = new Scanner(System.in);
        boolean menu = true;

        while (menu) {
            try {
                System.out.println(" Welcome to Battleshipgame");
                System.out.println("To start first. Type 1. ");
                System.out.println("To start second. Type 2");
                String selection = menuSc.nextLine();

                if (selection.equals("1")) {
                    if (selection.length() == 1) {
                        menu = false;
                        g.runGame(true);
                    }
                }

                if (selection.equals("2")) {
                    if (selection.length() == 2) ;
                    menu = false;
                    g.runGame(false);
                }
            } catch (Exception e) {
                System.out.println("Error, not valid input");
                menuSc.reset();
            }
        }
    }

    /**
     * Method that runs the actual game.'
     *
     * Boolean k set in game main menu.
     *
     * @param k is boolean who decides who starts.
     */
    void runGame(boolean k) {

        /**
         * Places ships for both players.
         *
         * Sends ship to object that places them randomly.
         */
        g.myBoard.placeShip(g.a);
        g.myBoard.placeShip(g.b);
        g.myBoard.placeShip(g.c);
        g.myBoard.placeShip(g.d);
        g.myBoard.placeShip(g.e);
        g.eBoard.placeShip(g.eA);
        g.eBoard.placeShip(g.eB);
        g.eBoard.placeShip(g.eC);
        g.eBoard.placeShip(g.eD);
        g.eBoard.placeShip(g.eE);

        /**
         * Creates booleans needed to run the game.
         *
         * gameOn will determine if game is running
         * playerturn determines if its players or computers turn
         * gameEnd determines if game has ended
         * validUserInput is used to determine if input received from scanner
         * is correct.
         * validInt same as before but for numerical input. Int sanner.
         */
        boolean gameOn = true;
        boolean playerturn = k;
        boolean gameEnd = false;
        boolean validUserInput = false;
        boolean validInt = false;

        /**
         * Creates int values needed for running the game.
         *
         * yourShipsleft determines how many ships you have left, used
         * to determine winner.
         * enemyShipsleft same as before but for enemy ships
         * int[] shot returns computers shoot mechanism values in array
         * mLife is used to determine how much life ship has left
         * convertedValue is String value given in scanner converted to int.
         * scannedValue is numerical value given in user input.
         * Used inside try catch
         * validscan is end value given in scanner.
         */
        int yourShipsleft = 5;
        int enemyShipsleft = 5;
        int[] shot;
        int mLife;
        int convertedValue = -1;
        int scannedValue;
        int validScan = -1;

        /**
         * Gives String values needed for running the game.
         *
         * input is used in scanner for storaging user given input value.
         * playerShot is the value from enemy board returned to check if
         * ship was hit
         **/
        String input;
        String playerShot;
        u.printBoard(myBoard, seeIt, eBoard, gameEnd);

        while (gameOn) {

            /**
             * While loop for enemy turn.
             */
            while (!playerturn) {
                shot = getShot();
                int x = shot[0];
                int y = shot[1];
                String s = myBoard.getValue(x, y);

                if (s.equals(" ")) {
                    myBoard.setValue(x, y, "O");
                    playerturn = true;
                } else if (s.equals("R")) {
                    mLife = g.e.getLife() - 1;
                    myBoard.setValue(x, y, "X");

                    if (mLife == 0) {
                        System.out.println("Enemy Destroyed your "
                                + g.e.getType());
                        yourShipsleft--;
                    } else {
                        g.e.setLife(mLife);
                    }

                    playerturn = true;
                } else if (s.equals("C")) {
                    mLife = g.c.getLife() - 1;
                    myBoard.setValue(x, y, "X");

                    if (mLife == 0) {
                        System.out.println("Enemy Destroyed your "
                                + g.c.getType());
                        yourShipsleft--;
                    } else {
                        g.c.setLife(mLife);
                    }

                    playerturn = true;
                } else if (s.equals("S")) {
                    mLife = g.d.getLife() - 1;
                    myBoard.setValue(x, y, "X");

                    if (mLife == 0) {
                        System.out.println("Enemy Destroyed your "
                                + g.d.getType());
                        yourShipsleft--;
                    } else {
                        g.d.setLife(mLife);
                    }

                    playerturn = true;
                } else if (s == "B") {
                    mLife = g.b.getLife() - 1;
                    myBoard.setValue(x, y, "X");

                    if (mLife == 0) {
                        System.out.println("Enemy Destroyed your "
                                + g.b.getType());
                        yourShipsleft--;
                    } else {
                        g.b.setLife(mLife);
                    }

                    playerturn = true;
                } else if (s.equals("A")) {
                    mLife = g.a.getLife() - 1;

                    if (mLife == 0) {
                        System.out.println("Enemy Destroyed your "
                                + g.a.getType());
                        yourShipsleft--;
                    } else {
                        g.a.setLife(mLife);
                    }

                    playerturn = true;
                } else {
                    playerturn = false;
                }
            }

            if (yourShipsleft == 0) {
                System.out.println("Sorry, you loose. Better luck next game!");
                gameEnd = true;
                gameOn = false;
            }

            if (gameEnd) {
                playerturn = false;
            }

            while (playerturn) {
                while (!validUserInput) {
                    try {
                        stringScan.reset();
                        System.out.println("Give horizontal value between a-j");
                        input = stringScan.next();
                        char ch = input.charAt(0);
                        int a = (int) ch - (int) 'a';

                        if (a >= 0 && a <= 9) {
                            if (input.length() == 1) {
                                validUserInput = true;
                                convertedValue = a;
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Error not valid input");
                        stringScan.reset();
                    }
                }

                while (!validInt) {
                    try {
                        intScan.reset();
                        System.out.println("Give vertical value between 1-10");
                        scannedValue = Integer.parseInt(intScan.nextLine());
                        scannedValue--;

                        if (scannedValue >= 0 && scannedValue <= 9) {

                            validScan = scannedValue;
                            validInt = true;
                        }
                    } catch (Exception e) {
                        System.out.println("Error Happened, Give values again");
                        intScan.reset();
                    }
                }

                if (validUserInput && validInt) {

                    int y = validScan;
                    int x = convertedValue;
                    playerShot = eBoard.getValue(x, y);

                    if (playerShot.equals(" ")) {
                        eBoard.setValue(x, y, "O");
                        seeIt.setValue(x, y, "O");
                        playerturn = false;
                    } else if (playerShot.equals("R")) {
                        mLife = g.eE.getLife() - 1;
                        eBoard.setValue(x, y, "X");
                        seeIt.setValue(x, y, "X");

                        if (mLife == 0) {
                            System.out.println("You sank enemy "
                                    + g.eE.getType());
                            enemyShipsleft--;
                        } else {
                            g.eE.setLife(mLife);
                        }

                        playerturn = false;
                    } else if (playerShot.equals("C")) {
                        mLife = g.eC.getLife() - 1;
                        eBoard.setValue(x, y, "X");
                        seeIt.setValue(x, y, "X");

                        if (mLife == 0) {
                            System.out.println("You sank enemy " +
                                    g.eC.getType());
                            enemyShipsleft--;
                        } else {
                            g.eC.setLife(mLife);
                        }

                        playerturn = false;
                    } else if (playerShot.equals("S")) {
                        mLife = g.eD.getLife() - 1;
                        eBoard.setValue(x, y, "X");
                        seeIt.setValue(x, y, "X");

                        if (mLife == 0) {
                            System.out.println("You sank enemy  "
                                    + g.eD.getType());
                            enemyShipsleft--;
                        } else {
                            g.eD.setLife(mLife);
                        }

                        playerturn = false;
                    } else if (playerShot == "B") {
                        mLife = g.eB.getLife() - 1;
                        eBoard.setValue(x, y, "X");
                        seeIt.setValue(x, y, "X");

                        if (mLife == 0) {
                            System.out.println("You sank enemy  "
                                    + g.eB.getType());
                            enemyShipsleft--;
                        } else {
                            g.eB.setLife(mLife);
                        }

                        playerturn = false;
                    } else if (playerShot == "A") {
                        eBoard.setValue(x, y, "X");
                        seeIt.setValue(x, y, "X");
                        mLife = g.eA.getLife() - 1;

                        if (mLife == 0) {
                            System.out.println("You sank enemy  "
                                    + g.eA.getType());
                            enemyShipsleft--;
                        } else {
                            g.eA.setLife(mLife);
                        }

                        playerturn = false;
                    } else {
                        playerturn = true;
                        System.out.println("You Already shot there");
                    }

                    validInt = false;
                    validUserInput = false;
                    break;
                }
            }

            /**
             * Checks if all enemy ships area dead. .
             *
             * If yes displays "you win" and game ends
             * Then prints board.
             */
            if (enemyShipsleft == 0) {
                System.out.println("YOU WIN!!!");
                gameEnd = true;
            }

            u.printBoard(g.myBoard, g.seeIt, g.eBoard, gameEnd);

            if (gameEnd) {
                gameOn = false;
            }
        }
    }
}
