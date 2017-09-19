package closestPair;
import closestPair.ClosestPairAlgorithm.Pair;
import closestPair.ClosestPairAlgorithm.Point;

public class ClosestPairDriver {
	
	public static void main(String[] args) {
		ClosestPairAlgorithm cp = new ClosestPairAlgorithm();
		
		Point p1 = cp.new Point(1, 5);
		Point p2 = cp.new Point(8, 4);
		Point p3 = cp.new Point(4, 3);
		Point p4 = cp.new Point(5, 6);
		
		
		Point[] arr = {p1, p2, p3, p4};
		
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
		
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(c.toString());
		System.out.println(d.toString());
		System.out.println(e.toString());
		System.out.println(f.toString());
		System.out.println(g.toString());	
	}

	public static void dispArray(Point[] array) {
		for (int i = 0 ; i < array.length ; i++) {
			System.out.print(array[i].toString() + " ");
		}
		System.out.println();
	}
}
