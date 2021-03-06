package com.zuehlke.smellyshapes;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CircleTest {

    private Circle circle;

    @Before
    public void setUp() {
        circle = new Circle(new Point(0, 0), 1);
        circle.setColor(new Color("Red"));
    }

    @Test
    public void contains() throws Exception {
        assertTrue(circle.contains(new Point(0, 0)));
        assertTrue(circle.contains(new Point(0, 1)));
        assertTrue(circle.contains(new Point(1, 0)));

        assertFalse(circle.contains(new Point(1, 1)));
        assertFalse(circle.contains(new Point(-1, -1)));
        assertFalse(circle.contains(new Point(1, -1)));
        assertFalse(circle.contains(new Point(-1, 1)));

    }

    @Test
    public void countContainingPoints() throws Exception {
        int[] xCords = new int[]{0, 10};
        int[] yCords = new int[]{0, 10};
        
		List<Point> points = new ArrayList<>();
		for (int i = 0; i < xCords.length; ++i) {
			points.add(new Point(xCords[i], yCords[i]));
		}
		int result = circle.countContainingPoints(points);

        assertEquals(1, result);
    }

    @Test
    public void toXml() throws Exception {
        String xml = circle.toXml();

        assertEquals("<circle x=\"0\" y=\"0\" radius=\"1\" />\n", xml);
    }

    @Test
    public void toString_() throws Exception {
        assertEquals("Circle: (0,0) radius= 1 RGB=255,0,0", circle.toString());
    }
}
