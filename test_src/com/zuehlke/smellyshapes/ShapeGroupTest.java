package com.zuehlke.smellyshapes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ShapeGroupTest {

    @Test
    public void tooXml() throws Exception {
        ShapeGroup shapeGroup = new ShapeGroup();
        shapeGroup.add(new Rectangle(0, 0, 2, 1));

        String xml = shapeGroup.toXml();

        assertEquals(
                "<shapegroup>\n<rectangle x=\"0\" y=\"0\" width=\"2\" height=\"1\" />\n</shapegroup>\n",
                xml);
    }

    @Test
    public void constructor_withShapeArray() throws Exception {
        ShapeGroup shapeGroup = new ShapeGroup(new Shape[]{new Circle(0, 0, 0)}, true);

        assertEquals(1, shapeGroup.getSize());
    }

    @Test
    public void add_withReadOnly() throws Exception {
        ShapeGroup shapeGroup = new ShapeGroup();
        shapeGroup.setReadOnly(true);

        shapeGroup.add(new Circle(0, 0, 0));

        assertEquals(0, shapeGroup.getSize());
    }

    @Test
    public void add_withoutReadOnly() throws Exception {
        ShapeGroup shapeGroup = new ShapeGroup();
        shapeGroup.setReadOnly(false);

        shapeGroup.add(new Circle(0, 0, 0));

        assertEquals(1, shapeGroup.getSize());
    }

    @Test
    public void add_sameElementTwice() throws Exception {
        ShapeGroup shapeGroup = new ShapeGroup();
        shapeGroup.setReadOnly(false);

        Circle circle = new Circle(0, 0, 0);
        shapeGroup.add(circle);
        shapeGroup.add(circle);

        assertEquals(1, shapeGroup.getSize());
    }

    @Test
    public void add_internalArraySizeExceeded() throws Exception {
        ShapeGroup shapeGroup = new ShapeGroup();
        shapeGroup.setReadOnly(false);

        for (int i = 0; i < 11; i++) {
            shapeGroup.add(new Circle(0, 0, 0));
        }

        assertEquals(11, shapeGroup.getSize());
    }

    @Test
    public void contains_pointNotInGroup() throws Exception {
        ShapeGroup shapeGroup = new ShapeGroup();

        assertFalse(shapeGroup.contains(0, 0));
    }

    @Test
    public void contains_pointInGroup() throws Exception {
        ShapeGroup shapeGroup = new ShapeGroup();
        shapeGroup.add(new Circle(0, 0, 0));

        assertTrue(shapeGroup.contains(0, 0));
    }

    @Test
    public void contains_null() throws Exception {
        ShapeGroup shapeGroup = new ShapeGroup();

        assertFalse(shapeGroup.contains(null));
    }

    @Test
    public void contains_shapeInGroup() throws Exception {
        ShapeGroup shapeGroup = new ShapeGroup();
        Circle c = new Circle(0, 0, 0);
        shapeGroup.add(c);

        assertTrue(shapeGroup.contains(c));
    }
}
