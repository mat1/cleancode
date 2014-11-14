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
	
	public int distanceTo(Point point) {
		int deltaX = x - point.x;
		int deltaY = y - point.y;
		return Math.abs(deltaX) + Math.abs(deltaY);
	}
	
}