package geometry;
/**
 * @author Shachar Korall.
 * ID: 208486191
 * @version IntelliJ IDEA 2019.3.3
 * @since 28-04-2020
 */

import java.util.ArrayList;
import java.util.List;

/**
 * class Ball.
 * creating a rectangle. */
public class Rectangle {
    private double width;
    private double height;
    private Point upperLeft;

    /**
     * constructor.
     * @param upperLeft - the upper left point of the rectangle.
     * @param width - the width of the rectangle.
     * @param height - the height of the rectangle. */
    public Rectangle(Point upperLeft, double width, double height) {
        this.width = width;
        this.height = height;
        this.upperLeft = upperLeft;
    }

    /**
     * The method creates and returns the a list of the side lines of the rectangle.
     * @return - the list of the side lines of the rectangle. */
    public java.util.List<Line> rectangleLines() {
        Line lUp = new Line(upperLeft, getUpperRight());
        Line lDown = new Line(getDownerLeft(), getDownerRight());
        Line lLeft = new Line(upperLeft, getDownerLeft());
        Line lRight = new Line(getUpperRight(), getDownerRight());
        List<Line> linesArr = new ArrayList<>();
        linesArr.add(lUp);
        linesArr.add(lDown);
        linesArr.add(lLeft);
        linesArr.add(lRight);
        return linesArr;
    }

    /**
     * The method returns a list (possibly empty) of all the intersection points between a given line and the rectangle.
     * @param line - the line that we will check it's intersection points with the rectangle.
     * @return - the list of all the intersection points between a line and the rectangle. */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> interList = new ArrayList<>();
        if (rectangleLines().get(0).isIntersecting(line)) { // index 0 is up line
            interList.add(rectangleLines().get(0).intersectionWith(line));
        }
        if (rectangleLines().get(1).isIntersecting(line)) { // index 1 is down line
            interList.add(rectangleLines().get(1).intersectionWith(line));
        }
        if (rectangleLines().get(2).isIntersecting(line)) { // index 2 is left line
            interList.add(rectangleLines().get(2).intersectionWith(line));
        }
        if (rectangleLines().get(3).isIntersecting(line)) { // index 3 is right line
            interList.add(rectangleLines().get(3).intersectionWith(line));
        }
        int size = interList.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (interList.get(i).equals(interList.get(j))) {
                    interList.remove(interList.get(j));
                    size = size - 1;
                }
            }
        }
        return interList;
    }

    /**
     * The method return the width of the rectangle.
     * @return - the width of the rectangle. */
    public double getWidth() {
        return width;
    }

    /**
     * The method return the heighr of the rectangle.
     * @return - the height of the rectangle. */
    public double getHeight() {
        return height;
    }

    /**
     * The method return the upper left point of the rectangle.
     * @return - the upper left point of the rectangle. */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * The method return the upper right point of the rectangle.
     * @return - the upper right point of the rectangle. */
    public Point getUpperRight() {
        return new Point(upperLeft.getX() + this.getWidth(), upperLeft.getY());
    }

    /**
     * The method return the downer left point of the rectangle.
     * @return - the downer left point of the rectangle. */
    public Point getDownerLeft() {
        return new Point(upperLeft.getX(), upperLeft.getY() + this.getHeight());
    }

    /**
     * The method return the downer right point of the rectangle.
     * @return - the downer right point of the rectangle. */
    public Point getDownerRight() {
        return new Point(upperLeft.getX() + this.getWidth(), upperLeft.getY() + this.getHeight());
    }
}
