package geometry;
/**
 * @author Shachar Korall.
 * ID: 208486191
 * @version IntelliJ IDEA 2019.3.3
 * @since 28-04-2020
 */

/**
 * class Line.
 * creating a line from two points and checks intersecting between two lines. */
public class Line {
    private Point start;
    private Point end;

    /**
     * constructor.
     * @param start - the start point of this line.
     * @param end - the end point of this line. */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * constructor.
     * @param x1 - the x value of the start point of this line.
     * @param y1 - the y value of the start point of this line.
     * @param x2 - the x value of the end point of this line.
     * @param y2 - the y value of the end point of this line. */
    public Line(double x1, double y1, double x2, double y2) {
        start = new Point(x1, y1);
        end = new Point(x2, y2);
    }

    /**
     * The method return the length of this line.
     * @return - the length of this line. */
    public double length() {
        return start.distance(end);
    }

    /**
     * The method return the middle point of this line.
     * @return - the middle point of this line. */
    public Point middle() {
        double x3 = (start.getX() + end.getX()) / 2;
        double y3 = (start.getY() + end.getY()) / 2;
        return new Point(x3, y3);
    }

    /**
     * The method return the start point of this line.
     * @return - the start point of this line. */
    public Point start() {
        return start;
    }

    /**
     * The method return the end point of this line.
     * @return - the end point of this line. */
    public Point end() {
        return end;
    }

    /**
     * The method calculate the slope of this line and returns it.
     * @return - the slope of this line. */
    public double getM() {
        return (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
    }

    /**
     * The method calculate the y-intercept of 0 of this line and returns it.
     * @return - the y-intercept of 0 of this line. */
    public double getC() {
        return (this.start.getY() - (this.getM() * this.start.getX()));
    }

    /**
     * the method helps me to check if there is more than one point of intersection between 2 parallel balanced lines.
     * <p>
     * The method checks if there is intersection between two parallel balanced lines in more then one point. it will
     * use a very small variable called "eps" to check if the lines are intersecting in another point in addition to
     * the intersecting point I found before (I will call this method only if I already found one intersecting point
     * between two parallel balanced lines).
     * <p>
     * @param other - the line the method received. it will check intersecting between this line to other line.
     * @return - true if the method found another intersection point. false otherwise. */
    public boolean checkEpsWhenParallelBalanced(Line other) {
        double eps = 0.000000001; // like epsilon
        double thisXS = this.start.getX();
        double thisXe = this.end.getX();
        if (((thisXS + eps <= Math.max(other.start.getX(), other.end.getX())
                && thisXS + eps >= Math.min(other.start.getX(), other.end.getX()))
                || (thisXS - eps <= Math.max(other.start.getX(), other.end.getX())
                && thisXS - eps >= Math.min(other.start.getX(), other.end.getX())))
                && ((thisXe + eps <= Math.max(other.start.getX(), other.end.getX())
                && thisXe + eps >= Math.min(other.start.getX(), other.end.getX()))
                || (thisXe - eps <= Math.max(other.start.getX(), other.end.getX())
                && thisXe - eps >= Math.min(other.start.getX(), other.end.getX())))) {
            return true;
        }
        return false;
    }

    /**
     * the method helps me to check if there is more than one point of intersection between 2 parallel vertical lines.
     * <p>
     * The method checks if there is intersection between two parallel vertical lines in more then one point. it will
     * use a very small variable called "eps" to check if the lines are intersecting in another point in addition to
     * the intersecting point I found before (I will call this method only if I already found one intersecting point
     * between two parallel vertical lines).
     * <p>
     * @param other - the line the method received. it will check intersecting between this line to other line.
     * @return - true if the method found another intersection point. false otherwise. */
    public boolean checkEpsWhenParallelVertical(Line other) {
        double eps = 0.000000001; // like epsilon
        double thisYs = this.start.getY();
        double thisYe = this.end.getY();
        if (((thisYs + eps <= Math.max(other.start.getY(), other.end.getY())
                && thisYs + eps >= Math.min(other.start.getY(), other.end.getY()))
                || (thisYs - eps <= Math.max(other.start.getY(), other.end.getY())
                && thisYs - eps >= Math.min(other.start.getY(), other.end.getY())))
                && ((thisYe + eps <= Math.max(other.start.getY(), other.end.getY())
                && thisYe + eps >= Math.min(other.start.getY(), other.end.getY()))
                || (thisYe - eps <= Math.max(other.start.getY(), other.end.getY())
                && thisYe - eps >= Math.min(other.start.getY(), other.end.getY())))) {
            return true;
        }
        return false;
    }

    /**
     * the method checks if the point of intersection i found is in the range of the lines.
     * <p>
     * After I found the point of intersection between two direct equation the method will check if the point of
     * intersection is between the range of the lines we received.
     * <p>
     * @param thisX - the x value of the intersecting point I found.
     * @param thisY - the y value of the intersecting point I found.
     * @param other - the line that we check that intersected with this line.
     * @return - true if the intersecting point is in range of the lines. false otherwise. */
    public boolean ifPointInRange(double thisX, double thisY, Line other) {
        if (thisX <= Math.max(this.start.getX(), this.end.getX())
                && thisX >= Math.min(this.start.getX(), this.end.getX())
                && thisY <= Math.max(this.start.getY(), this.end.getY())
                && thisY >= Math.min(this.start.getY(), this.end.getY())
                && (thisX <= Math.max(other.start.getX(), other.end.getX())
                && thisX >= Math.min(other.start.getX(), other.end.getX())
                && thisY <= Math.max(other.start.getY(), other.end.getY())
                && thisY >= Math.min(other.start.getY(), other.end.getY()))) { // (thisX, thisY) - intersection point
            return true;
        }
        return false;
    }

    /**
     * the method checks if there intersecting point between two lines.
     * <p>
     * the method checks if there intersecting point between two lines using the direct equations of the lines. if
     * there is intersecting point the method will return the point of intersection.
     * <p>
     * @param other - the line that we check that intersected with this line.
     * @return - the point of intersection if we found intersecting point. null otherwise. */
    public Point checkIntersection(Line other) {
        double thisX = (other.getC() - this.getC()) / (this.getM() - other.getM());
        if (this.getM() == other.getM()) {
            thisX = this.start.getY();
        }
        double thisY = (this.getM() * thisX) + this.getC();
        double otherX = (this.getC() - other.getC()) / (other.getM() - this.getM());
        if (other.getM() == this.getM()) {
            otherX = other.start.getX();
        }
        double otherY = (other.getM() * otherX) + other.getC();
        if (this.ifPointInRange(thisX, thisY, other)) {
            return new Point(thisX, thisY);
        }
        if (other.ifPointInRange(otherX, otherY, this)) {
            return new Point(otherX, otherY);
        }
        return null;
    }

    /**
     * the method checks all the intersecting situations that can be between two lines.
     * <p>
     * the method contains a lot of situations that can be between two lines and in every two lines the method will
     * receive and check for intersecting between them - the method will run over the if conditions and will get into
     * the if condition that match the two lines situation. if there is intersecting point the method will return the
     * intersecting point.
     * <p>
     * @param other - the line that we check that intersected with this line.
     * @return - the point of intersection if we found intersecting point. null otherwise. */
    public Point findIntersectionPoint(Line other) {
        /* when the lines are the same */
        if ((this.start.getX() == other.start.getX() && this.end.getX() == other.end.getX())
                && ((this.start.getY() == other.start.getY() && this.end.getY() == other.end.getY()))
                || (this.start.getX() == other.end.getX() && this.end.getX() == other.start.getX())
                && ((this.start.getY() == other.end.getY() && this.end.getY() == other.start.getY()))) {
            return null;
        }
        /* when this line is only a point */
        if (this.start.getX() == this.end.getX() && this.start.getY() == this.end.getY()) {
            double interX = this.start.getX();
            double interY = this.start.getY();
            if (this.ifPointInRange(interX, interY, other)) {
                return new Point(interX, interY);
            }
        }
        /* when other line is only a point */
        if (other.start.getX() == other.end.getX() && other.start.getY() == other.end.getY()) {
            double interX = other.start.getX();
            double interY = other.start.getY();
            if (other.ifPointInRange(interX, interY, this)) {
                return new Point(interX, interY);
            }
        }
        /* when the lines are parallel and balanced */
        if (this.start.getY() == this.end.getY() && other.start.getY() == other.end.getY()) {
            if (this.start.getY() != other.start.getY()) {
                return null;
            }
            if (!this.checkEpsWhenParallelBalanced(other) && !other.checkEpsWhenParallelBalanced(this)) {
                if (this.start.getX() == other.start.getX() || this.start.getX() == other.end.getX()) {
                    return new Point(this.start.getX(), this.start.getY());
                }
                if (this.end.getX() == other.start.getX() || this.end.getX() == other.end.getX()) {
                    return new Point(this.end.getX(), this.end.getY());
                }
            }
            return null;
        }
        /* when the lines are parallel and vertical */
        if (this.start.getX() == this.end.getX() && other.start.getX() == other.end.getX()) {
            if (this.start.getX() != other.start.getX()) {
                return null;
            }
            if (!this.checkEpsWhenParallelVertical(other) && !other.checkEpsWhenParallelVertical(this)) {
                if (this.start.getY() == other.start.getY() || this.start.getY() == other.end.getY()) {
                    return new Point(this.start.getX(), this.start.getY());
                }
                if (this.end.getY() == other.start.getY() || this.end.getY() == other.end.getY()) {
                    return new Point(this.end.getX(), this.end.getY());
                }
            }
            return null;
        }
        /* when the lines are just parallel */
        if (this.getM() == other.getM()) {
            double eps = 0.000000001; // like epsilon
            double tsx = this.start.getX();
            double tsy = this.start.getY();
            double tex = this.end.getX();
            double tey = this.end.getY();
            double osx = other.start.getX();
            double osy = other.start.getY();
            double oex = other.end.getX();
            double oey = other.end.getY();
            if (tsx == osx || tsx == oex) {
                if (ifPointInRange(tsx + eps, tsy + eps, other)) {
                    return null;
                }
                return new Point(tsx, tsy);
            }
            if (tex == osx || tex == oex) {
                if (ifPointInRange(tex + eps, tey + eps, other)) {
                    return null;
                }
                return new Point(tex, tey);
            }
        }
        /* when this line is vertical and other line is balanced */
        if (this.start.getX() == this.end.getX() && other.start.getY() == other.end.getY()) {
            double interX = this.start.getX();
            double interY = other.start.getY();
            if (this.ifPointInRange(interX, interY, other)) {
                return new Point(interX, interY);
            }
        }
        /* when this line is balanced and other line is vertical */
        if (this.start.getY() == this.end.getY() && other.start.getX() == other.end.getX()) {
            double interX = other.start.getX();
            double interY = this.start.getY();
            if (other.ifPointInRange(interX, interY, this)) {
                return new Point(interX, interY);
            }
        }
        /* when this line is vertical */
        if (this.start.getX() == this.end.getX() && other.start.getX() != other.end.getX()) {
            double interX = this.start.getX();
            double interY = (other.getM() * interX) + other.getC();
            if (this.ifPointInRange(interX, interY, other)) {
                return new Point(interX, interY);
            }
        }
        /* when other line is vertical */
        if (this.start.getX() != this.end.getX() && other.start.getX() == other.end.getX()) {
            double interX = other.start.getX();
            double interY = (this.getM() * interX) + this.getC();
            if (other.ifPointInRange(interX, interY, this)) {
                return new Point(interX, interY);
            }
        }
        /* when this line is balanced */
        if ((this.start.getY() == this.end.getY() && other.start.getY() != other.end.getY())
                || (this.start.getX() != this.end.getX() && this.start.getY() != this.end.getY())) {
            return this.checkIntersection(other);
        }
        /* when other line is balanced */
        if ((this.start.getY() != this.end.getY() && other.start.getY() == other.end.getY())
                || (other.start.getX() != other.end.getX() && other.start.getY() != other.end.getY())) {
            return other.checkIntersection(this);
        }
        return null; // if there is no intersection between the lines.
    }

    /**
     * the method checks if there is intersection between two lines.
     * @param other - the line the method received. it will check intersecting between this line to other line.
     * @return - true if there is intersecting point between the lines. false otherwise. */
    public boolean isIntersecting(Line other) {
        if (this.findIntersectionPoint(other) != null) {
            return true;
        }
        return false;
    }

    /**
     * the method checks what is the intersecting point between two lines.
     * @param other - the line the method received. it will check intersecting between this line to other line.
     * @return -  the point of intersection if we found intersecting point. null otherwise. */
    public Point intersectionWith(Line other) {
        if (this.isIntersecting(other)) {
            return this.findIntersectionPoint(other);
        }
        return null;
    }

    /**
     * the method checks if two lines are equals.
     * @param other - the line the method received. it will check equality between this line to other line.
     * @return - true is the lines are equal, false otherwise. */
    public boolean equals(Line other) {
        return (this.start.getX() == other.start.getX() && this.start.getY() == other.start.getY())
                && (this.end.getX() == other.end.getX() && this.end.getY() == other.end.getY());
    }

    /**
     * the method search for the closest intersection point between the start point of a line and a given rectangle.
     * @param rect - the rectangle that the method will search the closest intersection with.
     * @return -  the point of the closest intersection between the start point of a line and a given rectangle. */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        Line l = new Line(this.start, this.end);
        if (rect.intersectionPoints(l).isEmpty()) {
            return null;
        }
        Point p = new Point(l.start.getX(), l.start.getY());
        int size = rect.intersectionPoints(l).size();
        double[] inter = new double[size]; // array for the distances
        for (int i = 0; i < size; i++) {
            inter[i] = rect.intersectionPoints(l).get(i).distance(p);
        }
        int index = 0;
        double min = inter[index];
        for (int i = 0; i < size; i++) {
            if (inter[i] <= min) { // compare to find the minimal
                min = inter[i];
                index = i; // the index of the closest intersection point
            }
        }
        return rect.intersectionPoints(l).get(index);
    }
}