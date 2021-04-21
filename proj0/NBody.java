public class NBody {
    /** Given a file name, it should return a double
     * corresponding to the radius of the universe in that file. */
    public static double readRadius(String fileName) {
        In in = new In(fileName);
        in.readInt();
        double radius = in.readDouble();
        return radius;
    }
    /** Your next method is readPlanets.
     * Given a file name, it should return an array of Planets corresponding to the planets in the file,
     * e.g. readPlanets("./data/planets.txt") should return an array of five planets.
     * You will find the readInt(), readDouble(), and readString() methods in the In class to be useful. */
    public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);
        int number = in.readInt();
        in.readDouble();

        Planet[] ps = new Planet[number];

        int index = 0;

        while (index < number) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            ps[index] = new Planet(xP, yP, xV, yV, m, img);
            index++;
        }
        return ps;
    }

    /** Draw the Initial Universe State (main). */
    public static void main(String[] args) {
        /** Collect All Needed Input */
        /** Store the 0th and 1st command line arguments as doubles named T and dt. */
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);

        /** Store the 2nd command line argument as a String named filename. */
        String fileName = args[2];

        /** Read in the planets and the universe radius from the file
         * described by filename using your methods from earlier in this assignment. */
        Planet[] ps = NBody.readPlanets(fileName);
        double radius = NBody.readRadius(fileName);

        /** Draw the Background. */
        StdDraw.setXscale(-radius, radius);
        StdDraw.setYscale(-radius, radius);
        StdDraw.picture(0, 0, "images/starfield.jpg");

        /** Draw All of the Planets. */
        for (Planet p: ps) {
            p.draw();
        }

        /** This is a graphics technique to prevent flickering in the animation.
         *  This should be just a single method call, so you shouldn’t do anything complicated here. */
        StdDraw.enableDoubleBuffering();

        /** Create a time variable and set it to 0. */
        double t = 0;

        /** Set up a loop to loop until this time variable is T. */
        while (t <= T) {
            /** Create an xForces array and yForces array. */
            double[] xForces = new double[ps.length];
            double[] yForces = new double[ps.length];

            /** Calculate the net x and y forces for each planet,
             * storing these in the xForces and yForces arrays respectively. */
            for (int i = 0; i < ps.length; i++) {
                xForces[i] = ps[i].calcNetForceExertedByX(ps);
                yForces[i] = ps[i].calcNetForceExertedByY(ps);
            }

            /** Call update on each of the planets.
             * This will update each planet’s position, velocity, and acceleration. */
            for (int i = 0; i < ps.length; i++) {
                ps[i].update(dt, xForces[i], yForces[i]);
            }

            /** Draw the background image. */
            StdDraw.picture(0, 0, "images/starfield.jpg");

            /** Draw all of the planets. */
            for (Planet p: ps) {
                p.draw();
            }

            /** Show the offscreen buffer. */
            StdDraw.show();

            /** Pause the animation for 10 milliseconds. */
            StdDraw.pause(10);

            /** Increase your time variable by dt. */
            t = t + dt;
        }

        /** When the simulation is over,
         * i.e. when you’ve reached time T,
         * you should print out the final state of the universe in the same format as the input */
        StdOut.printf("%d\n", ps.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < ps.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    ps[i].xxPos, ps[i].yyPos, ps[i].xxVel,
                    ps[i].yyVel, ps[i].mass, ps[i].imgFileName);
        }
    }
}
