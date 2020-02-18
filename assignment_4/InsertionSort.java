package assignment_4;

/**
 * Sort an array containing integers in ascending order
 * (arranged from smallest to largest) using the insertion sort algorithm.
 */
public class InsertionSort implements Sort {

	@Override
	public int[] sort(int[] unsorted) {
		for(int i = 1; i < unsorted.length; i++){
			int j = i-1, current = unsorted[i];
			while (j > 0 && unsorted[j] > current){
				unsorted[j+1] = unsorted[j];
				unsorted[j] = current;
				j--;
			}
		}
		return unsorted;
	}	
}