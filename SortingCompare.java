import java.util.*;

public class SortingCompare {
	private static int selectCount = 0;
	private static int bubbleCount = 0;
	private static int mergeCount = 0;
	private static int quickCount = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortingCompare sorting = new SortingCompare();
		Random rand = new Random();
		int[] values = new int[1000];
		for( int index = 0;index < values.length; index++) {
			int randVal = rand.nextInt(1000);
			values[index] = randVal;
		}
		System.out.println("Welcome to the Sorting Comparison program.");
		System.out.println("This is the randomly generated Array.");
		System.out.print(Arrays.toString(values));
		System.out.println();
		System.out.println("Sorting the array through Selection Sort.");
		sorting.selectionSort(values);
		for(int i : values) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("Sort Count: " + selectCount);
		System.out.println("Sorting the array through Bubble Sort.");
		sorting.bubbleSort(values);
		for( int i : values) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("Sort Count: " + bubbleCount);
		System.out.println("Sorting the array through Merge Sort.");
		sorting.mergeSort(values);
		for( int i : values) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("Sort Count: ");
		/* sorting.mergeSort(a);
	
		System.out.println();
		int[] d = { 99, 17, 42, 1};
		sorting.quickSort(d, left, right);
		for(int i : d) {
			System.out.print(i);
			System.out.print(" "); */
		
		}	
	public static int[] selectionSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int smallIndex = i;
			for (int j = i; j < a.length; j++) {
				if (a[j] < a[smallIndex]) {
					smallIndex = j;
				}
			}
			if (smallIndex != i) {
				int temp = a[i];
				a[i] = a[smallIndex];
				a[smallIndex] = temp;
				selectCount++;
			}
		}
		return a;
	}

	public static int[] bubbleSort(int[] a) {
		boolean hasSwapped = true;
		while (hasSwapped == true) {
			hasSwapped = false;
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] > a[i + 1]) {
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
					hasSwapped = true;
					
				}
				bubbleCount++;
			}
		}
		return a;
	}

	public static void mergeSort(int[] a) {
		int size = a.length;
		if (size < 2)
			return;
		int mid = size / 2;
		int leftSize = mid;
		int rightSize = size - mid;
		int[] left = new int[leftSize];
		int[] right = new int[rightSize];
		for (int i = 0; i < mid; i++) {
			left[i] = a[i];
		}
		for (int i = mid; i < size; i++) {
			right[i - mid] = a[i];
		}
		mergeSort(left);
		mergeSort(right);
		merge(left, right, a);
	}
	public static int countInversions(int[] a) {
		return ;
	}

	private static void merge(int[] left, int[] right, int[] a) {
		int merge = 0;
		int leftSize = left.length;
		int rightSize = right.length;
		int i = 0; // left array index
		int j = 0; // right array index
		int k = 0; // sorted array index
		while (i < leftSize && j < rightSize) {
			if (left[i] <= right[j]) { // check if left value is smaller than
										// right value
				a[k] = left[i];
				i++;
				k++;
			} else { // the right value is smaller than the left
				a[k] = right[j];
				j++;
				k++;
			}
		}
		while (i < leftSize) { // values left over
			a[k] = left[i];
			i++;
			k++;
		}
		while (j < rightSize) { // values left over
			a[k] = right[j];
			j++;
			k++;

		}
	}

	public static int[] quickSort(int[] a, int left, int right) {
		int index = partition(a, left, right);
		if (left < index - 1)
			quickSort(a, left, index - 1);
		if (index < right)
			quickSort(a, index, right);
		return a;
	}

	private static int partition(int[] a, int left, int right) {
		int i = left;
		int j = right;
		int pivot = a[(left + right) / 2];
		while (i <= j) {
			while (a[i] < pivot)
				i++;
			while (a[j] > pivot)
				j--;
			if (i <= j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = a[temp];
				i++;
				j--;
			}
		}
		return i;
	}
}
