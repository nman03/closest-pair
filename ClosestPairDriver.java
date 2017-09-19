package closestPair;

import objects.Pair;
import objects.Point;

public class ClosestPairDriver {
	
	public static void main(String[] args) {
		ClosestPairAlgorithm cp = new ClosestPairAlgorithm();
		
		Point p1 = new Point(1, 6);
		Point p2 = new Point(15, 7);
		Point p3 = new Point(6, 1);
		Point p4 = new Point(7, 15);
		Point p5 = new Point(5, 8);
		Point p6 = new Point(8, 5);
		Point p7 = new Point(0, 0);
			
		Point[] arr = {p1, p2, p3, p4, p5, p6, p7};
		Pair a = cp.closestPair(arr);
		
		// All possible Pairs (for testing)
//		System.out.println(new Pair(p1, p2).toString());
//		System.out.println(new Pair(p1, p3).toString());
//		System.out.println(new Pair(p1, p4).toString());
//		System.out.println(new Pair(p1, p5).toString());
//		System.out.println(new Pair(p1, p6).toString());
//		System.out.println(new Pair(p1, p7).toString());
//		System.out.println(new Pair(p2, p3).toString());
//		System.out.println(new Pair(p2, p4).toString());
//		System.out.println(new Pair(p2, p5).toString());
//		System.out.println(new Pair(p2, p6).toString());
//		System.out.println(new Pair(p2, p7).toString());
//		System.out.println(new Pair(p3, p4).toString());
//		System.out.println(new Pair(p3, p5).toString());
//		System.out.println(new Pair(p3, p6).toString());
//		System.out.println(new Pair(p3, p7).toString());
//		System.out.println(new Pair(p4, p5).toString());
//		System.out.println(new Pair(p4, p6).toString());
//		System.out.println(new Pair(p4, p7).toString());
//		System.out.println(new Pair(p5, p6).toString());
//		System.out.println(new Pair(p5, p7).toString());
//		System.out.println(new Pair(p6, p7).toString());

		dispArray(arr);
		System.out.println("The closest pair of Points: " + a.toString());
	}

	public static void dispArray(Point[] array) {
		System.out.print("Points: {");
		for (int i = 0 ; i < array.length ; i++) {
			if (i == array.length - 1)
				System.out.print(array[i] + "}");
			else 
				System.out.print(array[i] + ", ");
		}
		System.out.println();
	}
}
