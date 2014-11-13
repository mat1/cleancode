package com.zuehlke.smellyshapes;

public class Rectangle extends Shape {

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

	public String toString() {
		return String.format("Rectangle: (%d:%d) width=%d height=%d color=%s",
				x, y, width, height, c.getColorAsHex());
	}
}
