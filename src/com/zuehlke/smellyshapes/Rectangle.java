package com.zuehlke.smellyshapes;

public class Rectangle implements Shape {

	protected Color c = new Color(Color.BLUE);
	private final Point point;
	int width;
	int height;

	public Rectangle(Point point, Dimension parameterObject) {
		this.point = point;
		this.width = parameterObject.getWidth();
		this.height = parameterObject.getHeight();
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public boolean contains(Point point) {
		boolean containsX = (this.point.getX() <= point.getX()) && (point.getX() <= this.point.getX() + width);
		boolean containsY = (this.point.getY() <= point.getY()) && (point.getY() <= this.point.getY() + height);
		return containsX && containsY;
	}

	public int calculate() {
		return width * height;
	}

	public int getX() {
		return point.getX();
	}

	public int getY() {
		return point.getY();
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
				point.getX(), point.getY(), width, height, c.getColorAsHex());
	}
}
