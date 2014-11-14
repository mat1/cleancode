package com.zuehlke.smellyshapes;

public class Color {

	public static final String GREEN = "Green";
	public static final String BLUE = "Blue";
	public static final String RED = "Red";

	// TODO temp field
	private String colorAsHex;
	private String colorAsText;
	// TODO temp field
	private int red;
	// TODO temp field
	private int green;
	// TODO temp field
	private int blue;
	// TODO temp field
	private String errorMessage;

	public Color(String colorAsText) {
		this.colorAsText = colorAsText;
		convertTextValueToRGBAndHex();
	}
	
	public Color(String colorAsHex, String colorAsText, int red, int green,
			int blue) {
		this.colorAsHex = colorAsHex;
		this.colorAsText = colorAsText;
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	private void convertTextValueToRGBAndHex() {
		errorMessage = "";
		if (RED.equals(getColorAsText())) {
			red = 255;
			blue = 0;
			green = 0;
			colorAsHex = "#FF0000";
		} else if (BLUE.equals(getColorAsText())) {
			red = 0;
			blue = 255;
			green = 0;
			colorAsHex = "#00FF00";
		} else if (GREEN.equals(getColorAsText())) {
			red = 0;
			blue = 0;
			green = 255;
			colorAsHex = "#0000FF";
		} else {
			errorMessage = "Color not recognized";
		}
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getFormattedColor() {
		return getColorAsText() + " " + colorAsHex + " " + red + ":"
				+ green + ":" + blue;
	}

	public String getColorAsText() {
		return colorAsText;
	}

	public String getColorAsHex() {
		return colorAsHex;
	}

	public String getColorAsRgb() {
		return " RGB=" + red + "," + green + ","
				+ blue;
	}

}
