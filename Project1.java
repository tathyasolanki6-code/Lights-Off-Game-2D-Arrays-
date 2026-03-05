import itsc2214.LightsOff;
import java.util.Scanner;

public class Project1 implements LightsOff {

    // Define 3 constructors

    /**
     * Returns the number of wins so far.
     * 
     * @return number of wins
     */
    public int numWins() {
        return 0;
    }

    /**
     * Returns the size of the board. The board is always
     * a square of size.
     * 
     * @return size of the board
     */
    public int size() {
        return 0;
    }

    /**
     * Initialized the game using one of the boards
     * defined in the LightsOff interface. Select
     * a random number between 0 and boards.length
     * and call initialize(boards[index selected])
     */
    public void initialize() {
        int idx = 0; // generate a random int
        initialize(boards[idx]);
    }

    /**
     * Initialize the game based on the index of one
     * of the boards in the LightsOff interface.
     * This method can in effect simply redirect the
     * call to <code>initialize(boards[boardIndex])</code>.
     * If the index is not valid, it should use 0.
     * 
     * @param boardIndex a value between 0 and <code>boards.length</code>
     */
    public void initialize(int boardIndex) {
        initialize(boards[boardIndex]);
    }

    /**
     * Initialize a board using a string representation of a
     * game board. The format of the string is defined in the
     * project specifications. You must use a scanner to parse
     * the line. The size of the board will be the number of "|"
     * characters in the boardStr. This routine also should
     * initialize number of moves to 0.
     */
    public void initialize(String boardStr) {
        // First, count number of lines in the board by counting
        // number of | in the string and store it size.

        // Then allocate a boolean 2d array of the appropriate size
        // and initialize numMoves to 0

        // Now, parse the boardStr using a scanner and
        // store the appropriate true/false in each position
        // in the array.

        Scanner tokenScanner = new Scanner(boardStr);
        while (tokenScanner.hasNext()) {
            String token = tokenScanner.next();
            if (token.equals("x")) {
                // it is an x, do something
            } else if (token.equals("o")) {
                // it is an o, do something
            } else if (token.equals("|")) {
                // it is the end of the line, do something
            }
        }
        tokenScanner.close();
    }

    /**
     * Returns true if [row][col] is a valid position
     * in the board. That is both row and col need to
     * be between 0 (inclusive) and size.
     * 
     * @param row index for the row
     * @param col index for the column
     * @return true if [row][col] is valid, false otherwise.
     */
    public boolean validPosition(int row, int col) {
        return false;
    }

    /**
     * Play (toggle the light) at [row][col], also
     * toggling the four adjacent positions.
     * If this is called when the game is over, then do nothing.
     * If row or col is off the board, do nothing.
     * If a play is made, increment the count of number of moves.
     * If after the play, the game is over, then increment numWins.
     * 
     * @param row index for the row
     * @param col index for the column
     */
    public void play(int row, int col) {

    }

    /**
     * Play (toggle the light) by button id. play(0)
     * should result in a call to play(0,0), and play(8)
     * in a 3x3 game, should result in a call to play(2,2).
     * 
     * @param buttonNumber number of the button
     */
    public void play(int buttonNumber) {

    }

    /**
     * Returns the number of moves made in this game so far.
     * 
     * @return number of moves made
     */
    public int numMoves() {
        return 0;
    }

    /**
     * Returns true if a light at [row][col] is on. It must
     * check if [row][col] is a valid position and if it is not,
     * then return false.
     * 
     * @return returns true if a light at [row][col] is on, false otherwise.
     */
    public boolean isLightOn(int row, int col) {
        return true;
    }

    /**
     * Returns true if the full board is off, all lights are off.
     * 
     * @return true if no lights are one, false otherwise
     */
    public boolean isGameOver() {
        return false;
    }

    /**
     * Returns a string of the board in a format that matches
     * the format processed by initialized(String).
     * 
     * @return string representation of the board.
     */
    public String toString() {
        return "a string";
    }
}