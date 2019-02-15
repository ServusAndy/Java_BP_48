import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.concurrent.Flow;
import java.util.function.Consumer;

public class TestTryWithResource {
    public static void main(String[] args) throws IOException {
//        FileInputStream fis = new FileInputStream("test.txt");
//        try {
//            FileOutputStream fos = new FileOutputStream("mytest.txt");
//            try {
//                fis.transferTo(fos);
//            }finally {
//                fos.close();
//            }
//
//        }finally {
//            fis.close();
//        }

        try (FileInputStream in = new FileInputStream("test.txt");
             FileOutputStream out = new FileOutputStream("newtest.txt")) {
            in.transferTo(out);
        }

//        Consumer consumer = (v) -> System.out.println(v);

        BufferedReader reader = Files.newBufferedReader(Path.of("test.txt"));
        String line;
        ArrayList<String> strings = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            strings.add(line);
        }
        reader.close();
        strings.forEach(System.out::println);
    }
}
