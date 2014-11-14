package com.zuehlke.smellyshapes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ShapeGroup implements Shape {

	private boolean readOnly;

	private Set<Shape> shapes;
	int size;

	public ShapeGroup() {
		readOnly = false;
		shapes = new HashSet<>();
	}

	public ShapeGroup(Shape[] shapes, boolean readOnly) {
		this.shapes = new HashSet<>(Arrays.asList(shapes));
		this.size = shapes.length;
		this.readOnly = readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	public void add(Shape shape) {
		if (readOnly) {
			return;
		}
		addInternally(shape);
	}

	private void addInternally(Shape shape) {
		shapes.add(shape);
		size = shapes.size();
	}

	public boolean contains(Shape shape) {
		return shapes.contains(shape);
	}

	public boolean contains(int x, int y) {
		for (Shape shape : shapes) {
			if (shape.contains(x, y)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toXml() {
		StringBuilder builder = new StringBuilder();
		builder.append("<shapegroup>\n");
		for (Shape shape : shapes) {
			builder.append(shape.toXml());
		}
		builder.append("</shapegroup>\n");
		return builder.toString();
	}
}
