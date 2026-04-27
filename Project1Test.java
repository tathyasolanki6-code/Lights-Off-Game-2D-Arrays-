import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit tests for Project1 (LightsOff implementation).
 * These tests are designed to maximize coverage
 * and exercise all branches of the code.
 */
public class Project1Test {

    /* =====================================================
     * CONSTRUCTOR TESTS
     * ===================================================== */

    @Test
    public void testDefaultConstructor() {
        Project1 game = new Project1();
        assertTrue(game.size() > 0);
        assertEquals(0, game.numMoves());
    }

    @Test
    public void testBoardIndexConstructorValid() {
        Project1 game = new Project1(0);
        assertTrue(game.size() > 0);
    }

    @Test
    public void testBoardIndexConstructorInvalid() {
        Project1 game = new Project1(-5);
        assertTrue(game.size() > 0);
    }

    @Test
    public void testStringConstructor() {
        String board = "o x | x o |";
        Project1 game = new Project1(board);
        assertEquals(2, game.size());
    }

    /* =====================================================
     * INITIALIZATION TESTS
     * ===================================================== */

    @Test
    public void testInitializeInvalidIndex() {
        Project1 game = new Project1();
        game.initialize(999);
        assertTrue(game.size() > 0);
    }

    @Test
    public void testInitializeString() {
        Project1 game = new Project1();
        game.initialize("o o | x x |");
        assertEquals(2, game.size());
        assertTrue(game.isLightOn(0, 0));
        assertFalse(game.isLightOn(1, 0));
    }

    /* =====================================================
     * VALIDATION & ACCESSOR TESTS
     * ===================================================== */

    @Test
    public void testValidPositionTrue() {
        Project1 game = new Project1("o |");
        assertTrue(game.validPosition(0, 0));
    }

    @Test
    public void testValidPositionFalse() {
        Project1 game = new Project1("o |");
        assertFalse(game.validPosition(-1, 0));
        assertFalse(game.validPosition(0, 5));
    }

    @Test
    public void testIsLightOnInvalidPosition() {
        Project1 game = new Project1("o |");
        assertFalse(game.isLightOn(5, 5));
    }

    /* =====================================================
     * GAME PLAY TESTS
     * ===================================================== */

    @Test
    public void testPlayInvalidPosition() {
        Project1 game = new Project1("o |");
        game.play(5, 5);
        assertEquals(0, game.numMoves());
    }

    @Test
    public void testPlayNormalMove() {
        Project1 game = new Project1("o |");
        game.play(0, 0);
        assertEquals(1, game.numMoves());
    }

    @Test
    public void testPlayButtonNumber() {
        Project1 game = new Project1("o x | x o |");
        game.play(0);
        assertEquals(1, game.numMoves());
    }

    @Test
    public void testGameOverAndWinIncrement() {
        Project1 game = new Project1("o |");
        assertFalse(game.isGameOver());

        game.play(0, 0);

        assertTrue(game.isGameOver());
        assertEquals(1, game.numWins());
    }

    @Test
    public void testPlayAfterGameOver() {
        Project1 game = new Project1("o |");
        game.play(0, 0);
        game.play(0, 0);

        assertEquals(1, game.numMoves());
        assertEquals(1, game.numWins());
    }

    /* =====================================================
     * TOSTRING TEST
     * ===================================================== */

    @Test
    public void testToStringExecution() {
        Project1 game = new Project1("o x | x o |");
        String output = game.toString();

        assertNotNull(output);
        assertTrue(output.contains("|"));
    }
}
