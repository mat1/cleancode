package com.zuehlke.smellyshapes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ShapeGroup implements Shape {

	private boolean readOnly;

	private Set<Shape> shapes;

	public ShapeGroup() {
		readOnly = false;
		shapes = new HashSet<>();
	}

	public ShapeGroup(Shape[] shapes, boolean readOnly) {
		this.shapes = new HashSet<>(Arrays.asList(shapes));
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
	}

	public boolean containsShape(Shape shape) {
		return shapes.contains(shape);
	}

	public boolean contains(Point point) {
		for (Shape shape : shapes) {
			if (shape.contains(point)) {
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

	int getSize() {
		return shapes.size();
	}
}
