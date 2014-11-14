package com.zuehlke.smellyshapes;

public class Circle implements Shape {

	Point point;
	private int radius;
	private Color color = new Color(Color.GREEN);

	public Circle(Point point, int radius) {
		this.point = point;
		this.radius = radius;
	}

	public boolean contains(Point otherPoint) {
		int deltaX = otherPoint.getDeltaX(point);
		int deltaY = otherPoint.getDeltaY(point);
		return deltaX * deltaX + deltaY * deltaY <= radius * radius;
	}

	public int countContainingPoints(int[] xCords, int[] yCords) {
		int numberOfContainingPoints = 0;
		for (int i = 0; i < xCords.length; ++i) {
			if (contains(new Point(xCords[i], yCords[i]))) {
				numberOfContainingPoints++;
			}
		}
		return numberOfContainingPoints;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public String toXml() {
		StringBuilder builder = new StringBuilder();
		builder.append("<circle");
		builder.append(" x=\"" + point.getX() + "\"");
		builder.append(" y=\"" + point.getY() + "\"");
		builder.append(" radius=\"" + radius + "\"");
		builder.append(" />\n");
		return builder.toString();
	}

	public String toString() {
		return "Circle: (" + this.point.getX() + "," + this.point.getY() + ") radius= " + radius
				+ color.getColorAsRgb();
	}

}
