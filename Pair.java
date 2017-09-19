package objects;

public class Pair {
	Point pointA; 
	Point pointB;
	double distance = 0.0;
	
	public Pair() {}
	
	public Pair(Point p, Point q) {
		pointA = p;
		pointB = q;
		distance = Math.sqrt((Math.pow(q.getX() - p.getX(), 2)) + (Math.pow(q.getY() - p.getY(), 2)));
	}
	
	public Point getPointA() {
		return pointA;
	}
	
	public Point getPointB() {
		return pointB;
	}
	
	public double getDistance() {
		return distance;
	}
	
	public String toString() {
		return String.format("%s - %s: %.2f ", pointA.toString(), pointB.toString(), distance);
	}
}
