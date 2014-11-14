package com.zuehlke.smellyshapes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RectangleTest {

    private Rectangle rectangle;

    @Before
    public void setUp() throws Exception {
        rectangle = new Rectangle(new Point(0, 0), new Dimension(2, 1));
    }

    @Test
    public void contains() throws Exception {
        assertTrue(rectangle.contains(new Point(0, 0)));
        assertTrue(rectangle.contains(new Point(1, 0)));
        assertTrue(rectangle.contains(new Point(1, 1)));
        assertTrue(rectangle.contains(new Point(2, 1)));

        assertFalse(rectangle.contains(new Point(2, 2)));
        assertFalse(rectangle.contains(new Point(-1, 0)));
        assertFalse(rectangle.contains(new Point(0, -1)));
    }

    @Test
    public void calculateArea() throws Exception {
        assertEquals(2, rectangle.calculate());
    }

    @Test
    public void toXml() throws Exception {
        String xml = rectangle.toXml();

        assertEquals("<rectangle x=\"0\" y=\"0\" width=\"2\" height=\"1\" />\n", xml);
    }
}
