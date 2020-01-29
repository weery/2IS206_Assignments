package part_2.assignment_4;

import util.NumberCreator;
import util.StopWatch;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * AlgoSorting invokes sorting algorithms with different sized data structures.
 */
public class AlgoSorting {

	private static final int NUMBER_OF_ITERATIONS = 30;
	private static final String SAVE_LOCATION = "2IS206_Utilities\\python\\assignment_4_tmp\\";
	/**
	 * Program entry point. Invokes sorting algorithms with different sizes.
	 * @param args not used.
	 */
	public static void main(String[] args) {
		Sort sortingAlgorithm = null;
		StopWatch stopWatch = new StopWatch();
		int[] dataStructure;
		int[] numberOfElements;
		long time;
		List<Long> times = new ArrayList<>();
		List<Integer> elements = new ArrayList<>();
		String outputName = "";
					
		/* 
		 * Testing Insertion sort on different number of elements. 
		 */		
		numberOfElements = new int[] {40000, 80000, 120000, 160000, 200000};
		sortingAlgorithm = new InsertionSort();
		outputName = "InsertionSort.csv";
		times.clear();
		elements.clear();
		
		for(int i = 0; i < numberOfElements.length; i ++) {
			elements.add(numberOfElements[i]);
			time = 0;
			for (int t = 0; t < NUMBER_OF_ITERATIONS ; t++) {
				dataStructure = NumberCreator.createNumberArrayInt(numberOfElements[i]);
				stopWatch.start();
				sortingAlgorithm.sort(dataStructure);
				time += stopWatch.stop();
			}
			System.out.println("Sorting " + numberOfElements[i] + " elements using Insertion sort. Time: " + time/NUMBER_OF_ITERATIONS);
			times.add(time/NUMBER_OF_ITERATIONS);
		}
		writeToCsv(times, elements,outputName );
		
		/* 
		 * Testing Drake sort on different number of elements. 
		 */		
		numberOfElements = new int[] {40000000, 80000000, 120000000, 160000000, 200000000};
		sortingAlgorithm = new DrakeSort();
		outputName = "DrakeSort.csv";
		times.clear();
		elements.clear();

		for(int i = 0; i < numberOfElements.length; i ++) {
			elements.add(numberOfElements[i]);
			time = 0;
			for (int t = 0; t < NUMBER_OF_ITERATIONS ; t++) {
				dataStructure = NumberCreator.createNumberArrayInt(numberOfElements[i]);
				stopWatch.start();
				sortingAlgorithm.sort(dataStructure);
				time += stopWatch.stop();
			}
			System.out.println("Sorting " + numberOfElements[i] + " elements using Drake sort. Time: " + time/NUMBER_OF_ITERATIONS);
			times.add(time/NUMBER_OF_ITERATIONS);
		}
		writeToCsv(times, elements,outputName );

		/* 
		 * Testing Quick sort on different number of elements. 
		 */		
		numberOfElements = new int[] {4000000, 8000000, 12000000, 16000000, 20000000};
		sortingAlgorithm = new QuickSort();
		outputName = "QuickSort.csv";
		times.clear();
		elements.clear();

		for(int i = 0; i < numberOfElements.length; i ++) {
			elements.add(numberOfElements[i]);
			time = 0;
			for (int t = 0; t < NUMBER_OF_ITERATIONS ; t++) {
				dataStructure = NumberCreator.createNumberArrayInt(numberOfElements[i]);
				stopWatch.start();
				sortingAlgorithm.sort(dataStructure);
				time += stopWatch.stop();
			}
			System.out.println("Sorting " + numberOfElements[i] + " elements using Quick sort. Time: " + time/NUMBER_OF_ITERATIONS);
			times.add(time/NUMBER_OF_ITERATIONS);
		}
		writeToCsv(times, elements,outputName );

		/* 
		 * Testing Java API sort on different number of elements. 
		 */		
		numberOfElements = new int[] {4000000, 8000000, 12000000, 16000000, 20000000};
		sortingAlgorithm = new JavaAPISort();
		outputName = "JavaAPISort.csv";
		times.clear();
		elements.clear();

		for(int i = 0; i < numberOfElements.length; i ++) {
			elements.add(numberOfElements[i]);
			time = 0;
			for (int t = 0; t < NUMBER_OF_ITERATIONS ; t++) {
				dataStructure = NumberCreator.createNumberArrayInt(numberOfElements[i]);
				stopWatch.start();
				sortingAlgorithm.sort(dataStructure);
				time += stopWatch.stop();
			}
			System.out.println("Sorting " + numberOfElements[i] + " elements using JavaAPI sort. Time: " + time/NUMBER_OF_ITERATIONS);
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