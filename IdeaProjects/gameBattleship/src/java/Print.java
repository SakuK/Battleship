/**
 * Class print will print out gameBoards after every action.
 *
 * Gameboards are sent to here from main game method.
 *
 * @author Saku Karvinen <saku.karvinen@cs.tamk.fi
 * @version 07.02.2018
 * @since 1.8
 */
public class Print {

    /**
     * Does Print method in the print class. Prints out the gameBoards.
     *
     * Uses boolean to determine if the game has ended.
     * If ended. Prints out enemy board instead of seeIt board.
     *
     * @param mBoard Your own gameBoard, will be printed every round.
     * @param seeIt seeIt is gameboard that will be printed
     *              for you while the game lasts, compared to eBoard
     * @param eBoard Enemy board, will not be printed unless game has ended.
     * @param gameEnd boolean that defines if the game has ended,
     *                used to determine what boards will be printed.
     */
    public void printBoard(GameBoard mBoard, GameBoard seeIt,
                           GameBoard eBoard, boolean gameEnd) {
        char ch = 'A';

        if (gameEnd) {
            seeIt = eBoard;
        }

        for (int i = 0; i < 7; ) {
            System.out.print(" ");
            i++;
        }

        System.out.print("Your Board");

        for (int i = 0; i < 18; ) {
            System.out.print(" ");
            i++;
        }

        System.out.println("Enemy Board");
        System.out.print("   1 2 3 4 5 6 7 8 9 10");

        for (int i = 0; i < 8; i++) {
            System.out.print(" ");
        }

        System.out.println("1 2 3 4 5 6 7 8 9 10");
        System.out.print("  +");

        for (int i = 0; i < 20; ) {
            System.out.print("-");
            i++;
        }

        for (int i = 0; i < 7; ) {
            System.out.print(" ");
            i++;
        }

        System.out.print("+");

        for (int i = 0; i < 20; ) {
            System.out.print("-");
            i++;
        }

        int pysty = 0;
        System.out.println("");

        for (int j = 0; j < 10; ) {
            System.out.print(ch + " ");
            System.out.print("|");

            for (int rivi = 0; rivi <= 9; ) {
                System.out.print(mBoard.getValue(pysty, rivi));
                System.out.print("|");
                rivi++;
            }

            for (int i = 0; i < 5; ) {
                System.out.print(" ");
                i++;
            }

            System.out.print(ch + " ");
            System.out.print("|");

            for (int rivi = 0; rivi <= 9; ) {
                System.out.print(seeIt.getValue(pysty, rivi));
                System.out.print("|");
                rivi++;
            }

            System.out.println("");
            System.out.print("  ");

            for (int i = 0; i < 21; ) {
                System.out.print("-");
                i++;
            }

            for (int i = 0; i < 7; ) {
                System.out.print(" ");
                i++;
            }

            for (int i = 0; i < 21; ) {
                System.out.print("-");
                i++;
            }

            System.out.println();
            ch++;
            pysty++;
            j++;
        }
    }
}
