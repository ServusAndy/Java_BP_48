import java.io.FileWriter;
import java.io.IOException;

public class TestIOFiles {
	public static void main(String[] args) throws IOException {
//		FileWriter fw = new FileWriter("myfile.txt",true);
//		fw.write("Hello world!");
//		fw.close();
		FileProvider fp = new FileProvider("myfile");
		for(int i = 0; i < 10; i++) {
			fp.write("new row " + i);
			if(i == 5) {
				throw new IllegalArgumentException();
			}
		}
		
		fp.close();
	}
}
