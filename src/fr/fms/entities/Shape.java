package fr.fms.entities;

import java.awt.Graphics;

public abstract class Shape<T> {
	private Point<T> center;
	
	public Shape(T x, T y) {
		this.center = new Point<T>(x,y);
	}
	
	public Shape(Point<T> center) {
		this.center = new Point<T>(center.getX(),center.getY());
	}
	
	public abstract double area();
	
	public Point<T> getCenter() {
		return center;
	}

	public void setCenter(Point<T> center) {
		this.center = center;
	}
	
	public abstract void draw(Graphics g);

	@Override
	public String toString() {
		return "Shape [center = " + center + "]";
	}
}
