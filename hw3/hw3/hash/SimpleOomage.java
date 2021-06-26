package hw3.hash;
import java.awt.Color;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdDraw;


public class SimpleOomage implements Oomage {
    protected int red;
    protected int green;
    protected int blue;

    private static final double WIDTH = 0.01;
    private static final boolean USE_PERFECT_HASH = true;

    @Override
    public boolean equals(Object o) {
        /** If o is null. */
        if (o == null) {
            return false;
        }

        /** If this and o refer to the same object. */
        if (this == o) {
            return true;
        }

        if (o.getClass() != this.getClass()) {
            return false;
        }

        /** If they just has the same values of red, green and blue. */
        SimpleOomage oCasted = (SimpleOomage) o;
        return this.red == oCasted.red && this.blue == oCasted.blue && this.green == oCasted.green;
    }

    /* Uncomment this method after you've written
       equals and failed the testHashCodeAndEqualsConsistency
       test.
     */
    @Override
    public int hashCode() {
        if (!USE_PERFECT_HASH) {
            return red + green + blue;
        } else {
            // TODO: Write a perfect hash function for Simple Oomages.
            /**
             * Red equals 65536 (256^2)
                (255x65536 = 16711680, aka pure red)
             * Green equals 256 (256^1)
                (255x256 = 65280, aka pure green)
             * Blue equals 1 (256^0)
                (255x1 = 255, aka pure blue)
             */
            return (65536 * red + 256 * green + 1 * blue);
        }
    }

    public SimpleOomage(int r, int g, int b) {
        if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
            throw new IllegalArgumentException();
        }
        if ((r % 5 != 0) || (g % 5 != 0) || (b % 5 != 0)) {
            throw new IllegalArgumentException("red/green/blue values must all be multiples of 5!");
        }
        red = r;
        green = g;
        blue = b;
    }

    @Override
    public void draw(double x, double y, double scalingFactor) {
        StdDraw.setPenColor(new Color(red, green, blue));
        StdDraw.filledSquare(x, y, WIDTH * scalingFactor);
    }

    public static SimpleOomage randomSimpleOomage() {
        int red = StdRandom.uniform(0, 51) * 5;
        int green = StdRandom.uniform(0, 51) * 5;
        int blue = StdRandom.uniform(0, 51) * 5;
        return new SimpleOomage(red, green, blue);
    }

    public static void main(String[] args) {
        System.out.println("Drawing 4 random simple Oomages.");
        randomSimpleOomage().draw(0.25, 0.25, 1);
        randomSimpleOomage().draw(0.75, 0.75, 1);
        randomSimpleOomage().draw(0.25, 0.75, 1);
        randomSimpleOomage().draw(0.75, 0.25, 1);
    }

    public String toString() {
        return "R: " + red + ", G: " + green + ", B: " + blue;
    }
} 
