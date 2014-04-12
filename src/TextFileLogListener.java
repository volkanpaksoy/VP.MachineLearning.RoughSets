import java.io.*;

public class TextFileLogListener extends LogListener {

	public static String LogPath = "";
	
	private File outputFile = null;
	private FileWriter fileWriter = null;
	private BufferedWriter writer = null;
	
	
	public TextFileLogListener() {
		try {
			outputFile = new File(TextFileLogListener.LogPath);
			fileWriter = new FileWriter(outputFile);
			writer = new BufferedWriter(fileWriter);	
		} catch (IOException ex) {
			throw new ApplicationException("Error while opening file: " + ex.getMessage());
		}
	}
	
	@Override
	public void update(String message, boolean newLine) {
	
		try {
			writer.write(message);
			if (newLine) {
				writer.write("\n");
			}
			writer.flush();
		} catch (IOException ex1) {
			try {
				writer.close();
				fileWriter.close();
			}
			catch (IOException ex2) {
				throw new ApplicationException("Error while closing file: " + ex2.getMessage());
			}
		}
		
		
	}

}
