package closestPair;

import java.awt.Point;

import closestPair.ClosestPairAlgorithm.Pair;

public class ClosestPairDriver {
	
	public static void main(String[] args) {
		
		Point p1 = new Point(2, 3);
		Point p2 = new Point(12, 3);
		Point p3 = new Point(4, 5);
		Point p4 = new Point(5, 1);
		
		
		Point[] arr = {p1, p2, p3, p4};
		
		ClosestPairAlgorithm cp = new ClosestPairAlgorithm();
		Point[] Px = cp.mergeSort(arr, 'x');
		Point[] Py = cp.mergeSort(arr, 'y');
		
		Pair a = cp.ClosestPair(Px, Py);
		
		
		dispArray(Px);
		dispArray(Py);
		
		
		
		Pair b = cp.new Pair(p1, p2);
		Pair c = cp.new Pair(p1, p3);
		Pair d = cp.new Pair(p1, p4);
		Pair e = cp.new Pair(p2, p3);
		Pair f = cp.new Pair(p2, p4);
		Pair g = cp.new Pair(p3, p4);
		
		printPair(a);
		printPair(b);
		printPair(c);
		printPair(d);
		printPair(e);
		printPair(f);
		printPair(g);
		
		
	}

	public static void dispArray(Point[] array) {
		for (int i = 0 ; i < array.length ; i++) {
			System.out.print("(" + array[i].x +", " + array[i].y + ") ");
		}
		System.out.println();
	}
	
	public static void printPair(Pair a) {
		System.out.println("(" + a.p.x +", " +a.p.y + ") " + "(" +a.q.x +", " + a.q.y + ") " + a.d);
	}
}
