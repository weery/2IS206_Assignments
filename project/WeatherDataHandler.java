package project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Provides methods to retrieve temperature data from a weather station file.    
 */
public class WeatherDataHandler {

	private class Node{
		LocalDate date;
		LocalTime time;
		float value;
		boolean isApproved;

		@Override
		public String toString() {
			return "Node{" +
					"date=" + date +
					", time=" + time +
					", value=" + value +
					", isApproved=" + isApproved +
					'}';
		}
	}

	private List<Node> mNodeList = null;
	private int mListSize = 0;
	/**
	 * Load weather data from file.
	 * 
	 * @param filePath path to file with weather data
	 * @throws IOException if there is a problem while reading the file
	 */
	public void loadData(String filePath) throws IOException {
		//Read all weather data from file and create a node from each line
		List<String> fileData = Files.readAllLines(Paths.get(filePath));
		mNodeList = new ArrayList<>(fileData.size());
		for (String line : fileData){
			String[] segments = line.split(";");
			Node newNode = new Node();
			newNode.date = LocalDate.parse(segments[0]);
			newNode.time = LocalTime.parse(segments[1]);
			newNode.value = Float.parseFloat(segments[2]);
			newNode.isApproved = segments[3].equals("G") ? true : false;
			mNodeList.add(newNode);
		}
		mListSize = mNodeList.size();
	}
	/**
	 * Search for average temperature for all dates between the two dates (inclusive).
	 * Result is sorted by date.
	 * 
	 * @param dateFrom start date (YYYY-MM-DD) inclusive  
	 * @param dateTo end date (YYYY-MM-DD) inclusive
	 * @return average temperature for each date, sorted by date  
	 */
	public List<String> avarageTemperatures(LocalDate dateFrom, LocalDate dateTo) {
		List<String> averages = new ArrayList<>();
		int currentIndex = findFirstNodeOfDate(dateFrom);

		Node currentNode = mNodeList.get(currentIndex);
		while (!currentNode.date.isAfter(dateTo)){
			LocalDate currentDate = currentNode.date;
			float dateAvg = 0;
			int avgCounter = 0;
			while (currentNode.date.isEqual(currentDate)){
				dateAvg += currentNode.value;
				avgCounter++;
				currentIndex++;
				if (currentIndex == mListSize){
					break;
				}
				currentNode = mNodeList.get(currentIndex);
			}
			averages.add("" + dateAvg/avgCounter);
			if (currentIndex == mListSize){
				break;
			}
		}

		return averages;
	}

	/**
	 * Finds the index of the first node for the given date.
	 * Returns 0 if the entered date is before the first date in the given list.
	 * Returns index of the lsat element if the date is after the last date.
	 * @param date date of node to find (YYYY-MM-DD)
	 * @return the index of the first element with the selected date
	 */
	public int findFirstNodeOfDate(LocalDate date){
		int lower = 0,  upper = mListSize;

		// Check if the date is within the dates of the node list
		// if it is not, return the max or min index
		if (mNodeList.get(lower).date.isAfter(date)){
			return lower;
		} else if (mNodeList.get(upper).date.isBefore(date)){
			return upper;
		}

		while (true) {
			int currentIndex = (lower + upper)/2;
			// if we find the correct date, we need to iterate until we have the first of this date
			if (mNodeList.get(currentIndex).date.isEqual(date)) {
				while (currentIndex > 0) {
					if (mNodeList.get(currentIndex).date.isBefore(date)) {
						return currentIndex + 1;
					}
					currentIndex--;
				}
				return 0;
			} else if (mNodeList.get(currentIndex).date.isBefore(date)) {
				lower = currentIndex;
			}
			// do not really need this check, but will include it for clarity
			else if (mNodeList.get(currentIndex).date.isAfter(date)) {
				upper = currentIndex;
			}
		}
	}

	/**
	 * Search for missing values between the two dates (inclusive) assuming there 
	 * should be 24 measurement values for each day (once every hour). Result is
	 * sorted by date.
	 * 
	 * @param dateFrom start date (YYYY-MM-DD) inclusive  
	 * @param dateTo end date (YYYY-MM-DD) inclusive
	 * @return dates with missing values together with number of missing values for each date, sorted by date
	 */
	public List<String> missingValues(LocalDate dateFrom, LocalDate dateTo) {
		List<String> missing = new ArrayList<>();
		int currentIndex = findFirstNodeOfDate(dateFrom);

		Node currentNode = mNodeList.get(currentIndex);
		while (!currentNode.date.isAfter(dateTo)){
			LocalDate currentDate = currentNode.date;

			// assume that the entry is missing until proven othervise. start with 24 missed entries
			// and subtract this counter for each entry found during this day
			int missingCounter = 24;
			while (currentNode.date.isEqual(currentDate)){
				missingCounter--;
				currentIndex++;
				if (currentIndex == mListSize){
					break;
				}
				currentNode = mNodeList.get(currentIndex);
			}
			missing.add("" + currentDate.toString() + " missing values: " + missingCounter);
			if (currentIndex == mListSize){
				break;
			}
		}

		return missing;
	}
	/**
	 * Search for percentage of approved values between the two dates (inclusive).
	 * 
	 * @param dateFrom start date (YYYY-MM-DD) inclusive  
	 * @param dateTo end date (YYYY-MM-DD) inclusive
	 * @return period and percentage of approved values for the period  
	 */
	public List<String> approvedValues(LocalDate dateFrom, LocalDate dateTo) {
		List<String> approved = new ArrayList<>();
		int currentIndex = findFirstNodeOfDate(dateFrom);

		float values = 0;
		float approvedVals = 0;
		Node currentNode = mNodeList.get(currentIndex);
		while (!currentNode.date.isAfter(dateTo)){
			values ++;
			if (currentNode.isApproved){
				approvedVals++;
			}
			currentIndex++;
			if (currentIndex == mListSize){
				break;
			}
			currentNode = mNodeList.get(currentIndex);
		}

		approved.add(dateFrom.toString() + " to " + dateTo.toString() + " " + approvedVals / values  * 100 + "% approved values!");

		return approved;
	}	
}