package com.zuehlke.smellyshapes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SquareTest {

    @Test
    public void calculateArea() {
        Square square = new Square(new Point(0, 0), 2);
        assertEquals(4, square.calculate());
    }

    @Test
    public void toString_() {
        Square square = new Square(new Point(0, 0), 1, new Color("Red"));
        assertEquals("Square: (0:0) edgeLength=1 color=#FF0000", square.toString());
    }

    @Test
    public void toXml() {
        Square square = new Square(new Point(0, 1), 2);
        String xml = square.toXml();
        assertEquals("<square x=\"0\" y=\"1\" edgeLength=\"2\" />\n", xml);
    }

    @Test
    public void containsPoints() {
        Square square = new Square(new Point(0, 0), 1);

        assertTrue(square.contains(new Point(0, 0)));
        assertTrue(square.contains(new Point(0, 1)));
        assertTrue(square.contains(new Point(1, 1)));
        assertTrue(square.contains(new Point(1, 0)));

        assertFalse(square.contains(new Point(-1, -1)));
        assertFalse(square.contains(new Point(-1, 0)));
        assertFalse(square.contains(new Point(0, -1)));
        assertFalse(square.contains(new Point(1, 2)));
        assertFalse(square.contains(new Point(2, 1)));
    }

    @Test(expected = RuntimeException.class)
    public void getHeigth() {
        new Square(new Point(0, 0), 0).getHeight();
    }
}
