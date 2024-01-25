package fr.fms.job;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import fr.fms.entities.Shape;
import fr.fms.entities.Square;

public class IJobImpl<T> implements IJob<T> {
	private Map<Integer, Shape<T>> shapes;
	
	public IJobImpl() {
		shapes = new HashMap<>();
	}

	@Override
	public void addShape(int id, Shape<T> shape) {
		shapes.put(id, shape);
	}

	@Override
	public void deleteShape(int id) {
		shapes.remove(id);		
	}

	@Override
	public Shape<T> getShapeById(int id) {
		return shapes.get(id);
	}

	@Override
	public void moveShape(int id, T x, T y) {
		Shape<T> shape = shapes.get(id);
		shape.getCenter().setX(x);
		shape.getCenter().setY(y);
	}

	@Override
	public void drawShapes(Graphics g) {
		for(Shape<T> s : shapes.values()) {
			s.draw(g);
		}
	}

	@Override
	public void displayAll() {
		for(Shape<T> s : shapes.values()) {
			System.out.println(s);
		}		
	}
	
	public void squaresPerimeter() {
		Iterator<Shape<T>> it = shapes.values().iterator();
		while(it.hasNext()) {
			Shape<T> shape = it.next();
			if(shape instanceof Square) {
				System.out.println(shape + " périmètre = " + ((Square<T>)shape).perimeter());
			}
		}
	}
	
	public void calcAreas() {
		Iterator<Shape<T>> it = shapes.values().iterator();
		while(it.hasNext()) {
			Shape<T> shape = it.next();
			System.out.println(shape + " area = " + shape.area());			
		}
	}
}
