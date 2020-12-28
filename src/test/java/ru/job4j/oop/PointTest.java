package ru.job4j.oop;

import junit.framework.TestCase;
import org.junit.Test;

import org.junit.Assert;

public class PointTest extends TestCase {

    public void testDistance3d() {
        double expected = 25;
        Point x = new Point(4, 2);
        Point y = new Point(0, 4);
        Point z = new Point(0, 4);
        double rsl = Point.distance3d(2);
        Assert.assertEquals(expected, rsl, 0.01);
    }
}