package utility;


import org.apache.log4j.Logger;

public class Log {

	private static Logger Log = Logger.getLogger(Log.class.getName());

	// Info Level Logs
	public static void info(String message) {
		Log.info(message);
	}

	// Debug Level Logs
	public static void debug(String message) {
		Log.debug(message);
	}
}
