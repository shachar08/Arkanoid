package geometry;
/**
 * @author Shachar Korall.
 * ID: 208486191
 * @version IntelliJ IDEA 2019.3.3
 * @since 06-04-2020
 */

/**
 * class Point.
 * creating a point by x and y values. */
public class Point {
    private double x;
    private double y;

    /**
     * constructor.
     * @param x - the x value of this point.
     * @param y - the y value of this point. */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * The method calculate the distance between two points.
     * @param other - the point the method receives.
     * @return - the distance between this point to the point the method received. */
    public double distance(Point other) {
        double dx = this.getX() - other.getX();
        double dy = this.getY() - other.getY();
        return Math.sqrt((dx * dx) + (dy * dy));
    }

    /**
     * The method checks if two points are the same point.
     * @param other - the point the method will receives.
     * @return - true if this point is the same point as the point the method received. false otherwise. */
    public boolean equals(Point other) {
        return (this.getX() == other.getX() && this.getY() == other.getY());
    }

    /**
     * The method return the x value of this point.
     * @return - the x value of this point. */
    public double getX() {return x;}

    /**
     * The method return the y value of this point.
     * @return - the y value of this point. */
    public double getY() {return y;}
}
