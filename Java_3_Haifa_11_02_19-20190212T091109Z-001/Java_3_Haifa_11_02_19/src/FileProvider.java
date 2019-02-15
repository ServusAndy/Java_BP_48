import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProvider {
	private FileReader fr;
	private FileWriter fw;
	
	public FileProvider(String path) throws IOException {
		fw = new FileWriter(path,true);
	}
	public void write(String line) throws IOException {
		fw.write(line + "\n");
	}
	
	public void close() throws IOException {
		fw.close();
	}
	
	@Override
	protected void finalize() throws Throwable {
		fw.close();
		super.finalize();
	}

}
