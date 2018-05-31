package MMTcode1;

import java.io.FileWriter;
import java.io.IOException;

public class Writetofile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileWriter writer = new FileWriter("MyFile.txt", true);
			writer.write("Hello World 123");
			writer.write("\r\n");	// write new line
			writer.write("Good Bye!");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



	}

