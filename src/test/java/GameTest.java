import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    public void testWhenSecondPlayerWin() {
        Player p1 = new Player(2233, "Shum", 15);
        Player p2 = new Player(3344, "Morera", 8);
        Game game = new Game();

        game.register(p1);
        game.register(p2);
        int actual = game.round("Morera", "Shum");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerWin() {
        Player p1 = new Player(2233, "Shum", 15);
        Player p2 = new Player(3344, "Morera", 25);
        Game game = new Game();

        game.register(p1);
        game.register(p2);
        int actual = game.round("Morera", "Shum");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenStrengthsEqual() {
        Player p1 = new Player(2233, "Shum", 20);
        Player p2 = new Player(3344, "Morera", 20);
        Game game = new Game();

        game.register(p1);
        game.register(p2);
        int actual = game.round("Morera", "Shum");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Player p1 = new Player(2233, "Shum", 20);
        Game game = new Game();

        game.register(p1);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Garda", "Shum"));
    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Player p1 = new Player(2233, "Morera", 20);
        Game game = new Game();

        game.register(p1);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Morera", "Garda"));
    }
}