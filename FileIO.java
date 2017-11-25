import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class FileIO {

	public static void saveFile(String color, String path) {

		PrintStream w = null;
		try {
			File f = new File(path);
			w = new PrintStream(f);
			w.println(color);
		} catch (FileNotFoundException ex) {
		} finally {
			w.close();
		}
	}

	public static String loadFile(String path) {
		BufferedReader r = null;
		try {
			File file = new File(path);
			r = new BufferedReader(new FileReader(file));
			StringBuilder s = new StringBuilder();
			do {
				s.append(r.readLine() + ",");
			} while (r.readLine() != null);
			r.close();
			return s.toString();
		} catch (IOException ex) {
		}
		return null;
	}
}
