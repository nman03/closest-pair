package closestPair;

import java.util.ArrayList;
import objects.Pair;
import objects.Point;
import pointSort.PointMergeSort;

public class ClosestPairAlgorithm {
	
	public Pair bruteForce(Point[] array) {
		Pair best = new Pair(array[0], array[1]);

		for (int i = 0 ; i < array.length ; i++) {
			for (int j = i + 1 ; j < array.length ; j++) {
				Pair tmp = new Pair(array[i], array[j]);
				if (tmp.getDistance() < best.getDistance()) {
					best = tmp;
				}
			}
		}
		
		return best;
	}
	
	public Pair closestPair(Point[] array) {
		PointMergeSort sort = new PointMergeSort();
		
		Point[] sortedByX = sort.mergeSort(array, Coordinate.X);
		Point[] sortedByY = sort.mergeSort(array, Coordinate.Y);
		
		return closestPair(sortedByX, sortedByY);
	}

	public Pair closestPair(Point[] pX, Point[] pY) {
		int m = pX.length;

		if (m <= 3) {

			Pair p1 = bruteForce(pX);
			Pair p2 = bruteForce(pY);

			if (p1.getDistance() < p2.getDistance()) 
				return p1;
			else
				return p2;
		}

		else {
			
			int n = m / 2;
			
			Point[] qX = new Point[n];
			Point[] qY = new Point[n];
			Point[] rX = new Point[n];
			Point[] rY = new Point[n];

			System.arraycopy(pX, 0, qX, 0, n);
			System.arraycopy(pY, 0, qY, 0, n);
			System.arraycopy(pX, n, rX, 0, n);
			System.arraycopy(pY, n, rY, 0, n);

			Pair pair1 = closestPair(qX, qY);
			Pair pair2 = closestPair(rX, rY);
			double delta = Math.min(pair1.getDistance(), pair2.getDistance());
			Pair pair3 = ClosestSplitPair(pX, pY, delta);

			if (pair3 != null) {
				if (pair1.getDistance() <= pair2.getDistance() && pair1.getDistance() <= pair3.getDistance()) {
					return pair1;
				} else if (pair2.getDistance() <= pair1.getDistance() && pair2.getDistance() <= pair3.getDistance()) {
					return pair2;
				} else {
					return pair3;
				}
			} else {
				if (pair1.getDistance() <= pair2.getDistance()) {
					return pair1;

				} else {
					return pair2;	
				}
			}	
		}
	}

	public Pair ClosestSplitPair(Point[] Px, Point[] Py, double delta) {
		int x = (int) Px[Px.length / 2].getX();

		ArrayList<Point> Sy = new ArrayList<>();
		for (int i = 0 ; i < Py.length ; i++) {
			if (Py[i].getX() >= x - delta && Py[i].getX() <= x + delta)
				Sy.add(Py[i]);
		}

		double best = delta;
		Pair bestPair = null;

		for (int i = 0 ; i < Sy.size() ; i++) {
			for (int j = i + 1 ; j < Sy.size() ; j++) {
				Pair p = new Pair(Sy.get(i), Sy.get(j));
				if (p.getDistance() < best) {
					best = p.getDistance();
					bestPair = p;
				}
			}
		}

		return bestPair;
	}
}
