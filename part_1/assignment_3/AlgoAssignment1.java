package part_1.assignment_3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import com.sun.source.doctree.SummaryTree;
import util.NumberCreator;
import util.StopWatch;
/**
 * AlgoAssignment1 invokes algorithms with different size and type of data structure.
 */
public class AlgoAssignment1 {

	private static final int NUMBER_OF_ITERATIONS = 20;
	private static final String SAVE_LOCATION = "2IS206_Utilities\\python\\assignment_3\\";

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
		List<Long> times = new ArrayList<>();
		List<Integer> elements = new ArrayList<>();
		String outputName = "";
				
		/* 
		 * Testing the method multiplyAll with different number of elements
		 * using the data structure ArrayList. 
		 */		
		numberOfElements = new int[] {2500, 5000, 10000, 20000, 40000, 80000, 120000, 160000, 200000};
		outputName = "multiplyAll_ArrayList.csv";
		times.clear();
		elements.clear();
		
		for(int i = 0; i < numberOfElements.length; i ++) {
			//dataStructure = new ArrayList<Integer>(NumberCreator.createNumberList(numberOfElements[i]));
			dataStructure = NumberCreator.createNumberArray(numberOfElements[i], false);
			elements.add(numberOfElements[i]);
			stopWatch.start();
			for (int t = 0; t < NUMBER_OF_ITERATIONS ; t++) {
				sum = test.multiplyAll(dataStructure);
			}
			time = stopWatch.stop();
			System.out.println("Multiply all with " + numberOfElements[i] + " elements in ArrayList. Sum: " + sum + " Time: " + time / (NUMBER_OF_ITERATIONS) );
			times.add(time/ (NUMBER_OF_ITERATIONS));
		}
		writeToCsv(times, elements,outputName );
		
		/* 
		 * Testing the method multiplyAll with different number of elements
		 * using the data structure LinkedList. 
		 */		
		numberOfElements = new int[] {500, 1000, 1500, 2000, 2500, 3000, 3500};
		outputName = "multiplyAll_LinkedList.csv";
		times.clear();
		elements.clear();
		
		for(int i = 0; i < numberOfElements.length; i ++) {
			//dataStructure = new LinkedList<Integer>(NumberCreator.createNumberList(numberOfElements[i]));
			dataStructure = NumberCreator.createNumberArray(numberOfElements[i], true);
			elements.add(numberOfElements[i]);
			stopWatch.start();
			for (int t = 0; t < NUMBER_OF_ITERATIONS ; t++) {
				sum = test.multiplyAll(dataStructure);
			}
			time = stopWatch.stop();		
			System.out.println("Multiply all with " + numberOfElements[i] + " elements in LinkedList. Sum: " + sum + " Time: " + time / NUMBER_OF_ITERATIONS);
			times.add(time/NUMBER_OF_ITERATIONS);
		}
		writeToCsv(times, elements,outputName );
		
		/* 
		 * Testing the method multiplySome with different number of elements
		 * using the data structure ArrayList. 
		 */	
		numberOfElements = new int[] {50000000, 100000000, 150000000,
				200000000, 250000000, 300000000, 350000000, 400000000};

		outputName = "multiplySome_ArrayList.csv";
		times.clear();
		elements.clear();
		for(int i = 0; i < numberOfElements.length; i ++) {
			try {
				//dataStructure = new ArrayList<Integer>(NumberCreator.createNumberList(numberOfElements[i]));
				dataStructure = NumberCreator.createNumberArray(numberOfElements[i], false);
				elements.add(numberOfElements[i]);
				stopWatch.start();
				for (int t = 0; t < NUMBER_OF_ITERATIONS ; t++) {
					sum = test.multiplySome(dataStructure);
				}
				time = stopWatch.stop();
				System.out.println("Multiply some with " + numberOfElements[i] + " elements in ArrayList. Sum: " + sum + " Time: " + time/ NUMBER_OF_ITERATIONS);
				times.add(time/NUMBER_OF_ITERATIONS);
			} catch (OutOfMemoryError  e){
				e.printStackTrace();
			}
		}
		writeToCsv(times, elements,outputName );
	
		/* 
		 * Testing the method multiplySome with different number of elements
		 * using the data structure LinkedList. 
		 */			
		numberOfElements = new int[] {50000, 100000, 150000, 200000, 250000, 300000, 350000};
		outputName = "multiplySome_LinkedList.csv";
		times.clear();
		elements.clear();
		
		for(int i = 0; i < numberOfElements.length; i ++) {	
			//dataStructure = new LinkedList<Integer>(NumberCreator.createNumberList(numberOfElements[i]));
			dataStructure = NumberCreator.createNumberArray(numberOfElements[i], true);
			elements.add(numberOfElements[i]);
			stopWatch.start();
			for (int t = 0; t < NUMBER_OF_ITERATIONS ; t++) {
				sum = test.multiplySome(dataStructure);
			}
			time = stopWatch.stop();		
			System.out.println("Multiply some with " + numberOfElements[i] + " elements in LinkedList. Sum: " + sum + " Time: " + time/ NUMBER_OF_ITERATIONS);
			times.add(time/NUMBER_OF_ITERATIONS);
		}
		writeToCsv(times, elements,outputName );


	}

	public static void writeToCsv(List<Long> times, List<Integer> elements, String filename){
		File csvFile = new File(SAVE_LOCATION+filename);
		try {
			FileWriter fileWriter = new FileWriter(csvFile, false);
			Iterator it = times.iterator();
			Iterator it2 = elements.iterator();
			while(it.hasNext() && it2.hasNext()){
				fileWriter.write(it.next().toString());
				fileWriter.write(", ");
				fileWriter.write(it2.next().toString());
				fileWriter.write("\n");
			}
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}