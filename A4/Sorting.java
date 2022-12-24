/*
THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR ONLINE SOURCES. David Chen
*/

import java.text.DecimalFormat;

public class Sorting {
	//-------------------------------------------------------------
	//---------- Below is an implementation of Bubble Sort --------
	//-------------------------------------------------------------
	public static void BubbleSort(long[] a) {
		int out, in;
		for(out = a.length-1; out > 0; out--) {
			boolean swapped = false;
			for(in = 0; in < out; in++) {
				if(a[in] > a[in+1]) {
					exch(a, in, in+1);
					swapped = true;
				}
			}
			if(!swapped) break;
		}
	}

	//------------------------------------------------------------------
	//---------- Below is an implementation of Insertion Sort ----------
	//------------------------------------------------------------------
	public static void InsertionSort(long[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && a[j] < a[j-1]; j--) {
                exch(a, j, j-1);
            }
        }
	}

	//-----------------------------------------------------------------
	// Implement Selection Sort below
	//-----------------------------------------------------------------
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

	//-----------------------------------------------------------------------
	//---------- Below is an implementation of recursive MergeSort ----------
	//-----------------------------------------------------------------------
	public static void MergeSort(long[] a) {
			long[] aux = new long[a.length];
			sort(a, aux, 0, a.length-1);
	}

	// mergesort a[lo..hi] using auxiliary array aux[lo..hi]
  private static void sort(long[] a, long[] aux, int lo, int hi) {
      if (hi <= lo) return;
      int mid = lo + (hi - lo) / 2;
      sort(a, aux, lo, mid);
      sort(a, aux, mid + 1, hi);
      merge(a, aux, lo, mid, hi);
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

	//-------------------------------------------------------------
	//---------- Below is an implementation of Quicksort ----------
	//-------------------------------------------------------------
	public static void QuickSort(long[] a) {
		QuickSort(a, 0, a.length-1);
	}

	private static void QuickSort(long[] a, int left, int right) {
		if(right - left <= 0)
			return;
		int pIdx = partition(a, left, right, right);	// always uses the right end element as pivot
		QuickSort(a, left, pIdx-1);
		QuickSort(a, pIdx+1, right);
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

	//-----------------------------------------------------------------------
	// Implement Optimized Quicksort below (see A5 handout for details)
	//-----------------------------------------------------------------------
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

	//---------------------------------------------------------------------------
	// Implement Non-Recursive MergeSort below (see A5 handout for details)
	//---------------------------------------------------------------------------
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

	private static void startTimer() {
		timestamp = System.nanoTime();
	}

	private static double endTimer() {
		return (System.nanoTime() - timestamp)/1000000.0;
	}

  // Exchange a[i] and a[j]
  private static void exch(long[] a, int i, int j) {
      long swap = a[i];
      a[i] = a[j];
      a[j] = swap;
  }

	private static long timestamp;

	//---------------------------------------------
	//---------- This is the main method ----------
	//---------------------------------------------
	public static void main(String[] args) {

		boolean useOrderedArray = false;

		// run experiments
		final int BUBBLE = 0, SELECT = 1, INSERT = 2, QUICK = 3, QUICKOPT = 4, MERGEREC = 5, MERGENONREC = 6;
		int[] algorithms = {BUBBLE, SELECT, INSERT, QUICK, QUICKOPT, MERGEREC, MERGENONREC};

		// max defines the maximum size of the array to be tested, which is 2^max
		// runs defines the number of rounds to be performed per test, in order to get an average running time.
		int max = 14, runs = 5;
		double[][] stats = new double[algorithms.length][max];
		for(int i=0; i < algorithms.length; i++) {  //loop through each sorting algorithm
			switch(i) {
				case BUBBLE: System.out.print("Running Bubble Sort ..."); break;
				case SELECT: System.out.print("Running Selection Sort ..."); break;
				case INSERT: System.out.print("Running Insertion Sort ..."); break;
				case QUICK: System.out.print("Running Quicksort..."); break;
				case QUICKOPT: System.out.print("Running Optimized Quicksort..."); break;
				case MERGEREC: System.out.print("Running MergeSort Recursive ..."); break;
				case MERGENONREC: System.out.print("Running MergeSort Non Recursive ..."); break;
			} //end of switch

			for(int j = 0; j < max; j++) { //loop through each array size
				double avg = 0;
				for(int k = 0; k < runs; k++) { //loop through each run
					int n = (int) Math.pow(2, j+1);
					long[] a;
					if (useOrderedArray) { a = SortHelper.orderedArray(n); }
					else { a = SortHelper.randArray(n); }

					startTimer();
					switch(i) {
						case BUBBLE: BubbleSort(a); break;
						case SELECT: SelectionSort(a); break;
						case INSERT: InsertionSort(a); break;
						case QUICK: QuickSort(a); break;
						case QUICKOPT: QuickSortOptimized(a); break;
						case MERGEREC: MergeSort(a); break;
						case MERGENONREC: MergeSortNonRec(a); break;
					}
					avg += endTimer();

					if (SortHelper.testSort(a) == false)
						System.out.println("The sorting is INCORRECT!" + "(N=" + a.length + ", round=" + k + ").");
				}//end of k runs
				avg /= runs;
				stats[i][j] = avg;
			}//end of max array sizes
			System.out.println("done.");
		}//done running all sorting algorithms!

		DecimalFormat format = new DecimalFormat("0.0000");
		System.out.println();
		System.out.println("Average running time:");
	  System.out.println("N\t BubbleSort\tSelectionSort\tInsertionSort\tQuickSort\tQuickSortOpt\tMergeSortRec\tMergeSortNonRec");
		for(int i=0; i<stats[0].length; i++) {
			System.out.print((int) Math.pow(2, i+1) + "\t  ");
			for(int j=0; j<stats.length; j++) {
				System.out.print(format.format(stats[j][i]) + "\t  ");
			}
			System.out.println();
		}
	}//end of main method

}//end of class
