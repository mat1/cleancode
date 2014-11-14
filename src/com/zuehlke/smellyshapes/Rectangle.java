package com.zuehlke.smellyshapes;

public class Rectangle implements Shape {

	protected Color c = new Color(Color.BLUE);
	private int x;
	private int y;
	int width;
	int height;

	public Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public boolean contains(int x, int y) {
		boolean containsX = (this.x <= x) && (x <= this.x + width);
		boolean containsY = (this.y <= y) && (y <= this.y + height);
		return containsX && containsY;
	}

	public int calculate() {
		return width * height;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	@Override
	public String toXml() {
		StringBuilder builder = new StringBuilder();
		builder.append("<rectangle");
		builder.append(" x=\"" + getX() + "\"");
		builder.append(" y=\"" + getY() + "\"");
		builder.append(" width=\"" + getWidth() + "\"");
		builder.append(" height=\"" + getHeight() + "\"");
		builder.append(" />\n");
		return builder.toString();
	}

	public String toString() {
		return String.format("Rectangle: (%d:%d) width=%d height=%d color=%s",
				x, y, width, height, c.getColorAsHex());
	}
}
