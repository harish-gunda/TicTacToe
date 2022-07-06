import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MenaceStrategyTest {


    @Test
    public void testNextOptimalStep() {
        List<Integer> beadsList1 = Arrays.asList(0, 0,0);
        List<Integer> beadsList2 = Arrays.asList(0,0);
        List<Integer> beadsList3 = Arrays.asList(0);
        MenaceStrategy m = new MenaceStrategy(4);
        String board = "012212121";
        m.nextOptimalStep(board);
        assertEquals(m.beads.get(board), beadsList1);
        m.nextOptimalStep(board);
        assertEquals(m.beads.get(board), beadsList2);
        m.nextOptimalStep(board);
        assertEquals(m.beads.get(board), beadsList3);
    }

    @Test
    public void testCreateValueKey() {
        List<Integer> beadsList1 = Arrays.asList(0, 0, 0,0,1,1,1,1);
        List<Integer> beadsList2 = Arrays.asList(-1, -1, -1,-1);
        MenaceStrategy m = new MenaceStrategy(4);
        String board = "002212121";
        m.createKeyValue(board);
        assertEquals(m.beads.get(board), beadsList1);
        board = "122212121";
        m.createKeyValue(board);
        assertEquals(m.beads.get(board), beadsList2);
    }
}
