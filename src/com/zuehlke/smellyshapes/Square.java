package com.zuehlke.smellyshapes;

public class Square extends Rectangle {

	public Square(Point point, int edgeLength) {
		super(point, new Dimension(edgeLength, edgeLength));
	}

	public Square(Point point, int edgeLength, Color color) {
		super(point, new Dimension(edgeLength, edgeLength));
		this.c = color;
	}

	// FIXME LSP
	public int getHeight() throws RuntimeException {
		throw new RuntimeException(
				"Square does not have a height, only edgeLength");
	}

	public String toString() {
		return String.format("Square: (%d:%d) edgeLength=%d color=%s", getX(),
				getY(), getWidth(), c.getColorAsHex());
	}

	public boolean contains(Point point1, Point point2) {
		return contains(point1) && contains(point2);
	}
	
	@Override
	public String toXml() {
		StringBuilder builder = new StringBuilder();
		builder.append("<square");
		builder.append(" x=\"" + getX() + "\"");
		builder.append(" y=\"" + getY() + "\"");
		builder.append(" edgeLength=\"" + getWidth() + "\"");
		builder.append(" />\n");
		return builder.toString();
	}
	
}
