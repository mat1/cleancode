package com.zuehlke.smellyshapes;

public class ShapeGroup extends ComplexShape {
	
	private static final int INITIAL_SIZE = 10;
	private static final int GROWTH_SIZE = 10;
	
	Shape[] shapes = new Shape[INITIAL_SIZE];
	int size = 0;

	public ShapeGroup() {
	}

	public ShapeGroup(Shape[] shapes, boolean readOnly) {
		this.shapes = shapes;
		this.size = shapes.length;
		this.readOnly = readOnly;
	}

	// TODO long method, deeply nested control flow
	public void add(Shape shape) {
		if (!readOnly) {
			int newSize = size + 1;
			if (newSize > shapes.length) {
				Shape[] newShapes = new Shape[shapes.length + GROWTH_SIZE];
				for (int i = 0; i < size; i++) {
					newShapes[i] = shapes[i];
				}
				shapes = newShapes;
			}

			if (contains(shape)) {
				return;
			}
			shapes[size++] = shape;
		}
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
