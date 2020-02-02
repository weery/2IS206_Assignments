package assignment_3;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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

		ListIterator<Integer> itFirst = numberList.listIterator();
		ListIterator<Integer> itLast = numberList.listIterator(numberList.size());
		Integer currentFirst = itFirst.next();
		Integer currentLast = itLast.previous();
		while (itFirst.nextIndex() < itLast.previousIndex()){
			sum += currentFirst * currentLast;
			currentFirst = itFirst.next();
			currentLast = itLast.previous();
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

		int currentIndex = 0;
		int size = numberList.size();
		ListIterator<Integer> itOuter = numberList.listIterator(currentIndex);
		currentIndex++;
		ListIterator<Integer> itInner = numberList.listIterator(currentIndex);
		boolean rightDir = true;
		while (itOuter.nextIndex() < size ){
			Integer currentOuter = itOuter.next();
			if (rightDir) {
				while (itInner.hasNext()) {
					sum += currentOuter * itInner.next();
				}
			} else {
				while (itInner.previousIndex() >= currentIndex){
					sum += currentOuter * itInner.previous();
				}
				if (itInner.hasNext()) {
					itInner.next();
				}
			}
			rightDir = !rightDir;
			currentIndex++;
		}

		return sum;		
	}
}