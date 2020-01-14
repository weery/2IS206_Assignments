package util;

/**
 * A simple stop watch.
 */
public class StopWatch {
	private long _time = 0;
	/**
	 * Construct a StopWatch.
	 */
	public StopWatch() {}
	/**
	 * Start the time. If a stop watch is already active it will reset the time and start again. 
	 */
	public void start() {		
		_time = System.currentTimeMillis();
	}
	/**
	 * Stop and return the time in milliseconds. If the method is invoked before the stop watch has been started it will return 0.
	 * @return time passed in milliseconds.
	 */
	public long stop() {
		long elapsedTime = System.currentTimeMillis() - _time;
		_time = 0;
		return elapsedTime;
	}
}