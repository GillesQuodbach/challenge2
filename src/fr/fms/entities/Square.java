package fr.fms.entities;

import java.awt.Graphics;

public class Square<T> extends Shape<T> {
	private double side;

	public Square(double side,T x, T y) {
		super(x, y);
		this.setSide(side);
	}
	
	public Square(double side,Point<T> center) {
		super(center);
		this.setSide(side);
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		if(side < 0)	this.side = 1;
		else this.side = side;
	}
	
	public double area() {
        return this.side * this.side;
	}
	
	public double perimeter() {
		return this.side * 4; 
	}

	@Override
	public String toString() {
		return "Square : side = " + side + " " + super.toString();
	}

	@Override
	public void draw(Graphics g) {
		g.drawRect((int)this.getCenter().getX(), (int)this.getCenter().getY(), (int)side, (int)side);		
	}
}
