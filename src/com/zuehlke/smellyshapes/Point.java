package com.zuehlke.smellyshapes;

public class Point {
	private final int x;
	private final int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getDeltaX(Point point) {
		return x - point.x;
	}
	
	public int getDeltaY(Point point) {
		return y - point.y;
	}
}