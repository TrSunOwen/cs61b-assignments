public class OffByN implements CharacterComparator{
    private int n;

    public OffByN(int n) {
        this.n = n;
    }

    @Override
    /** Return true for characters that are different by exactly n. */
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        if (Math.abs(diff) == n) {
            return true;
        } else {
            return false;
        }
    }
}
