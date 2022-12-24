import java.util.Arrays;
import java.util.Random;

public class Test {

	// This creates an array with n randomly generated elements between (0, n*10]
	public static long[] randArray(int n) {
		long[] rand = new long[n];
		for(int i=0; i<n; i++)
			rand[i] = (int) (Math.random() * n * 10);
		return rand;
	}

	// This tests whether your sorted result is correct by comparing it to reference result
	public static boolean testSort(long[] a) {
		long[] a2 = new long[a.length];
		System.arraycopy(a, 0, a2, 0, a.length);
		Arrays.sort(a);
		for(int i = 0; i < a.length; i++)
			if(a2[i] != a[i])
				return false;
		return true;
	}

	// This creates an ordered array with n elements in ascending order
	public static long[] orderedArray(int n) {
		long[] arr = new long[n];
		for(int i=0; i<n; i++)
			arr[i] = i+1;
		return arr;
	}

	public static void printArray(long[] arr) {
		System.out.print("[");
		for (long l : arr) {
			System.out.print(l + ", ");
		}
		System.out.println("]");
	}

	public static void SelectionSort(long[] a) {
		// create two variables to keep track of the min element on the right
		int minIndex;
		long min;

		// traverse through the array
		for (int i = 0; i < a.length - 1; i++) {
			// set a[i] be the min element
			minIndex = i;
			min = a[i];

			// traverse through the subarray to the right of a[i]
			for (int j = i + 1; j < a.length; j++) {
				// update the min element if an element smaller than current min is found
				if (a[j] < min) {
					minIndex = j;
					min = a[j];
				}
			}

			// swap a[i] with the min element
			exch(a, i, minIndex);
		}
	}

	public static void shuffle(long[] a) {
		// create a copy of "a"
		long[] copy = new long[a.length];
		for (int i = 0; i < copy.length; i++) {
			copy[i] = a[i];
		}

		// create three variables to store
		// 		1. the number of elements in remaining in "copy"
		// 		2. the randomly chosen index
		// 		3. the chosen element's new index in "a"
		int numElements = a.length, indexOld = 0, indexNew = 0;

		while (numElements > 0) {
			// randomly choose an index; possible range goes from 0 to numElement - 1
			indexOld = (int) (Math.random() * numElements);

			// put the chosen element back to "a" at indexNew; increment indexNew
			a[indexNew++] = copy[indexOld];

			// swap indexOld with the last element in "copy"
			// then decrement numElement so that the chosen element cannot be chosen again
			exch(copy, indexOld, --numElements);
		}
	}

	private static void exch(long[] a, int i, int j) {
      long swap = a[i];
      a[i] = a[j];
      a[j] = swap;
    }

	private static void print(long[] a) {
  		int count = 0;
  		for (long l : a) {
  			System.out.print(l + " ");
  			count++;
  			if (count == 15) {
  				System.out.println();
  				count = 0;
  			}
  		}
  		System.out.println();
  	}

  	public static void MergeSortNonRec(long[] a) {
		// Note: You can assume that the size of the array is a power of 2
		
		// create a new auxiliary array for merging
		long[] aux = new long[a.length];

		// create 4 variables to keep track of
		// 		1. the length of each subarray in every round of Merge Sort
		// 		2. the low, mid, and high index of each subarray
		int length, low, mid, high;

		// merge subarrays of length 2, 4, ..., a.length
		for (length = 2; length <= a.length; length *= 2) {

			// start at 0
			low = 0;

			// keep merging subarrays until low reaches the end of "a"
			while (low < a.length) {
				high = low + length - 1;
				mid = low + (high - low) / 2;
				merge(a, aux, low, mid, high);
				low += length;
			}
		}
	}

	private static void merge(long[] a, long[] aux, int lo, int mid, int hi) {
      // copy to aux[]
      for (int k = lo; k <= hi; k++) {
          aux[k] = a[k];
      }
      // merge back to a[]
      int i = lo, j = mid+1;
      for (int k = lo; k <= hi; k++) {
          if      (i > mid)           a[k] = aux[j++];
          else if (j > hi)            a[k] = aux[i++];
          else if (aux[j] < aux[i]) 	a[k] = aux[j++];
          else                        a[k] = aux[i++];
      }
    }

    public static void QuickSortOptimized(long[] a) {
		// shuffle the array and then call QuickSortOptimized()
		shuffle(a);
		QuickSortOptimized(a, 0, a.length - 1);
	}

	private static void QuickSortOptimized(long[] a, int left, int right) {
		// CORNER CASE 1: when the left pointer converges with the right pointer
		if (right <= left) {
			return;
		} // CORNER CASE 2: when the subarray contains no more than 10 elements
		else if (right < left + 10) {
			// perform an insertion sort instead
			int currentIndex;
			for (int i = left; i <= right; i++) {
				currentIndex = i;
				while (currentIndex > left && a[currentIndex] < a[currentIndex - 1]) {
					exch(a, currentIndex, --currentIndex);
				}
			}
			return;
		} // NORMAL CASE: perform the standard Quick Sort Algorithm
		else {
			// partition the array and get the pivot index
			int pivotIndex = partition(a, left, right, right);

			// sort the subarray to the left of pivot
			QuickSortOptimized(a, left, pivotIndex - 1);

			// sort the subarray to the right of pivot
			QuickSortOptimized(a, pivotIndex + 1, right);
		}
	}

	private static int partition(long[] a, int left, int right, int pIdx) {
		long pivot = a[pIdx];
		exch(a, pIdx, right);
		int storeIndex = left;
		for(int i=left; i<right; i++) {
			if(a[i] <= pivot)
				exch(a, i, storeIndex++);
		}
		exch(a, right, storeIndex);
		return storeIndex;
	}


	public static void main(String[] args) {
		// Testing Shuffle()
		long[] arr = orderedArray(1000);
		print(arr);
		shuffle(arr);
		print(arr);
	
		// Testing SelectionSort()
		long[] myArr = randArray(16);
		long[] myArrCopy = new long[myArr.length];
		for (int i = 0; i < myArr.length; i++) {
			myArrCopy[i] = myArr[i];
		}
		System.out.println("The initial array:");
		printArray(myArr);

		System.out.println("The array sorted by java's built-in method:");
		Arrays.sort(myArrCopy);
		printArray(myArrCopy);

		System.out.println("The array sorted by my SelectionSort():");
		SelectionSort(myArr);
		printArray(myArr);

		System.out.println("Does my sort pass the testSort()? " + testSort(myArr));

		// Testing QuickSort
		long[] myArr1 = randArray((int) Math.pow(2, 20));
		long[] myArr1Copy1 = new long[myArr1.length];
		for (int i = 0; i < myArr1.length; i++) {
			myArr1Copy1[i] = myArr1[i];
		}
		System.out.println("The initial array:");
		// printArray(myArr1);

		System.out.println("The array sorted by java's built-in method:");
		Arrays.sort(myArr1Copy1);
		// printArray(myArr1Copy1);

		System.out.println("The array sorted by my QuickSortOptimized():");
		QuickSortOptimized(myArr1);
		// printArray(myArr1);


		System.out.println("Does my sort pass the testSort()? " + testSort(myArr1));


		// Testing MergeSort
		long[] myArr2 = randArray((int) Math.pow(2, 20));
		long[] myArr2Copy = new long[myArr2.length];
		for (int i = 0; i < myArr2.length; i++) {
			myArr2Copy[i] = myArr2[i];
		}
		System.out.println("The initial array:");
		// printArray(myArr2);

		System.out.println("The array sorted by java's built-in method:");
		Arrays.sort(myArr2Copy);
		// printArray(myArr2Copy);

		System.out.println("The array sorted by my MergeSortNonRec():");
		MergeSortNonRec(myArr2);
		// printArray(myArr2);

		System.out.println("Does my sort pass the testSort()? " + testSort(myArr2));

	}


}