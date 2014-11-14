package com.zuehlke.smellyshapes;

public class DrawingBoard {

	private Color backgroundColor;
	private ShapeGroup shapeGroup;
	
	public DrawingBoard() {
		shapeGroup = new ShapeGroup();
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public void drawOnScreen() {
		// ... removed for exercise
	}

	public void load(String file) {
		// ... removed for exercise
	}

	public static void main(String[] args) {
		DrawingBoard drawingBoard = new DrawingBoard();
		drawingBoard.setBackgroundColor(new Color("Green"));
		drawingBoard.add(new Square(new Point(-10, -10), 20));
		drawingBoard.load(args[0]);
		drawingBoard.drawOnScreen();
	}

	private void add(Shape shape) {
		shapeGroup.add(shape);
	}
}
