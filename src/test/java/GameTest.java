import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void testConvert2dBoardto1dString() {
        HumanStrategy h = new HumanStrategy();
        MenaceStrategy m = new MenaceStrategy(3);
        Game r = new Game(m, h, 1f);
        int[][] b = {{0, 1, 2}, {2, 1, 1}, {2, 1, 2}};
        String s = "012211212";
        assertEquals(s, r.convert2dboardToString(b));
    }



    @Test
    public void testCheckwin() {
        HumanStrategy h = new HumanStrategy();
        MenaceStrategy m = new MenaceStrategy(5);
        Game r = new Game(m, h, 1f);
        assertEquals(Game.checkwin(r.board,-1, 2), 0);

        assertEquals(2, Game.checkwin(h.convert1dstringTo2darray("210120002"),8, 2));

        assertEquals(0, Game.checkwin(h.convert1dstringTo2darray("222110100"),6, 2));

        assertEquals(0, Game.checkwin(h.convert1dstringTo2darray("100100022"),6, 1));
    }
}

