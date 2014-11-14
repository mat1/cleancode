package com.zuehlke.smellyshapes;

import java.util.ArrayList;
import java.util.List;

public class Circle implements Shape {

	private Point center;
	private int radius;
	private Color color = new Color(Color.GREEN);

	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}

	public boolean contains(Point otherPoint) {
		return otherPoint.distanceTo(center) <= Math.abs(radius);
	}

	public int countContainingPoints(int[] xCords, int[] yCords) {
		List<Point> points = new ArrayList<>();
		for (int i = 0; i < xCords.length; ++i) {
			points.add(new Point(xCords[i], yCords[i]));
		}
		return countContainingPoints(points);
	}
	
	public int countContainingPoints(List<Point> points) {
		int numberOfContainingPoints = 0;
		for (Point point : points) {
			if (contains(point)) {
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
		builder.append(" x=\"" + center.getX() + "\"");
		builder.append(" y=\"" + center.getY() + "\"");
		builder.append(" radius=\"" + radius + "\"");
		builder.append(" />\n");
		return builder.toString();
	}

	public String toString() {
		return "Circle: (" + this.center.getX() + "," + this.center.getY() + ") radius= " + radius
				+ color.getColorAsRgb();
	}

}
