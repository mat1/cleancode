package com.zuehlke.smellyshapes;

public class ShapeGroup extends Shape {

	private static final int INITIAL_SIZE = 10;
	private static final int GROWTH_SIZE = 10;
	private boolean readOnly;

	Shape[] shapes = new Shape[INITIAL_SIZE];
	int size = 0;

	public ShapeGroup() {
		readOnly = false;
	}

	public ShapeGroup(Shape[] shapes, boolean readOnly) {
		this.shapes = shapes;
		this.size = shapes.length;
		this.readOnly = readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	public void add(Shape shape) {
		if (readOnly || contains(shape)) {
			return;
		}
		if (shouldGrow()) {
			grow();
		}
		addInternally(shape);
	}

	private boolean shouldGrow() {
		return size + 1 > shapes.length;
	}

	private void grow() {
		Shape[] newShapes = new Shape[shapes.length + GROWTH_SIZE];
		for (int i = 0; i < size; i++) {
			newShapes[i] = shapes[i];
		}
		shapes = newShapes;
	}

	private void addInternally(Shape shape) {
		shapes[size++] = shape;
	}

	public boolean contains(Shape shape) {
		for (int i = 0; i < size; i++) {
			if (shapes[i].equals(shape)) {
				return true;
			}
		}
		return false;
	}

	public boolean contains(int x, int y) {
		for (Shape shape : shapes) {
			if (shape != null) {
				if (shape.contains(x, y)) {
					return true;
				}
			}
		}
		return false;
	}
}
