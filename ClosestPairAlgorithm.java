package closestPair;

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
				if (arr[i].x <= arr[j].x) {
					tmp[k] = arr[i++];
				}

				else {
					tmp[k] = arr[j++];
				}	
				k++;
			}
		} else if (c == 'y') {
			while (i <= m && j <= r) {
				if (arr[i].y <= arr[j].y) {
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
			
			Pair p1 = new Pair(Px[0], Px[1]);
			Pair p2 = new Pair(Py[0], Py[1]);
			
			if (p1.distance < p2.distance) 
				return p1;
			else
				return p2;
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
			double delta = Math.min(pair1.distance, pair2.distance);
			Pair pair3 = ClosestSplitPair(Px, Py, delta);
			
			if (pair3 != null) {
				if (pair1.distance <= pair2.distance && pair1.distance <= pair3.distance) {
					return pair1;
				} else if (pair2.distance <= pair1.distance && pair2.distance <= pair3.distance) {
					return pair2;
				} else {
					return pair3;
				}
			} else {
				if (pair1.distance <= pair2.distance) {
					return pair1;
					
				} else {
					return pair2;	
				}
			}	
		}
		
	}
	
	public Pair ClosestSplitPair(Point[] Px, Point[] Py, double delta) {
		
		int x = (int) Px[Px.length / 2].x;
		
		ArrayList<Point> Sy = new ArrayList<>();
		for (int i = 0 ; i < Py.length ; i++) {
			if (Py[i].x >= x - delta && Py[i].x <= x + delta)
				Sy.add(Py[i]);
		}
		
		double best = delta;
		Pair bestPair = null;
		
		for (int i = 0 ; i < Sy.size() ; i++) {
			for (int j = i + 1 ; j < Sy.size() ; j++) {
				Pair p = new Pair(Sy.get(i), Sy.get(j));
				if (p.distance < best) {
					best = p.distance;
					bestPair = p;
				}
			}
		}
		
		return bestPair;
	}
	
	class Point {
		double x;
		double y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public String toString() {
			return String.format("(%.2f, %.2f)", x, y); 
		}
	}

	class Pair {
		Point point1; 
		Point point2;
		double distance = 0;
		
		public Pair() {
			
		}
		
		public Pair(Point p, Point q) {
			point1 = p;
			point2 = q;
			distance = getDistance(p, q);
		}
		
		public double getDistance(Point p1, Point p2) {
			return Math.sqrt((Math.pow(p2.x - p1.x, 2)) + (Math.pow(p2.y - p1.y, 2)));
		}
		
		public String toString() {
			return String.format("%s - %s: %.2f ", point1.toString(), point2.toString(), distance);
		}
	}
}
