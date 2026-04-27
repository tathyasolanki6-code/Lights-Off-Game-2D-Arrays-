import itsc2214.LightsOff;
import java.util.Random;

/**
 * Implements the Lights Off game logic.
 *
 * Board representation:
 * true = light ON
 * false = light OFF
 */
public class Project1 implements LightsOff {

    /** Character representing a light that is on. */
    private static final String ON = "o";

    /** Character representing a light that is off. */
    private static final String OFF = "x";

    /** Row separator character. */
    private static final char ROW_SEPARATOR = '|';

    /** Random generator for board selection. */
    private static final Random RAND = new Random();

    /** Game board (true = on, false = off). */
    private boolean[][] board;

    /** Size of the square board. */
    private int size;

    /** Number of moves in the current game. */
    private int numMoves;

    /** Total number of games won. */
    private int numWins;

    /*
     * =========================================================
     * CONSTRUCTORS
     * =========================================================
     */

    /** Creates a new game using a random predefined board. */
    public Project1() {
        numWins = 0;
        initialize();
    }

    /** Creates a new game using a specific predefined board. */
    public Project1(int boardIndex) {
        numWins = 0;
        initialize(boardIndex);
    }

    /** Creates a new game using a string-based board layout. */
    public Project1(String boardStr) {
        numWins = 0;
        initialize(boardStr);
    }

    /*
     * =========================================================
     * ACCESSORS
     * =========================================================
     */

    @Override
    public int numWins() {
        return numWins;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int numMoves() {
        return numMoves;
    }

    @Override
    public boolean validPosition(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    @Override
    public boolean isLightOn(int row, int col) {
        return validPosition(row, col) && board[row][col];
    }

    @Override
    public boolean isGameOver() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (board[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }

    /*
     * =========================================================
     * INITIALIZATION
     * =========================================================
     */

    @Override
    public void initialize() {
        initialize(RAND.nextInt(LightsOff.boards.length));
    }

    @Override
    public void initialize(int boardIndex) {
        int index = boardIndex;

        if (index < 0 || index >= LightsOff.boards.length) {
            index = 0;
        }

        initialize(LightsOff.boards[index]);
    }

    @Override
    public void initialize(String boardStr) {
        numMoves = 0;
        size = countRows(boardStr);
        board = new boolean[size][size];

        int row = 0;
        int col = 0;

        for (String token : boardStr.split("\\s+")) {
            if (token.charAt(0) == ROW_SEPARATOR) {
                row++;
                col = 0;
            } else {
                board[row][col] = token.equals(ON);
                col++;
            }
        }
    }

    private int countRows(String boardStr) {
        int rows = 0;

        for (int i = 0; i < boardStr.length(); i++) {
            if (boardStr.charAt(i) == ROW_SEPARATOR) {
                rows++;
            }
        }
        return rows;
    }

    /*
     * =========================================================
     * GAME PLAY
     * =========================================================
     */

    @Override
    public void play(int row, int col) {
        if (isGameOver() || !validPosition(row, col)) {
            return;
        }

        toggle(row, col);
        toggle(row - 1, col);
        toggle(row + 1, col);
        toggle(row, col - 1);
        toggle(row, col + 1);

        numMoves++;

        if (isGameOver()) {
            numWins++;
        }
    }

    @Override
    public void play(int buttonNumber) {
        play(buttonNumber / size, buttonNumber % size);
    }

    private void toggle(int row, int col) {
        if (validPosition(row, col)) {
            board[row][col] = !board[row][col];
        }
    }

    /*
     * =========================================================
     * STRING REPRESENTATION
     * =========================================================
     */

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                builder.append(board[r][c] ? ON : OFF).append(' ');
            }
            builder.append(ROW_SEPARATOR).append('\n');
        }

        return builder.toString();
    }
}
