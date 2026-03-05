import org.junit.*;
import static org.junit.Assert.*;

/**
 * Reference test for Project 1 (LightsOff).
 */
public class Project1Test {

    private Project1 runner;

    @Before
    public void setup() {
        runner = new Project1();
    }

    @Test
    public void testOne() {
        String aGame = "x o x | o o o | x o x |";
        runner.initialize(aGame);

        // What is the size of the board?
        assertEquals(3, runner.size());

        // How many moves have been made at this point?
        assertEquals(0, runner.numMoves());

        // How many games have been won?
        assertEquals(0, runner.numWins());

        // Is the light on at position 0,0, or at position 0,1, etc.
        // next three lines check the top row
        assertFalse(runner.isLightOn(0, 0));
        assertTrue(runner.isLightOn(0, 1));
        assertFalse(runner.isLightOn(0, 2));
    }

    @Test
    public void testOneMoveWin() {
        String aGame = "x o x | o o o | x o x |";
        runner.initialize(aGame);

        // press the button in the center of the grid
        runner.play(4);
        // add asserts here to ensure that your game is working correctly
        assertTrue(runner.isGameOver());
        assertEquals(1, runner.numMoves());
        assertEquals(1, runner.numWins());
        // etc
    }
}
