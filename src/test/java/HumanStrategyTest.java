import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HumanStrategyTest {







    @Test
    public void testWin() {
        // H-X
        HumanStrategy h = new HumanStrategy();
        String str = "121020000";
        assertEquals(7, h.nextOptimalStep(str, "2",1f));
    }

    @Test
    public void testBlock() {
        // H-O
        HumanStrategy h = new HumanStrategy();
        String str = "201010000";
        assertEquals(6, h.nextOptimalStep(str, "2",1f));
    }

    @Test
    public void testFork() {
        HumanStrategy h = new HumanStrategy();
        String str = "012110002";
        assertEquals(5, h.nextOptimalStep(str, "2",1f));
    }

    @Test
    public void testBlockFork() {
        HumanStrategy h = new HumanStrategy();
        String str = "101020120";
        assertEquals(1, h.nextOptimalStep(str,"2",1f));
    }

    @Test
    public void testCenter() {
        HumanStrategy h = new HumanStrategy();
        String str = "100000000";
        assertEquals(4, h.nextOptimalStep(str, "2",1f));
    }

    @Test
    public void testOppositeCorner() {
        HumanStrategy h = new HumanStrategy();
        String str = "000000001";
        assertEquals(4, h.nextOptimalStep(str, "2",1f));
    }

    @Test
    public void testEmptyCorner() {
        HumanStrategy h = new HumanStrategy();
        String str = "001010002";
        assertEquals(6, h.nextOptimalStep(str, "2",1f));
    }

    @Test
    public void testEmptySide() {
        HumanStrategy h = new HumanStrategy();
        String str = "102000100";
        assertEquals(3, h.nextOptimalStep(str, "2",1f));
    }

    @Test
    public void testNextOptimalStepRandom() {
        HumanStrategy h = new HumanStrategy();
        String s = "112220100";
        assertEquals(5, h.nextOptimalStep(s,"2",1f));
        s = "112210200";
        assertEquals(7, h.nextOptimalStep(s,"2",1f));
        s = "020211000";
        assertEquals(0, h.nextOptimalStep(s,"2",1f));
        s = "020021010";
        assertEquals(0, h.nextOptimalStep(s,"2",1f));
        s = "200120001";
        assertEquals(1, h.nextOptimalStep(s,"2",1f));
        s = "020112000";
        assertEquals(2, h.nextOptimalStep(s,"2",1f));
        s = "010122000";
        assertEquals(2, h.nextOptimalStep(s,"2",1f));
        s = "210020001";
        assertEquals(3, h.nextOptimalStep(s,"2",1f));
        s = "212100000";
        assertEquals(4, h.nextOptimalStep(s,"2",1f));

        s = "001120200";
        assertEquals(7, h.nextOptimalStep(s,"2",1f));
        s = "000112020";
        assertEquals(8, h.nextOptimalStep(s,"2",1f));
        s = "201100200";
        assertEquals(8, h.nextOptimalStep(s,"2",1f));
        s = "010020120";
        assertEquals(0, h.nextOptimalStep(s,"2",1f));
        s = "010000221";
        assertEquals(0, h.nextOptimalStep(s,"2",1f));

        s = "210100000";
        assertEquals(4, h.nextOptimalStep(s,"2",1f));
        s = "121000000";
        assertEquals(4, h.nextOptimalStep(s,"2",1f));
        s = "021010200";
        assertEquals(5, h.nextOptimalStep(s,"2",1f));
        s = "000120010";
        assertEquals(6, h.nextOptimalStep(s,"2",1f));
        s = "021000010";
        assertEquals(6, h.nextOptimalStep(s,"2",1f));
        s = "002210100";
        assertEquals(7, h.nextOptimalStep(s,"2",1f));
        s = "000021010";
        assertEquals(8, h.nextOptimalStep(s,"2",1f));
        s = "120200010";
        assertEquals(8, h.nextOptimalStep(s,"2",1f));
        s = "000000000";
        assertEquals(4, h.nextOptimalStep(s,"2",1f));
        s = "100020000";
        assertEquals(8, h.nextOptimalStep(s,"2",1f));

        s = "000010000";
        assertEquals(0, h.nextOptimalStep(s,"2",1f));
        s = "121120212";
        assertEquals(5, h.nextOptimalStep(s,"2",1f));
        s = "121121212";
        assertEquals(-1, h.nextOptimalStep(s,"2",1f));
    }
}
