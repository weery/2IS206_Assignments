package part_2.assignment_4;

/**
 * Sort an array containing integers in ascending order
 * (arranged from smallest to largest) using the insertion sort algorithm.
 */
public class InsertionSort implements Sort {

	@Override
	public int[] sort(int[] unsorted) {
		int[] sorted = new int[unsorted.length];
		sorted[0] = unsorted[0];
		for(int i = 1; i < unsorted.length; i++){
			int j = i-1, current = unsorted[i];
			sorted[i] = current;
			while (sorted[j] > current){
				sorted[j+1] = sorted[j];
				sorted[j] = current;
				j--;
			}
		}
		return sorted;
	}	
}