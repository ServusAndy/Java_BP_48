import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestConsole {

	public static void main(String[] args) throws IOException {
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
//		int bytesCount = is.read();
		int i = isr.read();
		char first = (char) i;
		String line = br.readLine();
		System.out.println("read = " + first);
		System.out.println("libne = " + line);
		System.out.println("End main");

	}
	
	

}
