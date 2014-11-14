package com.zuehlke.smellyshapes;

public interface Shape {
	
	String toXml();
	boolean contains(Point point);
}
