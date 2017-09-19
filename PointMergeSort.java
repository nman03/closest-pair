package pointSort;

import objects.Point;
import closestPair.Coordinate;

public class PointMergeSort {;

	public Point[] mergeSort(Point[] arr, Coordinate c) {
		Point[] tmp = new Point[arr.length];
		System.arraycopy(arr, 0, tmp, 0, arr.length);
		sort(tmp, 0, tmp.length - 1, c);

		return tmp;
	}

	public void sort(Point[] tmp, int l, int r, Coordinate c) {
		if (l >= r) {
			return;
		}
		
		int m = (l + r) / 2;

		sort(tmp, l, m, c);
		sort(tmp, m + 1, r, c);

		merge(tmp, l, m, r, c);		
	}
	
	public void merge(Point[] arr, int l, int m, int r, Coordinate c) {
		Point[] tmp = new Point[r - l + 1];

		int i = l;
		int j = m + 1;
		int k = 0;
		
		if (c== Coordinate.X) {
			while (i <= m && j <= r) {
				if (arr[i].getX() <= arr[j].getX()) {
					tmp[k] = arr[i++];
				}

				else {
					tmp[k] = arr[j++];
				}	
				k++;
			}
		}
		
		else if (c == Coordinate.Y) {
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
		} 
		
		else {
			while (j <= r) {
				tmp[k++] = arr[j++];
			}
		}	

		for (k = 0 ; k < tmp.length ; k++) {
			arr[k+l] = tmp[k]; 
		}
	}
}
