package MMTcode1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		try {
		FileReader reader = new FileReader("MyFile.txt");
		int character;
		while ((character = reader.read()) != -1) {
			System.out.print((char) character);
		}
		reader.close();

	} catch (IOException e) {
		e.printStackTrace();
	}


	}
}
		




