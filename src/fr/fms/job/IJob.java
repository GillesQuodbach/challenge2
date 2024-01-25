package fr.fms.job;

import java.awt.Graphics;

import fr.fms.entities.Shape;

public interface IJob<T> {
	public void addShape(int id, Shape<T> shape);
	public void deleteShape(int id);
	public Shape<T> getShapeById(int id);
	public void moveShape(int id, T x, T y);
	public void drawShapes(Graphics g);	
	public void displayAll();
}
