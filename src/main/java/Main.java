import tools.FileTools;
import tools.Renamer;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            List<Path> files = FileTools.getAllFiles("C:\\Users\\E439193\\Desktop\\test");

            for (Path path : files) {
                System.out.println(path.toString());
            }
            Renamer.replaceLocalNumber(files, 2, 3, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
