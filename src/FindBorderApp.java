import java.io.BufferedReader;
import java.io.InputStreamReader;


public class FindBorderApp {

	public static void main(String args[]) {
		
		SystemParameters params = XmlConfigReader.ReadConfig("Config.xml");
		TextFileLogListener.LogPath = params.getLogPath();
		
		ConsoleLogListener consoleListener = new ConsoleLogListener(); 
		Logger.attachListener(consoleListener);

		TextFileLogListener fileListener = new TextFileLogListener();
		Logger.attachListener(fileListener);
		
		Logger.logMessage("-------------------------");
		Logger.logMessage("FindBorder Implementation");
		Logger.logMessage("-------------------------");
		Logger.logMessage(params.toString());
		
		FindBorder fb = new FindBorder(params);
		fb.run();
		
		Logger.logMessage("FindBorder Algorithm completed");		
	}
	
	
}
