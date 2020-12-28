package ru.job4j.oop;

import junit.framework.TestCase;
import org.junit.Test;

import org.junit.Assert;

public class PointTest extends TestCase {

    public void testDistance3dFirst() {
        double expected = 6;
        Point x = new Point(4, 2, 4);
        Point y = new Point(0, 4, 0);
        double rsl = x.distance3d(y);
        Assert.assertEquals(expected, rsl, 0.01);
    }

    public void testDistance3dSecond() {
        double expected = 4.6;
        Point x = new Point(3, 6, 3);
        Point y = new Point(5, 2, 4);
        double rsl = x.distance3d(y);
        Assert.assertEquals(expected, rsl, 0.1);
    }
}