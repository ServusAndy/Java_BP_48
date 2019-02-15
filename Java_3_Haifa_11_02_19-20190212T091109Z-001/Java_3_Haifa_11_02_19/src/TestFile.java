import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class TestFile {

	public static void main(String[] args) throws IOException {
		File file = new File("test.txt");
		if(!file.exists()) {
			System.out.println(file.createNewFile());
		}

		System.out.println(file.isFile());
		File file1 = new File("mydir");
		System.out.println(file1.mkdir());
		File dir2 = new File("dir1/dir2/dir3");
		System.out.println(dir2.mkdirs());
		
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());
		
		File root = new File(".");
		String[] names = root.list();
		Arrays.asList(names).forEach(System.out::println);
		File nextFile = new File(root.getAbsolutePath());
		
		String parentRoot = root.getParent();
		System.out.println(parentRoot);
		
		File parentFile = nextFile.getParentFile();
		System.out.println(parentFile);
		
		File deleteDir = new File("dir1");
		if(deleteDir.exists()) {
			System.out.println(deleteDir.delete());
		}
		
		
		
	}

}
