package com.zuehlke.smellyshapes;

public abstract class ComplexShape extends AbstractShape {

	protected boolean readOnly = false;

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}
}
