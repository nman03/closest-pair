package closestPair;

import java.awt.Point;
import java.util.ArrayList;

public class ClosestPairAlgorithm {

	public Point[] mergeSort(Point[] arr, char c) {
		Point[] tmp = new Point[arr.length];
		System.arraycopy(arr, 0, tmp, 0, arr.length);
		sort(tmp, 0, tmp.length - 1, c);

		return tmp;
	}


	public void sort(Point[] tmp, int l, int r, char c) {
		if (l >= r) {
			return;
		}
		
		int m = (l + r) / 2;

		sort(tmp, l, m, c);
		sort(tmp, m + 1, r, c);

		merge(tmp, l, m, r, c);		
	}
	
	public void merge(Point[] arr, int l, int m, int r, char c) {
		Point[] tmp = new Point[r - l + 1];

		int i = l;
		int j = m + 1;
		int k = 0;
		
		if (c == 'x') {
			while (i <= m && j <= r) {
				if (arr[i].getX() <= arr[j].getX()) {
					tmp[k] = arr[i++];
				}

				else {
					tmp[k] = arr[j++];
				}	
				k++;
			}
		} else if (c == 'y') {
			while (i <= m && j <= r) {
				if (arr[i].getY() <= arr[j].getY()) {
					tmp[k] = arr[i++];
				}

				else {
					tmp[k] = arr[j++];
				}	
				k++;
			}	
		}
			
		if (i <= m && j > r) {

			while (i <= m)  {
				tmp[k++] = arr[i++];
			}

		} else {

			while (j <= r) {
				tmp[k++] = arr[j++];
			}

		}	

		for (k = 0 ; k < tmp.length ; k++) {
			arr[k+l] = tmp[k]; 
		}
	}
	
	public Pair ClosestPair(Point[] Px, Point[] Py) {
		int m = Px.length;

		if (m == 2) {
			return new Pair(Px[0], Px[1]);
		}
		
		else {
			
			int n = Px.length / 2;
			Point[] Qx = new Point[n];
			Point[] Qy = new Point[n];
			Point[] Rx = new Point[n];
			Point[] Ry = new Point[n];
				
			System.arraycopy(Px, 0, Qx, 0, n);
			System.arraycopy(Py, 0, Qy, 0, n);
			System.arraycopy(Px, n, Rx, 0, n);
			System.arraycopy(Py, n, Ry, 0, n);
			
			Pair pair1 = ClosestPair(Qx, Qy);
			Pair pair2 = ClosestPair(Rx, Ry);
			double delta = Math.min(pair1.d, pair2.d);
			Pair pair3 = ClosestSplitPair(Px, Py, delta);
			
			if (pair3 != null) {
				if (pair1.d <= pair2.d && pair1.d <= pair3.d) {
					return pair1;
				} else if (pair2.d <= pair1.d && pair2.d <= pair3.d) {
					return pair2;
				} else {
					return pair3;
				}
			} else {
				if (pair1.d <= pair2.d) {
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
			if (Py[i].getX() > x - delta && Py[i].getX() < x + delta)
				Sy.add(Py[i]);
		}
		
		double best = delta;
		Pair bestPair = null;
		
		for (int i = 0 ; i < Sy.size() - 6 ; i++) {
			for (int j = 0 ; j < 7 ; j++) {
				Pair p = new Pair(Sy.get(i), Sy.get(j));
				if (p.d < best) {
					best = p.d;
					bestPair = p;
				}
			}
		}
		
		return bestPair;
	}

	class Pair {
		Point p; 
		Point q;
		double d;
		
		public Pair() {
			
		}
		
		public Pair(Point p, Point q) {
			this.p = p;
			this.q = q;
			this.d = p.distance(q);
		}
	}
}
