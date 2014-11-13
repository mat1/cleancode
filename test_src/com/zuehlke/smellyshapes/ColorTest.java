package com.zuehlke.smellyshapes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ColorTest {

    @Test
    public void getErrorMessage_invalidColor() throws Exception {
        Color c = new Color("INVALIDColor_N4me");

        assertEquals("Color not recognized", c.getErrorMessage());
    }

    @Test
    public void getErrorMessage_Magenta() throws Exception {
        Color c = new Color("Magenta");

        assertEquals("Color not recognized", c.getErrorMessage());
    }

    @Test
    public void getErrorMessage_Cyan() throws Exception {
        Color c = new Color("Cyan");

        assertEquals("Color not recognized", c.getErrorMessage());
    }


    @Test
    public void getColorFormatted() throws Exception {
        Color c = new Color("Red");

        String formattedColor = c.getColorFormatted(true);

        assertEquals("Red #FF0000 255:0:0", formattedColor);
    }

}
