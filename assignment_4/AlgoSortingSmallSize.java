package assignment_4;

import java.util.Arrays;

import util.NumberCreator;
/**
 * AlgoSortingSmallSize invokes sorting algorithms with small sized data structures.
 */
public class AlgoSortingSmallSize {
	/**
	 * Program entry point. Invokes sorting algorithms with small sized 
	 * data structures.
	 * @param args not used.
	 */
	public static void main(String[] args) {
		Sort sortingAlgorithm = null;
		int[] dataStructure;
		int[] key;
		int[] sortedDataStructure;
		int[] numberOfElements;
								
		/* 
		 * Testing Insertion sort on different number of elements and checks 
		 * if the result is correct. 
		 */		
		numberOfElements = new int[] {4000, 8000, 12000, 16000, 20000};
		//numberOfElements = new int[] {20};
		sortingAlgorithm = new InsertionSort();
		
		for(int i = 0; i < numberOfElements.length; i ++) {			
			dataStructure = NumberCreator.createNumberArrayInt(numberOfElements[i]);
			for (int j = 0; j < numberOfElements[i]; j++){
				System.out.print(dataStructure[j] + " ");
			}
			System.out.println();
			key = Arrays.copyOf(dataStructure, dataStructure.length);
			sortedDataStructure = sortingAlgorithm.sort(dataStructure);
			for (int j = 0; j < numberOfElements[i]; j++){
				System.out.print(sortedDataStructure[j] + " ");
			}
			System.out.println();
			Arrays.sort(key);
								
			System.out.println("Sorting " + numberOfElements[i] + " elements using Insertion sort. Correct: " + Arrays.equals(key, sortedDataStructure));
		}
		
		/* 
		 * Testing Drake sort on different number of elements and checks 
		 * if the result is correct. 
		 */		
		numberOfElements = new int[] {4000, 8000, 12000, 16000, 20000};
		sortingAlgorithm = new DrakeSort();
		
		for(int i = 0; i < numberOfElements.length; i ++) {			
			dataStructure = NumberCreator.createNumberArrayInt(numberOfElements[i]);
			key = Arrays.copyOf(dataStructure, dataStructure.length);
			sortedDataStructure = sortingAlgorithm.sort(dataStructure);			
			Arrays.sort(key);
			for (int j = 0; j < numberOfElements[i]; j++){
				System.out.print(sortedDataStructure[j] + " ");
			}
			System.out.println();
								
			System.out.println("Sorting " + numberOfElements[i] + " elements using Drake sort. Correct: " + Arrays.equals(key, sortedDataStructure));
		}
		
		/* 
		 * Testing Quick sort on different number of elements and checks 
		 * if the result is correct. 
		 */		
		numberOfElements = new int[] {4000, 8000, 12000, 16000, 20000};
		sortingAlgorithm = new QuickSort();
		
		for(int i = 0; i < numberOfElements.length; i ++) {			
			dataStructure = NumberCreator.createNumberArrayInt(numberOfElements[i]);
			key = Arrays.copyOf(dataStructure, dataStructure.length);
			sortedDataStructure = sortingAlgorithm.sort(dataStructure);			
			Arrays.sort(key);
								
			System.out.println("Sorting " + numberOfElements[i] + " elements using Quick sort. Correct: " + Arrays.equals(key, sortedDataStructure));
		}
		
		/* 
		 * Testing Java API sort on different number of elements and checks 
		 * if the result is correct. 
		 */		
		numberOfElements = new int[] {4000, 8000, 12000, 16000, 20000};
		sortingAlgorithm = new JavaAPISort();
		
		for(int i = 0; i < numberOfElements.length; i ++) {			
			dataStructure = NumberCreator.createNumberArrayInt(numberOfElements[i]);
			key = Arrays.copyOf(dataStructure, dataStructure.length);
			sortedDataStructure = sortingAlgorithm.sort(dataStructure);			
			Arrays.sort(key);
								
			System.out.println("Sorting " + numberOfElements[i] + " elements using JavaAPI sort. Correct: " + Arrays.equals(key, sortedDataStructure));
		}	
	}	
}