package assignment_3;

import java.util.List;

/**
 * Class containing method that tests execution time of algorithmic 
 * operations involving multiplication on Integers using different data structures. 
 */
public class AlgorithmAndDatastructure {	
	
	/**
	 * Construct a MultiplyAndDatastructure.
	 */
	public AlgorithmAndDatastructure() {	}
	
	/**
	 * Multiplies the first element from the beginning with the first element from 
	 * the end, the second element from the beginning with the second element from 
	 * the end etc and returns the sum of all multiplications. 
	 * 
	 * @param numberList a List containing Integers
	 * @return the sum
	 */
	public long multiplySome(List<Integer> numberList) {
		
		long sum = 0;

		// loop which iterates from both the beginning and the end of the list
		// the loop terminates when the indices passes each other, meaning
		// that the elements in list with an even number of elements is
		// used once only, and for an uneven list, the middle element is squared
		// in the final iteration
		for (int i = 0, j = numberList.size()-1;   i <= j; i++, j--){
			sum += numberList.get(i) * numberList.get(j);
		}

		return sum;		
	}	
	/**
	 * Multiplies all elements in the List with all the other elements 
	 * and returns the sum of all multiplications.  
	 * 
	 * @param numberList a List containing Integers
	 * @return the sum
	 */
	public long multiplyAll(List<Integer> numberList) {
		long sum = 0;

		for (int i = 0; i < numberList.size() -1; i++){
			for (int j = i+1; j < numberList.size(); j++){
				sum += numberList.get(i) * numberList.get(j);
			}
		}

		return sum;		
	}
}