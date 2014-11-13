package com.zuehlke.smellyshapes;

public class Color {

	public static final String GREEN = "Green";
	public static final String BLUE = "Blue";
	public static final String RED = "Red";
	
	// TODO temp field
	private String colorAsHex;
	private String colorAsText;
	// TODO temp field
	private String colorAsRGB_Red;
	// TODO temp field
	private String colorAsRGB_Green;
	// TODO temp field
	private String colorAsRGB_Blue;
	// TODO temp field
	private String errorMessage;

	public Color(String colorAsText) {
		this.colorAsText = colorAsText;
		convertTextValueToRGBAndHex();
	}

	private void convertTextValueToRGBAndHex() {
		// TODO long method
		errorMessage = "";
		if (RED.equals(colorAsText)) {
			colorAsRGB_Red = "255";
			colorAsRGB_Blue = "0";
			colorAsRGB_Green = "0";
			colorAsHex = "#FF0000";
		} else if (BLUE.equals(colorAsText)) {
			colorAsRGB_Red = "0";
			colorAsRGB_Blue = "255";
			colorAsRGB_Green = "0";
			colorAsHex = "#00FF00";
		} else if (GREEN.equals(colorAsText)) {
			colorAsRGB_Red = "0";
			colorAsRGB_Blue = "0";
			colorAsRGB_Green = "255";
			colorAsHex = "#0000FF";
		} else {
			errorMessage = "Color not recognized";
		}
	}

	public String getBlue() {
		return colorAsRGB_Blue;
	}

	public String getGreen() {
		return colorAsRGB_Green;
	}

	public String getRed() {
		return colorAsRGB_Red;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getColorFormatted(boolean includeHexAndRGB) {
		if (includeHexAndRGB) {
			return colorAsText + " " + colorAsHex + " " + colorAsRGB_Red + ":"
					+ colorAsRGB_Green + ":" + colorAsRGB_Blue;
		} else {
			return colorAsText;
		}
	}

	public String getColorAsHex() {
		return colorAsHex;
	}
}
