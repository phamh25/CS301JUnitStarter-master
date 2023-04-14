package up.edu.dimcalc;

import static org.junit.Assert.*;

import android.graphics.Point;

import org.junit.Test;

public class TwoPointsTest {

    /** when created, getPoint() should show both points at the origin */
    @Test
    public void getPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
        assertEquals(0, p2.x);
        assertEquals(0, p2.y);
    }

    /** verify that arbitrary values are properly stored via setPoint() */
    @Test
    public void setPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -3);
        testPoints.setPoint(1, -3, 5);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(5, p1.x);
        assertEquals(-3, p1.y);
        assertEquals(-3, p2.x);
        assertEquals(5, p2.y);
    }

    @Test
    public void randomValue() throws Exception {
        TwoPoints testPoints = new TwoPoints(); // first rand points
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        testPoints.setPoint(0, 25, 25);
        testPoints.setPoint(1, 25, 25);
        testPoints.randomValue(0);
        testPoints.randomValue(1);

        assertNotEquals(25, p1.x); // check that the random points are rand
        assertNotEquals(25, p1.y);
        assertNotEquals(25, p2.x);
        assertNotEquals(25, p2.y);

    }

    @Test
    public void setOrigin() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setOrigin(0);
        testPoints.setOrigin(1);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
        assertEquals(0, p2.x);
        assertEquals(0, p2.y);

    }

    @Test
    public void copy() {
        TwoPoints testPoints = new TwoPoints();

        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        testPoints.setPoint(0, 15, 15);
        testPoints.setPoint(1, 2, 2);

        testPoints.copy(0, 1);

        assertEquals(15, p1.x);
        assertEquals(15, p1.y);
        assertEquals(15, p2.x);
        assertEquals(15, p2.y);
    }

    @Test
    public void distance() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 1, 1);
        testPoints.setPoint(1, 4, 6);
        int dist = testPoints.distance();
        assertEquals(6, dist);
    }

    @Test
    public void slope() {
        TwoPoints testPoints = new TwoPoints(); // check for different slope
        testPoints.setPoint(0, 2, 2);
        testPoints.setPoint(1, 7, 5);
        double slope = testPoints.slope();
        double expectSlope = (2.0-7.0)/(2.0-5.0);

        TwoPoints testPointsTwo = new TwoPoints(); // check for same slope
        testPointsTwo.setPoint(0, 6, 6);
        testPointsTwo.setPoint(1, 6, 6);
        double slopeTwo = testPointsTwo.slope();
        double expectSlopeTwo = 0.0;

        assertEquals(expectSlope, slope, .0001);
        assertEquals(expectSlopeTwo, slopeTwo, .0001);
    }
}