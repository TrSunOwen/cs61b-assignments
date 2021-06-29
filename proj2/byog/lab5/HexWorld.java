package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;


import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {

    /**
     * Compute the width of row i for a size s hexagon.
     * @param s the size of the hexagon, representing the length of each side
     * @param i the ith row, starts from 0 to (2 * s - 1)
     * @return the length of every row in the hexagon
     */
    public static int hexRowWidth(int s, int i) {
        int effectiveI = i;
        if (i >= s) {
            effectiveI = 2 * s - 1 -effectiveI;
        }

        return (s + 2 * effectiveI);
    }

    public static void addHexagon() {

    }
}
