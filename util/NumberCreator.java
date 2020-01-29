package util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * Simple class to help construct a List with Integer values repeating the number pattern 0 to 9.
 */
public class NumberCreator {
	/**
	 * Create a List of Integer values repeating the number pattern 0 to 9.
	 * 
	 * @param length the length of the List, i.e. the number of numbers we want to generate.
	 * @return a List with Integers repeating the number pattern 0 to 9.
	 */
	public static final List<Integer> createNumberList(int length) {
		List<Integer> numberList = new ArrayList<Integer>(length);
				
		for(int i = 0; i < length; i ++) {
			numberList.add(i % 10);
		}		
		return numberList;
	}
	/**
	 * Create an Array of integer values repeating the number pattern 0 to 9.
	 * 
	 * @param length the length of the array, i.e. the number of numbers we want to generate.
	 * @return an array with integers repeating the number pattern 0 to 9.
	 */
	public static final Integer[] createNumberArray(int length) {
		Integer[] numberArray = new Integer[length];
				
		for(int i = 0; i < length; i ++) {
			numberArray[i] = i % 10;
		}		
		return numberArray;
	}

	public static final List<Integer> createNumberArray(int length, boolean isLinked){
		List<Integer> list;
		if (isLinked){
			list = new LinkedList<>();
		} else {
			list = new ArrayList<>(length);
		}
		for(int i = 0; i < length; i ++) {
			list.add(i % 10);
		}
		return list;
	}

	/**
	 * Create an Array of integer values repeating the number pattern 0 to 9.
	 *
	 * @param length the number of numbers we want to generate.
	 * @return an array with integers repeating the number pattern 0 to 9.
	 */
	public static final int[] createNumberArrayInt(int length) {
		int[] numberArray = new int[length];

		for(int i = 0; i < length; i ++) {
			numberArray[i] = i % 10;
		}
		return numberArray;
	}
}