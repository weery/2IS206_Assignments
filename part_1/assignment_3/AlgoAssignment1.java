package part_1.assignment_3;

import java.util.*;

import com.sun.source.doctree.SummaryTree;
import util.NumberCreator;
import util.StopWatch;
/**
 * AlgoAssignment1 invokes algorithms with different size and type of data structure.
 */
public class AlgoAssignment1 {

	private static final int NUMBER_OF_ITERATIONS = 10;
	/**
	 * Program entry point. Invokes algorithms with different size 
	 * and type of data structure.
	 * @param args not used.
	 */
	public static void main(String[] args) {
		AlgorithmAndDatastructure test = new AlgorithmAndDatastructure();
		StopWatch stopWatch = new StopWatch();
		List<Integer> dataStructure;
		int[] numberOfElements;
		long sum = 0, time;
				
		/* 
		 * Testing the method multiplyAll with different number of elements
		 * using the data structure ArrayList. 
		 */		
		numberOfElements = new int[] {40000, 80000, 120000, 160000, 200000};
		
		for(int i = 0; i < numberOfElements.length; i ++) {
			dataStructure = new ArrayList<Integer>(NumberCreator.createNumberList(numberOfElements[i]));
			stopWatch.start();
			for (int t = 0; t < NUMBER_OF_ITERATIONS ; t++) {
				sum = test.multiplyAll(dataStructure);
			}
			time = stopWatch.stop();
			System.out.println("Multiply all with " + numberOfElements[i] + " elements in ArrayList. Sum: " + sum + " Time: " + time / NUMBER_OF_ITERATIONS );
		}	
		
		/* 
		 * Testing the method multiplyAll with different number of elements
		 * using the data structure LinkedList. 
		 */		
		numberOfElements = new int[] {1000, 1500, 2000, 2500, 3000};
		
		for(int i = 0; i < numberOfElements.length; i ++) {	
			dataStructure = new LinkedList<Integer>(NumberCreator.createNumberList(numberOfElements[i]));
			stopWatch.start();
			for (int t = 0; t < NUMBER_OF_ITERATIONS ; t++) {
				sum = test.multiplyAll(dataStructure);
			}
			time = stopWatch.stop();		
			System.out.println("Multiply all with " + numberOfElements[i] + " elements in LinkedList. Sum: " + sum + " Time: " + time / NUMBER_OF_ITERATIONS);
		}	
		
		/* 
		 * Testing the method multiplySome with different number of elements
		 * using the data structure ArrayList. 
		 */	
		numberOfElements = new int[] {100000000, 150000000, 200000000, 250000000, 300000000};
		
		for(int i = 0; i < numberOfElements.length; i ++) {
			try {
				dataStructure = new ArrayList<Integer>(NumberCreator.createNumberList(numberOfElements[i]));
				stopWatch.start();
				for (int t = 0; t < NUMBER_OF_ITERATIONS ; t++) {
					sum = test.multiplySome(dataStructure);
				}
				time = stopWatch.stop();
				System.out.println("Multiply some with " + numberOfElements[i] + " elements in ArrayList. Sum: " + sum + " Time: " + time/ NUMBER_OF_ITERATIONS);
			} catch (OutOfMemoryError  e){
				e.printStackTrace();
			}
		}	
	
		/* 
		 * Testing the method multiplySome with different number of elements
		 * using the data structure LinkedList. 
		 */			
		numberOfElements = new int[] {50000, 100000, 150000, 200000, 250000};
		
		for(int i = 0; i < numberOfElements.length; i ++) {	
			dataStructure = new LinkedList<Integer>(NumberCreator.createNumberList(numberOfElements[i]));
			stopWatch.start();
			for (int t = 0; t < NUMBER_OF_ITERATIONS ; t++) {
				sum = test.multiplySome(dataStructure);
			}
			time = stopWatch.stop();		
			System.out.println("Multiply some with " + numberOfElements[i] + " elements in LinkedList. Sum: " + sum + " Time: " + time/ NUMBER_OF_ITERATIONS);
		}		
	}
}