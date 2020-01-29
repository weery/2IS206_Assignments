package part_2.assignment_4;

/**
 * Sort an array containing integers in ascending order
 * (arranged from smallest to largest) using the Drake sort algorithm.
 */
public class DrakeSort implements Sort {

	/**
	 * Find the maximum element in a list
	 * @param list - input list to find the max value from
	 * @return The maximum element in the list
	 */
	private int findMax(int[] list){
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < list.length; i++){
			if (list[i] > max){
				max = list[i];
			}
		}
		return max;
	}

	@Override
	public int[] sort(int[] unsorted) {
		int max = findMax(unsorted);

		int[] drakeList = new int[max+1];
		for (int i = 0; i < unsorted.length; i++){
			drakeList[unsorted[i]]++;
		}
		int sortedListIndex = 0;
		for (int i = 0; i < drakeList.length; i++){
			while (drakeList[i] > 0){
				unsorted[sortedListIndex++] = i;
				drakeList[i]--;
			}
		}
		return unsorted;
	}
}