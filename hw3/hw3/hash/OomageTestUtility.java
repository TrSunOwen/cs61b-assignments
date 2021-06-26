package hw3.hash;

import java.util.List;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        /* TODO:
         * Write a utility function that returns true if the given oomages
         * have hashCodes that would distribute them fairly evenly across
         * M buckets. To do this, convert each oomage's hashcode in the
         * same way as in the visualizer, i.e. (& 0x7FFFFFFF) % M.
         * and ensure that no bucket has fewer than N / 50
         * Oomages and no bucket has more than N / 2.5 Oomages.
         */

        /** Creates an array to record the number of oomages in each bucket! */
        int[] counts = new int[M];

        /** After the calculation on each oomage's hashcode, the value of bucketNum (ranging from 0 to M-1) will be
         * worked out.
         * Then, plus one in the according array[bucketNum].
         * */
        for (Oomage o: oomages) {
            int bucketNum = (o.hashCode() & 0x7FFFFFFF) % M;
            counts[bucketNum]+=1;
        }

        /**
         * Ensures that no bucket has fewer than N / 50 Oomages and no bucket has more than N / 2.5 Oomages.
         *
         * */
        for (int c: counts) {
            if (c < (oomages.size() / 50) || c > (oomages.size() / 2.5)) {
                return false;
            }
        }
        return true;
    }
}
