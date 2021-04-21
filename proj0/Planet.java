public class Planet {
    /* 6 instance variables */
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    private static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double x_distance = this.xxPos - p.xxPos;
        double y_distance = this.yyPos - p.yyPos;
        double d = x_distance * x_distance + y_distance * y_distance;
        return Math.sqrt(d);
    }

    public double calcForceExertedBy(Planet p) {
        return (G * this.mass * p.mass /(this.calcDistance(p) * this.calcDistance(p)));
    }

    public double calcForceExertedByX(Planet p) {
        double cos = (p.xxPos - this.xxPos) / this.calcDistance(p);
        return this.calcForceExertedBy(p) * cos;
    }

    public double calcForceExertedByY(Planet p) {
        double sin = (p.yyPos - this.yyPos) / this.calcDistance(p);
        return this.calcForceExertedBy(p) * sin;
    }

    public double calcNetForceExertedByX(Planet[] ps) {
        double xForce = 0;
        for (Planet p: ps) {
            if (!this.equals(p)) {
                xForce = xForce + this.calcForceExertedByX(p);
            }
        }
        return xForce;
    }

    public double calcNetForceExertedByY(Planet[] ps) {
        double yForce = 0;
        for (Planet p: ps) {
            if (!this.equals(p)) {
                yForce = yForce + this.calcForceExertedByY(p);
            }
        }
        return yForce;
    }

}
