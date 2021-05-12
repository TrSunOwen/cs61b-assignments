import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByN;

    // Your tests go here.
    @Test
    public void testEqualChars() {
        offByN = new OffByN(3);
        assertTrue(offByN.equalChars('a', 'd'));
        assertTrue(offByN.equalChars('g', 'd'));
        assertFalse(offByN.equalChars('a', 'a'));
    }
}
