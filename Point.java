package objects;

public class Point {
	private double x;
	private double y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public String toString() {
		return String.format("(%.2f, %.2f)", x, y); 
	}
}
